package io.mocks.xavier.model;

public class RHVAdditionalContainerCapacityModel
{
    private Double rhvContainerHigh;
    private Double rhvContainerLikely;
    private Double rhvContainerLow;
    private Double rhvContainerFrom;
    private Double rhvContainerTo;

    public RHVAdditionalContainerCapacityModel() {
        rhvContainerHigh = 20D;
        rhvContainerLikely = 20D;
        rhvContainerLow = 20D;
        rhvContainerFrom = 20D;
        rhvContainerTo = 20D;
    }

    public Double getRhvContainerHigh() {
        return rhvContainerHigh;
    }

    public void setRhvContainerHigh(Double rhvContainerHigh) {
        this.rhvContainerHigh = rhvContainerHigh;
    }

    public Double getRhvContainerLikely() {
        return rhvContainerLikely;
    }

    public void setRhvContainerLikely(Double rhvContainerLikely) {
        this.rhvContainerLikely = rhvContainerLikely;
    }

    public Double getRhvContainerLow() {
        return rhvContainerLow;
    }

    public void setRhvContainerLow(Double rhvContainerLow) {
        this.rhvContainerLow = rhvContainerLow;
    }

    public Double getRhvContainerFrom() {
        return rhvContainerFrom;
    }

    public void setRhvContainerFrom(Double rhvContainerFrom) {
        this.rhvContainerFrom = rhvContainerFrom;
    }

    public Double getRhvContainerTo() {
        return rhvContainerTo;
    }

    public void setRhvContainerTo(Double rhvContainerTo) {
        this.rhvContainerTo = rhvContainerTo;
    }
}
