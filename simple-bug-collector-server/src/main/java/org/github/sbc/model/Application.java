package org.github.sbc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
@Entity
public class Application
{
	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	public Application()
	{
	}

	public Application(String name)
	{
		this.name = name;
	}

	public Integer getId()
	{
		return id;
	}

	public String getName()
	{
		return name;
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
