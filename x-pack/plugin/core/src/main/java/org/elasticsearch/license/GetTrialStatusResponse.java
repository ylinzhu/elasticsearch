/*
 * Copyright Elasticsearch B.V. and/or licensed to Elasticsearch B.V. under one
 * or more contributor license agreements. Licensed under the Elastic License;
 * you may not use this file except in compliance with the Elastic License.
 */
package org.elasticsearch.license;

import org.elasticsearch.action.ActionResponse;
import org.elasticsearch.common.io.stream.StreamInput;
import org.elasticsearch.common.io.stream.StreamOutput;
import org.elasticsearch.common.xcontent.ToXContentObject;
import org.elasticsearch.common.xcontent.XContentBuilder;

import java.io.IOException;
import java.util.Objects;

public class GetTrialStatusResponse extends ActionResponse implements ToXContentObject {

    private boolean eligibleToStartTrial;

    GetTrialStatusResponse() {
    }

    public GetTrialStatusResponse(boolean eligibleToStartTrial) {
        this.eligibleToStartTrial = eligibleToStartTrial;
    }

    boolean isEligibleToStartTrial() {
        return eligibleToStartTrial;
    }

    @Override
    public void readFrom(StreamInput in) throws IOException {
        eligibleToStartTrial = in.readBoolean();
    }

    @Override
    public void writeTo(StreamOutput out) throws IOException {
        out.writeBoolean(eligibleToStartTrial);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetTrialStatusResponse that = (GetTrialStatusResponse) o;
        return eligibleToStartTrial == that.eligibleToStartTrial;
    }

    @Override
    public int hashCode() {
        return Objects.hash(eligibleToStartTrial);
    }

    @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.startObject();
        builder.field("eligible_to_start_trial", eligibleToStartTrial);
        builder.endObject();
        return builder;
    }
}
