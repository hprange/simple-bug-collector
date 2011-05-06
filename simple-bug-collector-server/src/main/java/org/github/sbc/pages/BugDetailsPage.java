package org.github.sbc.pages;

import org.github.sbc.model.Bug;
import org.github.sbc.storage.Storage;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.sitebricks.At;
import com.google.sitebricks.http.Get;

@At("/:application/bugs/:id")
public class BugDetailsPage
{
	private Bug bug;

	private final Storage storage;

	@Inject
	public BugDetailsPage(Storage storage)
	{
		this.storage = storage;
	}

	@Get
	public void get(@Named("application") String application, @Named("id") String bugId)
	{
		bug = storage.bugForId(application, Integer.parseInt(bugId));
	}

	public Bug getBug()
	{
		return bug;
	}

	public Integer getNumberOfOccurrences()
	{
		return bug.getOccurrences().size();
	}

	public void setBug(Bug bug)
	{
		this.bug = bug;
	}
}
