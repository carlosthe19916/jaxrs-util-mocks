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
@Path("/api/xavier/mappings")
public class MappingsResource {

    @Inject
    ReportRegistry registry;

    @GET
    @Path("/flag-assessment/{flag}")
    @Produces(MediaType.APPLICATION_JSON)
    public FlagAssessmentModel getFlagAssessment(
            @PathParam("flag") String flag
    ) {
        return new FlagAssessmentModel(1L, flag, flag + "_assessment");
    }

}
