package org.github.sbc.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
@Entity
public class User
{
	@Id
	private Integer id;

	private String name;

	private String email;

	public User()
	{
	}

	public User( String name, String email )
	{
		this.name = name;
		this.email = email;
	}

	public String getEmail()
	{
		return email;
	}

	public String getName()
	{
		return name;
	}

	public void setEmail( String email )
	{
		this.email = email;
	}

	public void setName( String name )
	{
		this.name = name;
	}
}
