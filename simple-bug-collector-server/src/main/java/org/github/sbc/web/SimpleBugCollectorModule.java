package org.github.sbc.web;

import org.github.sbc.storage.JpaStorage;
import org.github.sbc.storage.Storage;

import com.google.inject.AbstractModule;

public class SimpleBugCollectorModule extends AbstractModule
{
	@Override
	protected void configure()
	{
		bind(Storage.class).to(JpaStorage.class);
	}
}
