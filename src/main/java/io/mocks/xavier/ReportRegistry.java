package io.mocks.xavier;

import io.mocks.xavier.model.Report;
import io.mocks.xavier.model.Status;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
public class ReportRegistry {

    private final AtomicLong ids = new AtomicLong(0);
    private final Map<Long, Report> reports = new ConcurrentHashMap<>();

    public void addReport(Report report) {
        report.setId(ids.getAndIncrement());
        report.setAnalysisStatus(Status.PROGRESS);
        reports.put(report.getId(), report);
    }

    public void deleteReport(Long id) {
        reports.remove(id);
    }

    public void updateReport(Report report) {
        reports.put(report.getId(), report);
    }

    public Report getReport(Long id) {
        return reports.get(id);
    }

    public List<Report> getAllReports() {
        return new ArrayList<>(reports.values());
    }

    public Report getRandomReport() {
        if (!reports.isEmpty()) {
            int length = reports.keySet().toArray().length;
            int nextInt = new Random().nextInt(length);
            Long randomId = (Long) reports.keySet().toArray()[nextInt];
            return reports.get(randomId);
        }
        return null;
    }
}
