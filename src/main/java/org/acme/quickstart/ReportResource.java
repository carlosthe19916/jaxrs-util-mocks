package org.acme.quickstart;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
@Path("/camel/report")
public class ReportResource {

    static final AtomicInteger visits = new AtomicInteger(0);

    static final List<Report> REPORTS = new ArrayList<>();
    static final Map<Long, Report> REPORTS_MAP = new HashMap<>();

    static {
        Report report1 = new Report(1L, "36500629", "2019-05-09-36500629-payload.json", 61568L, 712997328L, 2585856L, new Date().getTime());
        REPORTS.add(report1);
        REPORTS_MAP.put(report1.getId(), report1);

        Report report2 = new Report(2L, "24353269", "2019-05-09-24353269-payload.json", 43260L, 204442917L, 1816920L, new Date().getTime());
        REPORTS.add(report2);
        REPORTS_MAP.put(report2.getId(), report2);

        Report report3 = new Report(3L, "5705978", "2019-05-09-5705978-payload.json", 68458L, 906625456L, 2875236L, new Date().getTime());
        REPORTS.add(report3);
        REPORTS_MAP.put(report3.getId(), report3);

        Report report4 = new Report(4L, "5705978", "2019-05-09-5705978-payload.json", 68458L, 906625456L, 2875236L, new Date().getTime());
        REPORTS.add(report4);
        REPORTS_MAP.put(report4.getId(), report4);

        Report report5 = new Report(5L, "5705978", "2019-05-09-5705978-payload.json", 68458L, 906625456L, 2875236L, new Date().getTime());
        REPORTS.add(report5);
        REPORTS_MAP.put(report5.getId(), report5);

        Report report6 = new Report(6L, "5705978", "2019-05-09-5705978-payload.json", 68458L, 906625456L, 2875236L, new Date().getTime());
        REPORTS.add(report6);
        REPORTS_MAP.put(report6.getId(), report6);

        Report report7 = new Report(7L, "5705978", "2019-05-09-5705978-payload.json", 68458L, 906625456L, 2875236L, new Date().getTime());
        REPORTS.add(report7);
        REPORTS_MAP.put(report7.getId(), report7);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Report> getAllReports() {
        if (visits.getAndIncrement() % 2 == 0) {
            return REPORTS;
        } else {
            return Collections.emptyList();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Report getReportById(@PathParam("id") Long id) {
        return REPORTS_MAP.get(id);
    }

    public static class Report {
        private Long id;
        private String customerId;
        private String fileName;
        private Long numberOfHosts;
        private Long totalDiskSpace;
        private Long totalPrice;
        private Long creationDate;

        public Report() {

        }

        public Report(Long id, String customerId, String fileName, Long numberOfHosts, Long totalDiskSpace, Long totalPrice, Long creationDate) {
            this.id = id;
            this.customerId = customerId;
            this.fileName = fileName;
            this.numberOfHosts = numberOfHosts;
            this.totalDiskSpace = totalDiskSpace;
            this.totalPrice = totalPrice;
            this.creationDate = creationDate;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCustomerId() {
            return customerId;
        }

        public void setCustomerId(String customerId) {
            this.customerId = customerId;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public Long getNumberOfHosts() {
            return numberOfHosts;
        }

        public void setNumberOfHosts(Long numberOfHosts) {
            this.numberOfHosts = numberOfHosts;
        }

        public Long getTotalDiskSpace() {
            return totalDiskSpace;
        }

        public void setTotalDiskSpace(Long totalDiskSpace) {
            this.totalDiskSpace = totalDiskSpace;
        }

        public Long getTotalPrice() {
            return totalPrice;
        }

        public void setTotalPrice(Long totalPrice) {
            this.totalPrice = totalPrice;
        }

        public Long getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(Long creationDate) {
            this.creationDate = creationDate;
        }
    }
}
