package org.github.sbc.pages;

import java.util.HashSet;
import java.util.Set;

import org.github.sbc.storage.TemporaryStorage;

import com.google.inject.Inject;
import com.google.sitebricks.At;
import com.google.sitebricks.http.Get;

@At( "/" )
public class Summary
{
	public static class Application
	{
		private final String name;

		private final int numberOfBugs;

		public Application( String name, int numberOfBugs )
		{
			super();

			this.name = name;
			this.numberOfBugs = numberOfBugs;
		}

		public String getName()
		{
			return name;
		}

		public int getNumberOfBugs()
		{
			return numberOfBugs;
		}
	}

	private Set<Application> applications;

	private final TemporaryStorage storage;

	private Application application;

	@Inject
	public Summary( TemporaryStorage storage )
	{
		this.storage = storage;
	}

	@Get
	public void get()
	{
		Set<Application> applications = new HashSet<Application>();

		for( String application : storage.allApplications() )
		{
			applications.add( new Application( application, storage.allBugs( application ).size() ) );
		}

		this.applications = applications;
	}

	public Application getApplication()
	{
		return application;
	}

	public Set<Application> getApplications()
	{
		return applications;
	}

	public void setApplication( Application application )
	{
		this.application = application;
	}
}
