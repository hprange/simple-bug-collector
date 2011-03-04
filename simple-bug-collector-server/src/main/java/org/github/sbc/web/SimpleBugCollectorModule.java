package org.github.sbc.web;

import org.github.sbc.storage.TemporaryStorage;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

public class SimpleBugCollectorModule extends AbstractModule
{
	@Override
	protected void configure()
	{
		bind( TemporaryStorage.class ).in( Singleton.class );
	}
}
