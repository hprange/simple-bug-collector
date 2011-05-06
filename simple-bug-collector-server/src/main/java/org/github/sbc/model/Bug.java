package org.github.sbc.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Bug
{
	@ManyToOne
	@JoinColumn(name = "APPLICATION_ID")
	private Application application;

	@Id
	@GeneratedValue
	private Integer id;

	@Column(columnDefinition = "text")
	private String message;

	private String module;

	@OneToMany(mappedBy = "bug")
	private Set<Occurrence> occurrences = new HashSet<Occurrence>();

	@Column(columnDefinition = "text")
	private String stackTrace;

	public Bug()
	{
	}

	public Bug(Integer id, Application application, String message, String stackTrace, String module)
	{
		super();

		this.id = id;
		this.application = application;
		this.message = message;
		this.stackTrace = stackTrace;
		this.module = module;

	}

	public boolean addOccurrence(Occurrence occurrence)
	{
		return occurrences.add(occurrence);
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

	public boolean removeOccurence(Occurrence occurrence)
	{
		return occurrences.remove(occurrence);
	}

	public void setApplication(Application application)
	{
		this.application = application;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}

	public void setModule(String module)
	{
		this.module = module;
	}

	protected void setOccurrences(Set<Occurrence> occurrences)
	{
		this.occurrences = occurrences;
	}

	public void setStackTrace(String stackTrace)
	{
		this.stackTrace = stackTrace;
	}
}
