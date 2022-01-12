/*
* Copyright 2015-2022-01-12 OpenCB
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package org.opencb.opencga.app.cli.main;

import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import org.apache.commons.lang3.StringUtils;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;


/*
* WARNING: AUTOGENERATED CODE
*
* This code was generated by a tool.
* Autogenerated on: 2022-01-12
*
* Manual changes to this file may cause unexpected behavior in your application.
* Manual changes to this file will be overwritten if the code is regenerated.
*    Command line version: 2.2.0-SNAPSHOT
*    Command line commit: 1584b40c66594a79d369d1c7446137d24faded53
*/

public abstract class OpenCgaCompleter implements Completer {

    protected List<Candidate> commands = asList("login","logout","help","use","variant","projects","panels","clinical","jobs","individuals","families","users","samples","alignments","meta","studies","files","operations","cohorts")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> variantList = asList( "aggregationStats","metadata-annotation","query-annotation","run-circos","delete-cohort-stats","info-cohort-stats","run-cohort-stats","run-export","genotypes-family","run-family-qc","delete-file","run-gatk","run-genomePlot","run-gwas","run-index","run-individual-qc","run-inferredSex","query-knockout-gene","query-knockout-individual","run-knockout","run-mendelianError","metadata","query-mutationalSignature","run-mutationalSignature","run-plink","query","run-relatedness","run-rvtests","aggregationStats-sample","run-sample-eligibility","run-sample-qc","query-sample","run-sample","query-sample-stats","run-sample-stats","run-stats-export","run-stats")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> projectsList = asList( "create","search","aggregationStats","info","studies","update")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> panelsList = asList( "update-acl","create","distinct","search","acl","delete","info","update")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> clinicalList = asList( "update-acl","update-clinical-configuration","create","distinct","distinct-interpretation","search-interpretation","info-interpretation","run-interpreter-cancerTiering","run-interpreter-team","run-interpreter-tiering","run-interpreter-zetta","aggregationStats-rga","query-rga-gene","summary-rga-gene","run-rga-index","query-rga-individual","summary-rga-individual","query-rga-variant","summary-rga-variant","search","actionable-variant","query-variant","acl","delete","update","info","create-interpretation","delete-interpretation","update-interpretation")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> jobsList = asList( "update-acl","aggregationStats","create","distinct","retry","search","top","acl","delete","info","update","head-log","tail-log")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> individualsList = asList( "update-acl","aggregationStats","load-annotationSets","create","distinct","search","acl","delete","info","update","relatives")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> familiesList = asList( "update-acl","aggregationStats","load-annotationSets","create","distinct","search","acl","delete","info","update")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> usersList = asList( "create","login","password","info","configs","update-configs","filters","reset-password","projects","update")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> samplesList = asList( "update-acl","aggregationStats","load-annotationSets","create","distinct","load","search","acl","delete","info","update")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> alignmentsList = asList( "run-bwa","run-coverage-index","run-qc-geneCoverageStats","query-coverage","ratio-coverage","stats-coverage","run-deeptools","run-fastqc","run-index","run-picard","run-qc","query","run-samtools")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> metaList = asList( "api")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> studiesList = asList( "update-acl","create","search","acl","aggregationStats","info","search-audit","groups","update-groups","update-users","permissionRules","update-permissionRules","run-templates","delete-templates","update","variableSets","update-variableSets","update-variables")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> filesList = asList( "update-acl","aggregationStats","load-annotationSets","create","distinct","fetch","link","run-link","run-postlink","search","acl","delete","info","unlink","update","download","grep","head","image","refresh","tail","list","tree")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> operationsList = asList( "configure-cellbase","aggregate-variant","delete-variant-annotation","index-variant-annotation","save-variant-annotation","configure-variant","delete-variant","aggregate-variant-family","index-variant-family","index-variant","launcher-variant-index","run-variant-julie","repair-variant-metadata","synchronize-variant-metadata","delete-variant-sample","index-variant-sample","delete-variant-score","index-variant-score","secondaryIndex-variant","delete-variant-secondaryIndex","index-variant-stats","delete-variant-study")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    private List<Candidate> cohortsList = asList( "update-acl","aggregationStats","load-annotationSets","create","distinct","generate","search","acl","delete","info","update")
            .stream()
            .map(Candidate::new)
            .collect(toList());

    @Override
    public void complete(LineReader lineReader, ParsedLine parsedLine, List<Candidate> candidates) {
        String command = parsedLine.line().trim();
        if (StringUtils.isEmpty(command)) {
            candidates.addAll(commands);
            return;
        }
        Map<String, List<Candidate>> mapCandidates=new HashMap();
        mapCandidates.put( "variant", variantList);
        mapCandidates.put( "projects", projectsList);
        mapCandidates.put( "panels", panelsList);
        mapCandidates.put( "clinical", clinicalList);
        mapCandidates.put( "jobs", jobsList);
        mapCandidates.put( "individuals", individualsList);
        mapCandidates.put( "families", familiesList);
        mapCandidates.put( "users", usersList);
        mapCandidates.put( "samples", samplesList);
        mapCandidates.put( "alignments", alignmentsList);
        mapCandidates.put( "meta", metaList);
        mapCandidates.put( "studies", studiesList);
        mapCandidates.put( "files", filesList);
        mapCandidates.put( "operations", operationsList);
        mapCandidates.put( "cohorts", cohortsList);
         candidates.addAll(checkCandidates(mapCandidates,command)); 
     }
    public abstract List<Candidate> checkCandidates(Map<String, List<Candidate>> candidatesMap,String line);    
}