package io.mocks.xavier.model;

import java.util.List;
import java.util.Map;

public class WorkloadSummary {

    private List<Summary> summaryModels;
    private Complexity complexityModel;
    private Map<String, Long> recommendedTargetsIMSModel;
    private Map<String, Long> workloadOsTypesDetectedModel;
    private List<ScanRun> scanRunModels;

    public List<Summary> getSummaryModels() {
        return summaryModels;
    }

    public void setSummaryModels(List<Summary> summaryModels) {
        this.summaryModels = summaryModels;
    }

    public Complexity getComplexityModel() {
        return complexityModel;
    }

    public void setComplexityModel(Complexity complexityModel) {
        this.complexityModel = complexityModel;
    }

    public Map<String, Long> getRecommendedTargetsIMSModel() {
        return recommendedTargetsIMSModel;
    }

    public void setRecommendedTargetsIMSModel(Map<String, Long> recommendedTargetsIMSModel) {
        this.recommendedTargetsIMSModel = recommendedTargetsIMSModel;
    }

    public Map<String, Long> getWorkloadOsTypesDetectedModel() {
        return workloadOsTypesDetectedModel;
    }

    public void setWorkloadOsTypesDetectedModel(Map<String, Long> workloadOsTypesDetectedModel) {
        this.workloadOsTypesDetectedModel = workloadOsTypesDetectedModel;
    }

    public List<ScanRun> getScanRunModels() {
        return scanRunModels;
    }

    public void setScanRunModels(List<ScanRun> scanRunModels) {
        this.scanRunModels = scanRunModels;
    }
}
