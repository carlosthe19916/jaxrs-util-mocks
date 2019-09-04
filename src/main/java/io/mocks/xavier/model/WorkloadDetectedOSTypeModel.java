package io.mocks.xavier.model;

public class WorkloadDetectedOSTypeModel {

    private Integer total;
    private String osName;

    public WorkloadDetectedOSTypeModel(){}
    public WorkloadDetectedOSTypeModel(String osName, Integer total){
        this.osName = osName;
        this.total = total;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }
}
