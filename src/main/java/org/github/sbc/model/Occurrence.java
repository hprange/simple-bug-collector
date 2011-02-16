package org.github.sbc.model;

import java.util.Date;
import java.util.Map;

public class Occurrence
{
	private final String version;

	private final User user;

	private final Date date;

	private final String comments;

	private final Map<String, String> additionalData;

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
}
