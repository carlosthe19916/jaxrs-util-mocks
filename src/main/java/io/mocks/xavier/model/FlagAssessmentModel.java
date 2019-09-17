package io.mocks.xavier.model;

public class FlagAssessmentModel {

    private String flag;
    private String osName;
    private String flagLabel;
    private String assessment;

    public FlagAssessmentModel() {
    }

    public FlagAssessmentModel(String flag, String osName, String flagLabel, String assessment) {
        this.flag = flag;
        this.osName = osName;
        this.flagLabel = flagLabel;
        this.assessment = assessment;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }

    public String getFlagLabel() {
        return flagLabel;
    }

    public void setFlagLabel(String flagLabel) {
        this.flagLabel = flagLabel;
    }

    public String getAssessment() {
        return assessment;
    }

    public void setAssessment(String assessment) {
        this.assessment = assessment;
    }

}
