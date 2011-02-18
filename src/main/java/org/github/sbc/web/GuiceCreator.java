package org.github.sbc.web;

import org.github.sbc.pages.SummaryPage;
import org.github.sbc.service.BugsResource;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.sitebricks.SitebricksModule;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class GuiceCreator extends GuiceServletContextListener
{
	@Override
	public Injector getInjector()
	{
		return Guice.createInjector( new JerseyServletModule()
		{
			@Override
			protected void configureServlets()
			{
				bind( BugsResource.class );

				serve( "/api/*" ).with( GuiceContainer.class );
			}
		}, new SimpleBugCollectorModule(), new SitebricksModule()
		{
			@Override
			protected void configureSitebricks()
			{
				scan( SummaryPage.class.getPackage() );
			}
		} );
	}
}
