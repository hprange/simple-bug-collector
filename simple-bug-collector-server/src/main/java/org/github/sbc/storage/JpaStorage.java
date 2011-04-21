package org.github.sbc.storage;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.github.sbc.model.Application;
import org.github.sbc.model.Bug;

import com.github.sbc.api.CrashReport;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

public class JpaStorage implements Storage
{
	private final EntityManager entityManager;

	@Inject
	public JpaStorage( EntityManager entityManager )
	{
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public Set<String> allApplications()
	{
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		CriteriaQuery<Application> query = criteriaBuilder.createQuery( Application.class );

		query.from( Application.class );

		List<Application> applications = entityManager.createQuery( query ).getResultList();

		Set<String> applicationNames = new TreeSet<String>();

		for( Application application : applications )
		{
			applicationNames.add( application.getName() );
		}

		return applicationNames;
	}

	@Override
	@Transactional
	public Collection<Bug> allBugs( String application )
	{
		TypedQuery<Bug> query = entityManager.createQuery( "SELECT b FROM Bug b WHERE b.application.name = :name", Bug.class );

		query.setParameter( "name", application );

		return query.getResultList();
	}

	@Override
	@Transactional
	public Bug bugForId( String application, Integer id )
	{
		return entityManager.find( , id );
	}

	@Override
	@Transactional
	public Integer saveCrashReport( String applicationName, CrashReport report )
	{
		return null;
	}

}
