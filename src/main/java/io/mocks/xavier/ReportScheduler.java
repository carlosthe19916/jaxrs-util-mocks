package io.mocks.xavier;

import io.mocks.xavier.registry.ReportRegistry;
import io.mocks.xavier.model.Report;
import io.mocks.xavier.model.Status;
import io.mocks.xavier.registry.UserRegistry;
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
    private static final int MAX_NUMBER_OF_REPORTS = 1000;

    @Inject
    ReportRegistry reportDB;


    @Inject
    UserRegistry userSession;

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
        // Dont create reports if is the first time of the user
        if (userSession.getUser().isFirstTimeCreatingReports()) {
            return;
        }


        counter.getAndIncrement();
        if (counter.get() >= MAX_NUMBER_OF_REPORTS) {
            reportDB.getAllReports().forEach(this::deleteReportBy);
            counter.set(0);
        }


        Report report = new Report();

        report.setCustomerId("111111");
        report.setFileName(new Date().toString() + "-payload.json");
        report.setNumberOfHosts(new Random().nextLong());
        report.setTotalDiskSpace(new Random().nextLong());
        report.setTotalPrice(new Random().nextLong());
        report.setCreationDate(new Date().getTime());

        reportDB.addReport(report);
        addedEvent.fire(report);
    }

    @Scheduled(every = "1s")
    void updateReport() {
        Report report = reportDB.getRandomReport();
        if (report != null) {
            report.setAnalysisStatus(Status.randomStatus());

            reportDB.updateReport(report);
            modifiedEvent.fire(report);
        }
    }

    @Scheduled(every = "15s")
    void deleteReport() {
        Report report = reportDB.getRandomReport();
        if (report != null) {
            deleteReportBy(report);
        }
    }

    private void deleteReportBy(Report report) {
        reportDB.deleteReport(report.getId());
        deleteEvent.fire(report);
    }

}
