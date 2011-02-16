package org.github.sbc.web;

import org.github.sbc.pages.Summary;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.sitebricks.SitebricksModule;

public class GuiceCreator extends GuiceServletContextListener
{
	@Override
	public Injector getInjector()
	{
		return Guice.createInjector( new SimpleBugCollectorModule(), new SitebricksModule()
		{
			@Override
			protected void configureSitebricks()
			{
				scan( Summary.class.getPackage() );
			}
		} );
	}
}
