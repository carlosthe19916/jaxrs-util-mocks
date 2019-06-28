package io.mocks.xavier.resources;

import io.mocks.xavier.ReportRegistry;
import io.mocks.xavier.model.Report;
import io.mocks.xavier.model.Search;

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
            @QueryParam("filterText") @DefaultValue("") String filterText,
            @QueryParam("page") @DefaultValue("1") int page,
            @QueryParam("limit") @DefaultValue("10") int limit
    ) {
        Search search = registry.getAllReports(filterText, page, limit);

        return Response.ok()
                .header("X-Total-Count", search.getTotal())
                .entity(search.getReports())
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

}
