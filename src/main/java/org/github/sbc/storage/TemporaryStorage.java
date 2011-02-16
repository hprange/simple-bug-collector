package org.github.sbc.storage;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.github.sbc.model.Application;
import org.github.sbc.model.Bug;

public class TemporaryStorage
{
	private final Map<String, Map<Integer, Bug>> allBugs = new HashMap<String, Map<Integer, Bug>>();

	public TemporaryStorage()
	{
		Map<Integer, Bug> bugs = new HashMap<Integer, Bug>( 2 );

		Application application = new Application( "doit" );

		bugs.put( 1, new Bug( 1, application, "erro 1", "stack trace", "module a" ) );
		bugs.put( 2, new Bug( 2, application, "erro 2", "stack trace", "module b" ) );

		allBugs.put( application.getName(), bugs );

		bugs = new HashMap<Integer, Bug>( 1 );

		application = new Application( "smiles" );

		bugs.put( 1, new Bug( 1, application, "erro 1", "stack trace", null ) );

		allBugs.put( application.getName(), bugs );
	}

	public Set<String> allApplications()
	{
		return allBugs.keySet();
	}

	public Collection<Bug> allBugs( String application )
	{
		return allBugs.get( application ).values();
	}

	public Bug bugForId( String application, Integer id )
	{
		return allBugs.get( application ).get( id );
	}
}
