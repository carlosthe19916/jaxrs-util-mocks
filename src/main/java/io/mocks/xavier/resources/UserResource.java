package io.mocks.xavier.resources;

import io.mocks.xavier.model.User;
import io.mocks.xavier.registry.UserRegistry;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api/xavier/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

	@Inject
	UserRegistry userSession;

	@GET
	public User getUser() {
		return userSession.getUser();
	}

}
