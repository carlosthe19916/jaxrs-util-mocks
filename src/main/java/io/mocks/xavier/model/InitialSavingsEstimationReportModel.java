package io.mocks.xavier.model;

import java.util.Date;

public class InitialSavingsEstimationReportModel {

    private Long id;
    private String customerId;
    private String fileName;
    private Date creationDate;

    private EnvironmentModel environmentModel;
    private SourceCostsModel sourceCostsModel;
    private SourceRampDownCostsModel sourceRampDownCostsModel;
    private RHVRampUpCostsModel rhvRampUpCostsModel;
    private RHVYearByYearCostsModel rhvYearByYearCostsModel;
    private RHVSavingsModel rhvSavingsModel;
    private RHVAdditionalContainerCapacityModel rhvAdditionalContainerCapacityModel;
    private RHVOrderFormModel rhvOrderFormModel;

    public InitialSavingsEstimationReportModel() {
        creationDate = new Date();
        environmentModel= new EnvironmentModel();
        sourceCostsModel = new SourceCostsModel();
        sourceRampDownCostsModel = new SourceRampDownCostsModel();
        rhvRampUpCostsModel = new RHVRampUpCostsModel();
        rhvYearByYearCostsModel = new RHVYearByYearCostsModel();
        rhvSavingsModel= new RHVSavingsModel();
        rhvAdditionalContainerCapacityModel = new RHVAdditionalContainerCapacityModel();
        rhvOrderFormModel = new RHVOrderFormModel();
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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public EnvironmentModel getEnvironmentModel() {
        return environmentModel;
    }

    public void setEnvironmentModel(EnvironmentModel environmentModel) {
        this.environmentModel = environmentModel;
    }

    public SourceCostsModel getSourceCostsModel() {
        return sourceCostsModel;
    }

    public void setSourceCostsModel(SourceCostsModel sourceCostsModel) {
        this.sourceCostsModel = sourceCostsModel;
    }

    public SourceRampDownCostsModel getSourceRampDownCostsModel() {
        return sourceRampDownCostsModel;
    }

    public void setSourceRampDownCostsModel(SourceRampDownCostsModel sourceRampDownCostsModel) {
        this.sourceRampDownCostsModel = sourceRampDownCostsModel;
    }

    public RHVRampUpCostsModel getRhvRampUpCostsModel() {
        return rhvRampUpCostsModel;
    }

    public void setRhvRampUpCostsModel(RHVRampUpCostsModel rhvRampUpCostsModel) {
        this.rhvRampUpCostsModel = rhvRampUpCostsModel;
    }

    public RHVYearByYearCostsModel getRhvYearByYearCostsModel() {
        return rhvYearByYearCostsModel;
    }

    public void setRhvYearByYearCostsModel(RHVYearByYearCostsModel rhvYearByYearCostsModel) {
        this.rhvYearByYearCostsModel = rhvYearByYearCostsModel;
    }

    public RHVSavingsModel getRhvSavingsModel() {
        return rhvSavingsModel;
    }

    public void setRhvSavingsModel(RHVSavingsModel rhvSavingsModel) {
        this.rhvSavingsModel = rhvSavingsModel;
    }

    public RHVAdditionalContainerCapacityModel getRhvAdditionalContainerCapacityModel() {
        return rhvAdditionalContainerCapacityModel;
    }

    public void setRhvAdditionalContainerCapacityModel(RHVAdditionalContainerCapacityModel rhvAdditionalContainerCapacityModel) {
        this.rhvAdditionalContainerCapacityModel = rhvAdditionalContainerCapacityModel;
    }

    public RHVOrderFormModel getRhvOrderFormModel() {
        return rhvOrderFormModel;
    }

    public void setRhvOrderFormModel(RHVOrderFormModel rhvOrderFormModel) {
        this.rhvOrderFormModel = rhvOrderFormModel;
    }
}
