package com.github.sbc.api;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
@XmlRootElement
public class CrashReport
{
	private String message;

	private String stackTrace;

	private String module;

	public CrashReport()
	{
		super();
	}

	public String getMessage()
	{
		return message;
	}

	public String getModule()
	{
		return module;
	}

	public String getStackTrace()
	{
		return stackTrace;
	}

	public void setMessage( String message )
	{
		this.message = message;
	}

	public void setModule( String module )
	{
		this.module = module;
	}

	public void setStackTrace( String stackTrace )
	{
		this.stackTrace = stackTrace;
	}
}
