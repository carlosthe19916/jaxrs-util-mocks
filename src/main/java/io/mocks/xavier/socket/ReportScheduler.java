package io.mocks.xavier.socket;

import io.mocks.xavier.ReportEvent;
import io.mocks.xavier.ReportEventType;
import io.mocks.xavier.ReportRegistry;
import io.mocks.xavier.model.Report;
import io.mocks.xavier.model.Status;
import io.quarkus.scheduler.Scheduled;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
public class ReportScheduler {

    private final AtomicLong counter = new AtomicLong(0);

    @Inject
    ReportRegistry registry;

    @Inject
    @ReportEvent(value = ReportEventType.ADDED)
    Event<Report> addedEvent;

    @Inject
    @ReportEvent(value = ReportEventType.MODIFIED)
    Event<Report> modifiedEvent;

    @Inject
    @ReportEvent(value = ReportEventType.DELETED)
    Event<Report> deleteEvent;

    @Scheduled(every = "5s")
    void addReport() {
        counter.getAndIncrement();
        if (counter.get() == 50) {
            registry.getAllReports().forEach(this::deleteReportBy);
            counter.set(0);
        }


        Report report = new Report();

        report.setCustomerId("111111");
        report.setFileName(new Date().toString() + "-payload.json");
        report.setNumberOfHosts(new Random().nextLong());
        report.setTotalDiskSpace(new Random().nextLong());
        report.setTotalPrice(new Random().nextLong());
        report.setCreationDate(new Date().getTime());

        registry.addReport(report);
        addedEvent.fire(report);
    }

    @Scheduled(every = "3s")
    void updateReport() {
        Report report = registry.getRandomReport();
        if (report != null) {
            report.setAnalysisStatus(Status.FINISHED);

            registry.updateReport(report);
            modifiedEvent.fire(report);
        }
    }

    @Scheduled(every = "20s")
    void deleteReport() {
        Report report = registry.getRandomReport();
        if (report != null) {
            deleteReportBy(report);
        }
    }

    private void deleteReportBy(Report report) {
        registry.deleteReport(report.getId());
        deleteEvent.fire(report);
    }

}
