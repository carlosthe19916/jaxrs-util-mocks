package io.mocks.xavier.resources;

import io.mocks.xavier.model.*;
import io.mocks.xavier.registry.ReportRegistry;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    @Path("/{id}/workload-migration-summary")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getWorkloadMigrationSummary(@PathParam("id") Long id) {
        Report report = registry.getReport(id);

        Response response;
        if (report != null) {
            WorkloadMigrationSummary workload = new WorkloadMigrationSummary();

            Complexity complexity = new Complexity();
            complexity.setEasy(20L);
            complexity.setMedium(10L);
            complexity.setHard(40L);
            complexity.setUnknown(30L);

            workload.setComplexity(complexity);

            List<Summary> summaries = new ArrayList<>();
            summaries.add(new Summary("VMware Provider #1", "VSphere", "6.5.0", 34L, 68L, 8L, 286L));
            summaries.add(new Summary("VMware Provider #1", "VSphere", "6.5.0", 34L, 68L, 8L, 286L));
            summaries.add(new Summary("VMware Provider #1", "VSphere", "6.5.0", 34L, 68L, 8L, 286L));

            workload.setSummary(summaries);

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
            estimation.setFileName(report.getFileName());

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
                WorkloadInventoryModel model= new WorkloadInventoryModel();
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
