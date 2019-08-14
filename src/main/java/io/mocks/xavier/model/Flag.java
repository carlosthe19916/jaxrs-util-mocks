package io.mocks.xavier.model;

public class Flag {

    private String flag;
    private String assessment;
    private String osName;
    private Long clusters;
    private Long vms;

    public Flag() {}

    public Flag(String flag,String assessment, String osName, Long clusters, Long vms) {
        this.flag = flag;
        this.assessment = assessment;
        this.osName = osName;
        this.clusters = clusters;
        this.vms = vms;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
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
