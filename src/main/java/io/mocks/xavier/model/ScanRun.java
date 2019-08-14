package io.mocks.xavier.model;

import java.util.Date;

public class ScanRun {
    private String target;
    private String type;
    private Long date;

    public ScanRun() {
    }

    public ScanRun(String target, String type, Long date) {
        this.target = target;
        this.type = type;
        this.date = date;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }
}
