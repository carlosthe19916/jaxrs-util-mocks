package io.mocks.xavier.model;

import java.util.List;
import java.util.Map;

public class WorkloadSummary {

    private List<Summary> summary;
    private Complexity complexity;
    private Map<String, Long> targetsRecommendation;
    private Map<String, Long> workloadsDetected;
    private List<ScanRun> scanRuns;

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

    public Map<String, Long> getTargetsRecommendation() {
        return targetsRecommendation;
    }

    public void setTargetsRecommendation(Map<String, Long> targetsRecommendation) {
        this.targetsRecommendation = targetsRecommendation;
    }

    public Map<String, Long> getWorkloadsDetected() {
        return workloadsDetected;
    }

    public void setWorkloadsDetected(Map<String, Long> workloadsDetected) {
        this.workloadsDetected = workloadsDetected;
    }

    public List<ScanRun> getScanRuns() {
        return scanRuns;
    }

    public void setScanRuns(List<ScanRun> scanRuns) {
        this.scanRuns = scanRuns;
    }
}
