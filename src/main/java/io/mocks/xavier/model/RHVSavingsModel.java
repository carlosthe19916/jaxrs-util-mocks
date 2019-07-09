package io.mocks.xavier.model;

public class RHVSavingsModel
{
    // RHVSavings
    private Double rhvSaveHighValue;
    private Double rhvSaveLikelyValue;
    private Double rhvSaveLowValue;
    private Double rhvSaveFromValue;
    private Double rhvSaveToValue;

    public RHVSavingsModel() {
        rhvSaveHighValue = 1_403_500D;
        rhvSaveLikelyValue = 2_403_500D;
        rhvSaveLowValue = 3_403_500D;
        rhvSaveFromValue = 4_403_500D;
        rhvSaveToValue = 5_403_500D;
    }

    public Double getRhvSaveHighValue() {
        return rhvSaveHighValue;
    }

    public void setRhvSaveHighValue(Double rhvSaveHighValue) {
        this.rhvSaveHighValue = rhvSaveHighValue;
    }

    public Double getRhvSaveLikelyValue() {
        return rhvSaveLikelyValue;
    }

    public void setRhvSaveLikelyValue(Double rhvSaveLikelyValue) {
        this.rhvSaveLikelyValue = rhvSaveLikelyValue;
    }

    public Double getRhvSaveLowValue() {
        return rhvSaveLowValue;
    }

    public void setRhvSaveLowValue(Double rhvSaveLowValue) {
        this.rhvSaveLowValue = rhvSaveLowValue;
    }

    public Double getRhvSaveFromValue() {
        return rhvSaveFromValue;
    }

    public void setRhvSaveFromValue(Double rhvSaveFromValue) {
        this.rhvSaveFromValue = rhvSaveFromValue;
    }

    public Double getRhvSaveToValue() {
        return rhvSaveToValue;
    }

    public void setRhvSaveToValue(Double rhvSaveToValue) {
        this.rhvSaveToValue = rhvSaveToValue;
    }
}
