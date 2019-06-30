package io.mocks.xavier.registry;

import io.mocks.xavier.model.Report;
import io.mocks.xavier.model.Search;
import io.mocks.xavier.model.Status;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@ApplicationScoped
public class ReportRegistry {

    private final AtomicLong ids = new AtomicLong(1);
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

    public Search getAllReports(String filterText, int page, int pageSize) {
        List<Report> list = new ArrayList<>(reports.values());
        Collections.reverse(list);

        List<Report> reverseList = list.stream()
                .filter(report -> report.getFileName().contains(filterText))
                .collect(Collectors.toList());

        Map<Integer, List<Report>> collect = IntStream.range(0, (reverseList.size() + pageSize - 1) / pageSize)
                .boxed()
                .collect(
                        Collectors.toMap(i -> i, i -> reverseList.subList(i * pageSize, Math.min(pageSize * (i + 1), reverseList.size())))
                );

        return new Search(collect.get(page - 1), reverseList.size());
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

    public int getTotal() {
        return reports.size();
    }

}
