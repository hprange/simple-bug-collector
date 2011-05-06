package org.github.sbc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
@Entity
@Table(name = "APPLICATION_USER")
public class User
{
	private String email;

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	public User()
	{
	}

	public User(String name, String email)
	{
		this.name = name;
		this.email = email;
	}

	public String getEmail()
	{
		return email;
	}

	public Integer getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public void setName(String name)
	{
		this.name = name;
	}
}
