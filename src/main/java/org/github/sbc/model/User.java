package org.github.sbc.model;

public class User
{
	private final String name;

	private final String email;

	public User( String name, String email )
	{
		super();
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
}
