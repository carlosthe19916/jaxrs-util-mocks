package io.mocks.xavier.model;

public class WorkloadDetected {

    private String workload;
    private String osName;
    private Long clusters;
    private Long vms;

    public WorkloadDetected() {}

    public WorkloadDetected(String workload, String osName, Long clusters, Long vms) {
        this.workload = workload;
        this.osName = osName;
        this.clusters = clusters;
        this.vms = vms;
    }

    public String getWorkload() {
        return workload;
    }

    public void setWorkload(String workload) {
        this.workload = workload;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public Long getClusters() {
        return clusters;
    }

    public void setClusters(Long clusters) {
        this.clusters = clusters;
    }

    public Long getVms() {
        return vms;
    }

    public void setVms(Long vms) {
        this.vms = vms;
    }
}
