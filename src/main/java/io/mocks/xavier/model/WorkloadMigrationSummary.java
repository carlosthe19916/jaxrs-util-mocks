package io.mocks.xavier.model;

import java.util.List;

public class WorkloadMigrationSummary {

    private List<Summary> summary;
    private Complexity complexity;

    public List<Summary> getSummary() {
        return summary;
    }

    public void setSummary(List<Summary> summary) {
        this.summary = summary;
    }

    public Complexity getComplexity() {
        return complexity;
    }

    public void setComplexity(Complexity complexity) {
        this.complexity = complexity;
    }
}
