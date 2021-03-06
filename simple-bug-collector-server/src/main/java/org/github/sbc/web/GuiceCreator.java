package org.github.sbc.web;

import org.github.sbc.pages.SummaryPage;
import org.github.sbc.service.BugsResource;
import org.github.sbc.service.BugsService;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.PersistService;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.sitebricks.SitebricksModule;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class GuiceCreator extends GuiceServletContextListener
{
	@Override
	public Injector getInjector()
	{
		Injector injector = Guice.createInjector(new JerseyServletModule()
		{
			@Override
			protected void configureServlets()
			{
				bind(BugsResource.class);

				serve("/api/*").with(GuiceContainer.class);
			}
		}, new SimpleBugCollectorModule(), new JpaPersistModule("sbc"), new SitebricksModule()
		{
			@Override
			protected void configureSitebricks()
			{
				scan(SummaryPage.class.getPackage());
				scan(BugsService.class.getPackage());
			}
		});

		PersistService persistService = injector.getInstance(PersistService.class);

		System.out.println("Starting the persist service.");

		persistService.start();

		return injector;
	}
}
