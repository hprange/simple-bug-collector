package org.github.sbc.pages;

import com.google.sitebricks.At;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.headless.Service;
import com.google.sitebricks.http.Get;
import com.google.sitebricks.http.negotiate.Accept;

@At( "/api2/:appilcation/bugs" )
@Service
public class BugsService
{
	@Get
	@At( "/json" )
	@Accept( "application/json" )
	public Reply<String> getBugsAsJson()
	{
		return Reply.with( "{bugs}" );
	}

	@Get
	@At( "/xml" )
	@Accept( "application/xml" )
	public Reply<String> getBugsAsXml()
	{
		return Reply.with( "<bug>bugs</bug>" );
	}
}
