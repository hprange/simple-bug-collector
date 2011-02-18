package org.github.sbc.model;

public class User
{
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
