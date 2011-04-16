package com.github.sbc.client;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.github.sbc.api.CrashReport;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.github.sbc.stub.StubBugsResource;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.test.framework.JerseyTest;
import com.sun.jersey.test.framework.spi.container.TestContainerException;

/**
 * TODO: Cannot collect a null crash report
 * <p>
 * TODO: Cannot collect with a null baseUrl
 * <p>
 * TODO: Cannot collect with a null application name
 * <p>
 * TODO: Exception if an error occur while collecting the crash report
 * <p>
 * TODO: Exception if report using a wrong application name
 * 
 * @author <a href="mailto:hprange@gmail.com">Henrique Prange</a>
 */
@RunWith( MockitoJUnitRunner.class )
public class TestCrashReportCollector extends JerseyTest
{
	@Mock
	private Client mockClient;

	public TestCrashReportCollector() throws TestContainerException
	{
		super( StubBugsResource.class.getPackage().getName() );
	}

	@Test
	public void sendCrashReport() throws Exception
	{
		WebResource resource = spy( resource() );

		when( mockClient.resource( Mockito.anyString() ) ).thenReturn( resource );

		CrashReporter reporter = new CrashReporter( "resource-url", "applicationId", mockClient );

		CrashReport mockReport = new CrashReport();

		Long result = reporter.record( mockReport );

		assertThat( result, is( 1L ) );

		verify( mockClient ).resource( "resource-url" );
	}
}
