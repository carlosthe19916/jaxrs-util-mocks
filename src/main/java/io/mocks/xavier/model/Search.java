package io.mocks.xavier.model;

import java.util.List;

public class Search {
    private List<Report> reports;
    private int total;

    public Search(List<Report> reports, int total) {
        this.reports = reports;
        this.total = total;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
