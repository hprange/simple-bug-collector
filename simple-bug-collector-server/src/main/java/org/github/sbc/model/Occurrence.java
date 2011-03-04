package org.github.sbc.model;

import java.util.Date;
import java.util.Map;

public class Occurrence
{
	private String version;

	private User user;

	private Date date;

	private String comments;

	private Map<String, String> additionalData;

	public Occurrence()
	{
	}

	public Occurrence( String version, User user, Date date, String comments, Map<String, String> additionalData )
	{
		super();

		this.version = version;
		this.user = user;
		this.date = date;
		this.comments = comments;
		this.additionalData = additionalData;
	}

	public Map<String, String> getAdditionalData()
	{
		return additionalData;
	}

	public String getComments()
	{
		return comments;
	}

	public Date getDate()
	{
		return date;
	}

	public User getUser()
	{
		return user;
	}

	public String getVersion()
	{
		return version;
	}

	public void setAdditionalData( Map<String, String> additionalData )
	{
		this.additionalData = additionalData;
	}

	public void setComments( String comments )
	{
		this.comments = comments;
	}

	public void setDate( Date date )
	{
		this.date = date;
	}

	public void setUser( User user )
	{
		this.user = user;
	}

	public void setVersion( String version )
	{
		this.version = version;
	}
}
