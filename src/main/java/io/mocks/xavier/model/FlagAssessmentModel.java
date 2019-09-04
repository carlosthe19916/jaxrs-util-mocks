package io.mocks.xavier.model;

public class FlagAssessmentModel {
    private Long id;
    private String flag;
    private String assessment;

    public FlagAssessmentModel() {
    }

    public FlagAssessmentModel(Long id, String flag, String assessment) {
        this.id = id;
        this.flag = flag;
        this.assessment = assessment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
