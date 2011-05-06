package org.github.sbc.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Occurrence
{
	@ManyToOne
	@JoinColumn(name = "BUG_ID")
	private Bug bug;

	private String comments;

	private Date date;

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	private String version;

	public Occurrence()
	{
	}

	public Occurrence(String version, User user, Date date, String comments)
	{
		super();

		this.version = version;
		this.user = user;
		this.date = date;
		this.comments = comments;
	}

	public Bug getBug()
	{
		return bug;
	}

	public String getComments()
	{
		return comments;
	}

	public Date getDate()
	{
		return date;
	}

	public Long getId()
	{
		return id;
	}

	public User getUser()
	{
		return user;
	}

	public String getVersion()
	{
		return version;
	}

	public void setBug(Bug bug)
	{
		this.bug = bug;
	}

	public void setComments(String comments)
	{
		this.comments = comments;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}
}
