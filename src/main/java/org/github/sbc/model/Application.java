package org.github.sbc.model;

public class Application
{
	private String name;

	public Application()
	{
	}

	public Application( String name )
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setName( String name )
	{
		this.name = name;
	}
}
