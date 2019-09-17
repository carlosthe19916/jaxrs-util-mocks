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
    @Path("/flag-assessment")
    @Produces(MediaType.APPLICATION_JSON)
    public List<FlagAssessmentModel> getFlagAssessment() {
        List<FlagAssessmentModel> result = new ArrayList<>();
        result.add(new FlagAssessmentModel("RDM", "", "Flag Label", "assessment generic"));
        result.add(new FlagAssessmentModel("RDM", "RHEL", "Flag Label for RHEL", "assessment for RHEL"));
        return result;
    }

}
