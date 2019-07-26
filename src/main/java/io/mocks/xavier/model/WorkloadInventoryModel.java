package io.mocks.xavier.model;

import java.util.List;

public class WorkloadInventoryModel {

    private String provider;
    private String datacenter;
    private String cluster;
    private String vmName;
    private List<String> workloads;
    private String osName;
    private String osDescription;
    private String complexity;
    private List<String> recommendedTargetsIMS;
    private List<String> flagIMS;
    private Long diskSpace;
    private Long memory;
    private Long cpuCores;

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getDatacenter() {
        return datacenter;
    }

    public void setDatacenter(String datacenter) {
        this.datacenter = datacenter;
    }

    public String getCluster() {
        return cluster;
    }

    public void setCluster(String cluster) {
        this.cluster = cluster;
    }

    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        this.vmName = vmName;
    }

    public List<String> getWorkloads() {
        return workloads;
    }

    public void setWorkloads(List<String> workloads) {
        this.workloads = workloads;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getOsDescription() {
        return osDescription;
    }

    public void setOsDescription(String osDescription) {
        this.osDescription = osDescription;
    }

    public String getComplexity() {
        return complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }

    public List<String> getRecommendedTargetsIMS() {
        return recommendedTargetsIMS;
    }

    public void setRecommendedTargetsIMS(List<String> recommendedTargetsIMS) {
        this.recommendedTargetsIMS = recommendedTargetsIMS;
    }

    public List<String> getFlagIMS() {
        return flagIMS;
    }

    public void setFlagIMS(List<String> flagIMS) {
        this.flagIMS = flagIMS;
    }

    public Long getDiskSpace() {
        return diskSpace;
    }

    public void setDiskSpace(Long diskSpace) {
        this.diskSpace = diskSpace;
    }

    public Long getMemory() {
        return memory;
    }

    public void setMemory(Long memory) {
        this.memory = memory;
    }

    public Long getCpuCores() {
        return cpuCores;
    }

    public void setCpuCores(Long cpuCores) {
        this.cpuCores = cpuCores;
    }
}
