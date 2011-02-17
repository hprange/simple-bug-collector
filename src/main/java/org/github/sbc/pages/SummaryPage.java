package org.github.sbc.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.beanutils.BeanComparator;
import org.github.sbc.storage.TemporaryStorage;

import com.google.inject.Inject;
import com.google.sitebricks.At;
import com.google.sitebricks.http.Get;

@At( "/" )
public class SummaryPage
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

	private String sortOrder;

	private List<Application> applications;

	private final TemporaryStorage storage;

	private Application application;

	private String sortField;

	@Inject
	public SummaryPage( TemporaryStorage storage )
	{
		this.storage = storage;
	}

	@Get
	public void get()
	{
		List<Application> applications = new ArrayList<Application>();

		for( String application : storage.allApplications() )
		{
			applications.add( new Application( application, storage.allBugs( application ).size() ) );
		}

		if( sortField != null )
		{
			@SuppressWarnings( "unchecked" )
			Comparator<Application> comparator = new BeanComparator( "name" );

			if( "desc".equals( sortOrder ) )
			{
				comparator = Collections.reverseOrder( comparator );
			}

			Collections.sort( applications, comparator );
		}

		this.applications = applications;
	}

	public Application getApplication()
	{
		return application;
	}

	public List<Application> getApplications()
	{
		return applications;
	}

	public String getSortField()
	{
		return sortField;
	}

	public String getSortOrder()
	{
		return sortOrder;
	}

	public void setApplication( Application application )
	{
		this.application = application;
	}

	public void setSortField( String sortField )
	{
		this.sortField = sortField;
	}

	public void setSortOrder( String sortOrder )
	{
		this.sortOrder = sortOrder;
	}
}
