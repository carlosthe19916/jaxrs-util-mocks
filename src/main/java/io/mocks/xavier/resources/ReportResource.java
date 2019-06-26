package io.mocks.xavier.resources;

import io.mocks.xavier.ReportRegistry;
import io.mocks.xavier.model.Report;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
@Path("/api/xavier/report")
public class ReportResource {

    @Inject
    ReportRegistry registry;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Report> getAllReports() {
        return registry.getAllReports();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Report getReportById(@PathParam("id") Long id) {
        return registry.getReport(id);
    }

}
