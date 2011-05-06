package org.github.sbc.pages;

import java.util.Collection;

import org.github.sbc.model.Bug;
import org.github.sbc.storage.Storage;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.sitebricks.At;
import com.google.sitebricks.http.Get;

@At("/:application/bugs")
public class BugListPage
{
	private Collection<Bug> bugs;

	private final Storage storage;

	@Inject
	public BugListPage(Storage storage)
	{
		this.storage = storage;
	}

	@Get
	public void get(@Named("application") String application)
	{
		bugs = storage.allBugs(application);
	}

	public Collection<Bug> getBugs()
	{
		return bugs;
	}
}
