package io.mocks.xavier.model;

public class Report {
    private Long id;
    private String customerId;
    private String fileName;
    private Long numberOfHosts;
    private Long totalDiskSpace;
    private Long totalPrice;
    private Long creationDate;
    private Status analysisStatus;

    public Report() {

    }

    public Report(Long id, String customerId, String fileName, Long numberOfHosts, Long totalDiskSpace, Long totalPrice, Long creationDate) {
        this.id = id;
        this.customerId = customerId;
        this.fileName = fileName;
        this.numberOfHosts = numberOfHosts;
        this.totalDiskSpace = totalDiskSpace;
        this.totalPrice = totalPrice;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getNumberOfHosts() {
        return numberOfHosts;
    }

    public void setNumberOfHosts(Long numberOfHosts) {
        this.numberOfHosts = numberOfHosts;
    }

    public Long getTotalDiskSpace() {
        return totalDiskSpace;
    }

    public void setTotalDiskSpace(Long totalDiskSpace) {
        this.totalDiskSpace = totalDiskSpace;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    public Status getAnalysisStatus() {
        return analysisStatus;
    }

    public void setAnalysisStatus(Status analysisStatus) {
        this.analysisStatus = analysisStatus;
    }
}
