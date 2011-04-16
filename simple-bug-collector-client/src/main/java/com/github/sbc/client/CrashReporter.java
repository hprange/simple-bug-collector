package com.github.sbc.client;

import javax.ws.rs.core.MediaType;

import org.github.sbc.api.CrashReport;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public class CrashReporter
{
	private final Client client;

	private final String url;

	private final String application;

	public CrashReporter( String baseUrl, String application )
	{
		this( baseUrl, application, Client.create() );
	}

	CrashReporter( String baseUrl, String application, Client client )
	{
		this.url = baseUrl;
		this.application = application;
		this.client = client;
	}

	public Long record( CrashReport report )
	{
		WebResource resource = client.resource( url );

		ClientResponse response = resource.path( application ).path( "bugs" ).type( MediaType.APPLICATION_JSON ).put( ClientResponse.class, report );

		String location = response.getLocation().toString();

		return Long.parseLong( location.substring( location.lastIndexOf( "/" ) + 1, location.length() ) );
	}
}
