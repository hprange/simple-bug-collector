package org.github.sbc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Bug
{
	@Id
	private Integer id;

	private Application application;

	private String message;

	private String stackTrace;

	private String module;

	private Set<Occurrence> occurrences = new HashSet<Occurrence>();

	public Bug()
	{
	}

	public Bug( Integer id, Application application, String message, String stackTrace, String module )
	{
		super();

		this.id = id;
		this.application = application;
		this.message = message;
		this.stackTrace = stackTrace;
		this.module = module;

	}

	public boolean addOccurrence( Occurrence occurrence )
	{
		return occurrences.add( occurrence );
	}

	public Application getApplication()
	{
		return application;
	}

	public Integer getId()
	{
		return id;
	}

	public String getMessage()
	{
		return message;
	}

	public String getModule()
	{
		return module;
	}

	public Set<Occurrence> getOccurrences()
	{
		return occurrences;
	}

	public String getStackTrace()
	{
		return stackTrace;
	}

	public boolean removeOccurence( Occurrence occurrence )
	{
		return occurrences.remove( occurrence );
	}

	public void setApplication( Application application )
	{
		this.application = application;
	}

	public void setId( Integer id )
	{
		this.id = id;
	}

	public void setMessage( String message )
	{
		this.message = message;
	}

	public void setModule( String module )
	{
		this.module = module;
	}

	protected void setOccurrences( Set<Occurrence> occurrences )
	{
		this.occurrences = occurrences;
	}

	public void setStackTrace( String stackTrace )
	{
		this.stackTrace = stackTrace;
	}
}
