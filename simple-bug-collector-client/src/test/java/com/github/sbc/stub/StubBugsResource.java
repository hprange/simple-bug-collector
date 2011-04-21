package com.github.sbc.stub;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.sbc.api.CrashReport;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
@Path( "/{application}/bugs" )
public class StubBugsResource
{
	@PUT
	@Consumes( { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML } )
	public Response createBug( @PathParam( "application" ) String applicationName, CrashReport report ) throws URISyntaxException
	{
		return Response.created( new URI( "/1" ) ).build();
	}
}
