package org.opencb.opencga.core.models.sample;

import org.opencb.opencga.core.models.common.InternalStatus;

import java.util.Objects;

public class SampleInternalVariantSecondaryIndex {

    private InternalStatus status;

    public SampleInternalVariantSecondaryIndex() {
    }

    public SampleInternalVariantSecondaryIndex(InternalStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SampleInternalVariantSecondaryIndex{");
        sb.append("status=").append(status);
        sb.append('}');
        return sb.toString();
    }

    public InternalStatus getStatus() {
        return status;
    }

    public SampleInternalVariantSecondaryIndex setStatus(InternalStatus status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SampleInternalVariantSecondaryIndex that = (SampleInternalVariantSecondaryIndex) o;
        return Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status);
    }
}
