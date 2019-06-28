package io.mocks.xavier.resources;

import io.mocks.xavier.ReportRegistry;
import io.mocks.xavier.model.Report;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
@Path("/api/xavier/report")
public class ReportResource {

    @Inject
    ReportRegistry registry;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllReports(
            @QueryParam("page") @DefaultValue("1") int page,
            @QueryParam("limit") @DefaultValue("10") int limit
    ) {
        int total = registry.getTotal();
        List<Report> reports = registry.getAllReports(page, limit);

        return Response.ok()
                .header("X-Total-Count", total)
                .entity(reports)
                .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Report getReportById(@PathParam("id") Long id) {
        return registry.getReport(id);
    }

}
