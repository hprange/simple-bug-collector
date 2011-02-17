package org.github.sbc.storage;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.github.sbc.model.Application;
import org.github.sbc.model.Bug;
import org.github.sbc.model.Occurrence;

public class TemporaryStorage
{
	private final Map<String, Map<Integer, Bug>> allBugs = new HashMap<String, Map<Integer, Bug>>();

	public TemporaryStorage()
	{
		Map<Integer, Bug> bugs = new HashMap<Integer, Bug>( 2 );

		Application application = new Application( "doit" );

		Bug bug = new Bug( 1, application, "erro 1", "stack trace", "module a" );

		bug.addOccurrence( new Occurrence( "1.1", null, new Date(), null, null ) );
		bug.addOccurrence( new Occurrence( "1.2", null, new Date(), null, null ) );
		bug.addOccurrence( new Occurrence( "1.3", null, new Date(), null, null ) );

		bugs.put( 1, bug );

		bug = new Bug( 2, application, "erro 2", "stack trace", "module b" );

		bug.addOccurrence( new Occurrence( "3.0.1", null, new Date(), null, null ) );
		bug.addOccurrence( new Occurrence( "2.0", null, new Date(), null, null ) );

		bugs.put( 2, bug );

		allBugs.put( application.getName(), bugs );

		bugs = new HashMap<Integer, Bug>( 1 );

		application = new Application( "smiles" );

		bug = new Bug( 1, application, "erro 1", "stack trace", null );

		bug.addOccurrence( new Occurrence( "2.0", null, new Date(), null, null ) );
		bug.addOccurrence( new Occurrence( "2.0", null, new Date(), null, null ) );
		bug.addOccurrence( new Occurrence( "2.0", null, new Date(), null, null ) );
		bug.addOccurrence( new Occurrence( "2.0", null, new Date(), null, null ) );
		bug.addOccurrence( new Occurrence( "2.0", null, new Date(), null, null ) );

		bugs.put( 1, bug );

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
