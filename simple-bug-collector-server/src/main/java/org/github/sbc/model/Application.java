package org.github.sbc.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
@Entity
public class Application
{
	@Id
	private Integer id;

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
