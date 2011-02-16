package org.github.sbc.model;

import java.util.HashSet;
import java.util.Set;

public class Bug
{
	private final Integer id;

	private final Application application;

	private final String message;

	private final String stackTrace;

	private final String module;

	private final Set<Occurrence> occurrences;

	public Bug( Integer id, Application application, String message, String stackTrace, String module )
	{
		super();

		this.id = id;
		this.application = application;
		this.message = message;
		this.stackTrace = stackTrace;
		this.module = module;
		this.occurrences = new HashSet<Occurrence>();
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
}
