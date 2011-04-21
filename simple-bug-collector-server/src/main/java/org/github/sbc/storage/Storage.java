package org.github.sbc.storage;

import java.util.Collection;
import java.util.Set;

import org.github.sbc.model.Bug;

import com.github.sbc.api.CrashReport;

/**
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
public interface Storage
{
	public Set<String> allApplications();

	public Collection<Bug> allBugs( String application );

	public Bug bugForId( String application, Integer id );

	public Integer saveCrashReport( String applicationName, CrashReport report );
}
