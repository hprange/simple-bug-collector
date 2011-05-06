package org.github.sbc.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.github.sbc.model.Bug;
import org.github.sbc.storage.Storage;

import com.github.sbc.api.CrashReport;
import com.google.inject.Inject;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
@Path("/{application}/bugs")
public class BugsResource
{
	private final Storage storage;

	private final UriInfo uriInfo;

	@Inject
	public BugsResource(@Context UriInfo uriInfo, Storage storage)
	{
		this.uriInfo = uriInfo;
		this.storage = storage;

	}

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response createBug(@PathParam("application") String applicationName, CrashReport report)
	{
		Integer bugId = storage.saveCrashReport(applicationName, report);

		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();

		return Response.created(uriBuilder.path(bugId.toString()).build()).build();
	}

	@GET
	@Path("{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Bug getBug(@PathParam("application") String application, @PathParam("id") Integer id)
	{
		return storage.bugForId(application, id);
	}
}
