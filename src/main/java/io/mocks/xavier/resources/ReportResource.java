package io.mocks.xavier.resources;

import io.mocks.xavier.model.*;
import io.mocks.xavier.registry.ReportRegistry;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@ApplicationScoped
@Path("/api/xavier/report")
public class ReportResource {

    @Inject
    ReportRegistry registry;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllReports(
            @QueryParam("filterText") @DefaultValue("") String filterText,
            @QueryParam("page") @DefaultValue("1") int page,
            @QueryParam("size") @DefaultValue("10") int size
    ) {
        // Adding page + 1 because the real backend starts the page from 0
        // Just to simulate it.
        Search search = registry.getAllReports(filterText, page + 1, size);


        ReportSearchResult result = new ReportSearchResult();
        result.setContent(search.getReports());
        result.setTotalElements(search.getTotal());


        return Response.ok()
                .entity(result)
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReportById(@PathParam("id") Long id) {
        Report report = registry.getReport(id);
        Response response;
        if (report != null) {
            response = Response.ok()
                    .entity(report)
                    .build();
        } else {
            response = Response.status(Response.Status.NOT_FOUND)
                    .build();
        }
        return response;
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteReportById(@PathParam("id") Long id) {
        Report report = registry.getReport(id);

        Response response;
        if (report != null) {
            registry.deleteReport(id);
            response = Response.ok().build();
        } else {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }

    @GET
    @Path("/{id}/workload-summary")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWorkloadMigrationSummary(@PathParam("id") Long id) {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Report report = registry.getReport(id);

        Response response;
        if (report != null) {
            WorkloadSummary workload = new WorkloadSummary();

            //
            Complexity complexity = new Complexity();
            complexity.setEasy(20L);
            complexity.setMedium(10L);
            complexity.setHard(40L);
            complexity.setUnknown(30L);

            workload.setComplexity(complexity);

            //
            List<Summary> summaries = new ArrayList<>();
            summaries.add(new Summary("VMware Provider #1", "VSphere", "6.5.0", 3412L, 6800L, 8555L, 28666L));
            summaries.add(new Summary("VMware Provider #1", "VSphere", "6.5.0", 3412L, 6800L, 8555L, 28666L));
            summaries.add(new Summary("VMware Provider #1", "VSphere", "6.5.0", 3412L, 6800L, 8555L, 28666L));

            workload.setSummary(summaries);

            //
            Map<String, Long> targetRecommendations = new HashMap<>();
            targetRecommendations.put("rhv", 52145L);
            targetRecommendations.put("osp", 854L);
            targetRecommendations.put("rhel", 9852L);

            workload.setTargetsRecommendation(targetRecommendations);

            //
            Map<String, Long> workloadsDetected = new HashMap<>();
            workloadsDetected.put("rhel", 5874L);
            workloadsDetected.put("sles", 5874L);
            workloadsDetected.put("windows", 5874L);
            workloadsDetected.put("oel", 5874L);

            workload.setWorkloadsDetected(workloadsDetected);

            //
            List<ScanRun> scanRuns = new ArrayList<>();
            scanRuns.add(new ScanRun("VMware Provider #1", "Virt Platform", 123456789123L));
            scanRuns.add(new ScanRun("VMware Provider #2", "Virt Platform", 123456789123L));
            scanRuns.add(new ScanRun("VMware Provider #3", "Virt Platform", 123456789123L));

            workload.setScanRuns(scanRuns);

            response = Response.ok(workload).build();
        } else {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }

    @GET
    @Path("/{id}/workload-summary/workloads-detected")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWorkloadMigrationSummary_workloadsDetected(
            @PathParam("id") Long id,
            @QueryParam("page") @DefaultValue("1") int page,
            @QueryParam("size") @DefaultValue("10") int size,
            @QueryParam("orderBy") @DefaultValue("id") String orderBy,
            @QueryParam("orderAsc") @DefaultValue("false") boolean orderAsc
    ) {
        Report report = registry.getReport(id);

        Response response;
        if (report != null) {
            SearchResult<WorkloadDetected> workload = new SearchResult<>();

            List<WorkloadDetected> elements = new ArrayList<>();
            elements.add(new WorkloadDetected("SAP", "RHEL", 5L ,8L));
            elements.add(new WorkloadDetected("SAP", "RHEL", 5L ,8L));
            elements.add(new WorkloadDetected("SAP", "RHEL", 5L ,8L));
            elements.add(new WorkloadDetected("SAP", "RHEL", 5L ,8L));
            elements.add(new WorkloadDetected("SAP", "RHEL", 5L ,8L));
            elements.add(new WorkloadDetected("SAP", "RHEL", 5L ,8L));
            elements.add(new WorkloadDetected("SAP", "RHEL", 5L ,8L));
            elements.add(new WorkloadDetected("SAP", "RHEL", 5L ,8L));
            elements.add(new WorkloadDetected("SAP", "RHEL", 5L ,8L));
            elements.add(new WorkloadDetected("SAP", "RHEL", 5L ,8L));

            workload.setTotalElements(elements.size());
            workload.setContent(elements);

            response = Response.ok(workload).build();
        } else {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }

    @GET
    @Path("/{id}/workload-summary/flags")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWorkloadMigrationSummary_flags(
            @PathParam("id") Long id,
            @QueryParam("page") @DefaultValue("1") int page,
            @QueryParam("size") @DefaultValue("10") int size,
            @QueryParam("orderBy") @DefaultValue("id") String orderBy,
            @QueryParam("orderAsc") @DefaultValue("false") boolean orderAsc
    ) {
        Report report = registry.getReport(id);

        Response response;
        if (report != null) {
            SearchResult<Flag> workload = new SearchResult<>();

            List<Flag> elements = new ArrayList<>();
            elements.add(new Flag("Raw Device Mapping", "Manual data migration required", "RHEL", 8L, 9L));
            elements.add(new Flag("Raw Device Mapping", "Manual data migration required", "RHEL", 8L, 9L));
            elements.add(new Flag("Raw Device Mapping", "Manual data migration required", "RHEL", 8L, 9L));
            elements.add(new Flag("Raw Device Mapping", "Manual data migration required", "RHEL", 8L, 9L));
            elements.add(new Flag("Raw Device Mapping", "Manual data migration required", "RHEL", 8L, 9L));
            elements.add(new Flag("Raw Device Mapping", "Manual data migration required", "RHEL", 8L, 9L));
            elements.add(new Flag("Raw Device Mapping", "Manual data migration required", "RHEL", 8L, 9L));
            elements.add(new Flag("Raw Device Mapping", "Manual data migration required", "RHEL", 8L, 9L));
            elements.add(new Flag("Raw Device Mapping", "Manual data migration required", "RHEL", 8L, 9L));
            elements.add(new Flag("Raw Device Mapping", "Manual data migration required", "RHEL", 8L, 9L));

            workload.setTotalElements(elements.size());
            workload.setContent(elements);

            response = Response.ok(workload).build();
        } else {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }

    @GET
    @Path("/{id}/initial-saving-estimation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInitialSavingEstimation(@PathParam("id") Long id) {
        Report report = registry.getReport(id);

        Response response;
        if (report != null) {
            InitialSavingsEstimationReportModel estimation = new InitialSavingsEstimationReportModel();
            estimation.setId(id);
            estimation.setCustomerId("123456");
            estimation.setFileName(report.getReportName());

            response = Response.ok(estimation).build();
        } else {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }

    @GET
    @Path("/{id}/workload-inventory")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWorkloadInventory(
            @PathParam("id") Long id,
            @QueryParam("page") @DefaultValue("1") int page,
            @QueryParam("size") @DefaultValue("10") int size
    ) {
        Report report = registry.getReport(id);

        Response response;
        if (report != null) {
            List<WorkloadInventoryModel> list = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                WorkloadInventoryModel model = new WorkloadInventoryModel();
                model.setProvider("IMV vCenter");
                model.setDatacenter("V2V-DC");
                model.setCluster("Cluster 1");
                model.setVmName("ytale-ubuntu-arl15-001");
                model.setWorkloads(Arrays.asList("SAP HANA", "Tomcat"));
                model.setOsName("RHEL");
                model.setOsDescription("Red Hat Enterprise Linux Server release 7.6 (Maipo)");
                model.setComplexity("Medium");
                model.setRecommendedTargetsIMS(Arrays.asList("OSP", "RHV"));
                model.setFlagIMS(Arrays.asList("Shared disk"));
                model.setDiskSpace(4565421125L);
                model.setMemory(2147483648L);
                model.setCpuCores(1L);
                list.add(model);
            }

            ReportSearchResult result = new ReportSearchResult();
            result.setContent(list);
            result.setTotalElements(list.size());

            response = Response.ok(result).build();
        } else {
            response = Response.status(Response.Status.NOT_FOUND).build();
        }

        return response;
    }

}
