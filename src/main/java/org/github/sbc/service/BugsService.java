package org.github.sbc.service;

import com.google.sitebricks.At;
import com.google.sitebricks.headless.Reply;
import com.google.sitebricks.headless.Service;
import com.google.sitebricks.http.Get;
import com.google.sitebricks.http.negotiate.Accept;

@At("/experimental/:appilcation/bugs")
@Service
public class BugsService
{
	@Get
	@Accept("application/json")
	public Reply<String> getBugsAsJson()
	{
		return Reply.with("{bugs}");
	}

	@Get
	@Accept("application/xml")
	public Reply<String> getBugsAsXml()
	{
		return Reply.with("<bug>bugs</bug>");
	}
}
