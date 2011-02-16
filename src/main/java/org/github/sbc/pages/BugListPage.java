package org.github.sbc.pages;

import java.util.Collection;

import org.github.sbc.model.Bug;
import org.github.sbc.storage.TemporaryStorage;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.sitebricks.At;
import com.google.sitebricks.http.Get;

@At( "/:application/bugs" )
public class BugListPage
{
	private Collection<Bug> bugs;

	private final TemporaryStorage storage;

	@Inject
	public BugListPage( TemporaryStorage storage )
	{
		this.storage = storage;
	}

	@Get
	public void get( @Named( "application" ) String application )
	{
		bugs = storage.allBugs( application );
	}

	public Collection<Bug> getBugs()
	{
		return bugs;
	}
}
