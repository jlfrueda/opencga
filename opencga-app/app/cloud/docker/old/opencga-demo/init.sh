#!/bin/bash

# ------------ Start MongoDB ----------------
mongod --dbpath /data/opencga/mongodb --replSet rs0  &
status=$?
if [ $status -ne 0 ]; then
  echo "Failed to start mongoDB: $status"
  exit $status
fi
sleep 10

mongo /opt/opencga/demo/mongo-cluster-init.js
sleep 20

# ------------ Start SOLR ------------------
cat >> /opt/solr/bin/solr.in.sh << EOF
# OpenCGA
SOLR_DATA_HOME=/data/opencga/solr
EOF

/opt/solr/bin/solr start -cloud -force
status=$?
if [ $status -ne 0 ]; then
  echo "Failed to start Solr: $status"
  exit $status
fi

/opt/solr/bin/solr status
sleep 2
chmod +x /opt/opencga/misc/solr/install.sh
/opt/opencga/misc/solr/install.sh

function requiredVariable() {
  key=$1
  value=$2
  if [ -z "${value}" ]; then
    echo "Missing env var $key"
    exit 1
  fi
}

if find /opt/opencga/libs/opencga-storage-hadoop-deps-* &> /dev/null ; then
    requiredVariable "HADOOP_SSH_HOST" "${HADOOP_SSH_HOST}"
    requiredVariable "HADOOP_SSH_USER" "${HADOOP_SSH_USER}"
    if [ -z "${HADOOP_SSH_KEY}" ] && [ -z "${HADOOP_SSH_PASS}" ]; then
      echo "Missing HADOOP_SSH_KEY or HADOOP_SSH_PASS var"
      exit 1
    fi
    if [ ! -z "${HADOOP_SSH_KEY}" ] && [ ! -f "${HADOOP_SSH_KEY}" ]; then
      echo "Cannot access '${HADOOP_SSH_KEY}': No such file or directory"
      exit 1
    fi

    export INIT_HADOOP_SSH_DNS=${HADOOP_SSH_HOST}
    export INIT_HADOOP_SSH_USER=${HADOOP_SSH_USER}
    export INIT_HADOOP_SSH_PASS=${HADOOP_SSH_PASS:-}
    export INIT_HADOOP_SSH_KEY=${HADOOP_SSH_KEY:-}
    export INIT_HADOOP_SSH_REMOTE_OPENCGA_HOME=${HADOOP_SSH_REMOTE_OPENCGA_HOME:-"opencga-demo"}

    echo "-- Configure hadoop --"
    /opt/opencga/init/setup-hadoop.sh
fi

ADMIN_PASSWORD='adminOpencga2021.'
CONTAINER_ALREADY_STARTED="CONTAINER_ALREADY_STARTED"
if [ ! -e $CONTAINER_ALREADY_STARTED ] && [ "$installCatalog" != "false" ]; then

    export INIT_DATABASE_PREFIX="opencga-demo"
    export INIT_SEARCH_HOSTS=http://localhost:8983/solr/
    export INIT_CLINICAL_HOSTS=http://localhost:8983/solr/
    export INIT_CATALOG_DATABASE_HOSTS=localhost:27017
    export INIT_CATALOG_DATABASE_USER=""
    export INIT_CATALOG_DATABASE_PASSWORD=""
    export INIT_CATALOG_DATABASE_SSL="false"
    export INIT_CATALOG_SEARCH_HOSTS=http://localhost:8983/solr/
    export INIT_REST_HOST="http://localhost:9090/$(ls ../opencga*.war | rev | cut -d "." -f 2- | rev | xargs basename)"
    export INIT_GRPC_HOST="localhost:9091"

    if find /opt/opencga/libs/opencga-storage-hadoop-deps-* &> /dev/null ; then
      export INIT_VARIANT_DEFAULT_ENGINE="hadoop"
      export INIT_VARIANT_OPTIONS="[expected_files_number=1,storage.hadoop.variant.table.preSplit.numSplits=5,storage.hadoop.archive.table.preSplit.splitsPerBatch=5]"
    else
      export INIT_VARIANT_DEFAULT_ENGINE="mongodb"
    fi
    export INIT_MAX_CONCURRENT_JOBS="1"
    python3 /opt/opencga/init/override_yaml.py --save

    echo "-- Installing Catalog --"
    echo "$ADMIN_PASSWORD" | /opt/opencga/bin/opencga-admin.sh catalog install
    status=$?
        if [ $status -ne 0 ]; then
          echo "Failed to install Catalog : $status"
          exit $status
        fi
    touch $CONTAINER_ALREADY_STARTED
    sleep 5
    echo "Start rest server"
    echo "$ADMIN_PASSWORD" | /opt/opencga/bin/opencga-admin.sh server rest --start &
    status=$?
    if [ $status -ne 0 ]; then
      echo "Failed to start REST server: $status"
      exit $status
    fi
    until curl $INIT_REST_HOST'/webservices/rest/v2/meta/status' &> /dev/null
    do
      echo "Waiting for REST server"
      sleep 1
    done


    if [ "$load" == "true" ]; then
      /opt/opencga/demo/load-demo.sh "$ADMIN_PASSWORD"
    fi
else
    echo "Start rest server"
    echo "$ADMIN_PASSWORD" | /opt/opencga/bin/opencga-admin.sh server rest --start &
fi

echo "Start master service"
echo "$ADMIN_PASSWORD" | ./opencga-admin.sh catalog daemon --start

