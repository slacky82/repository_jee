/**
 * 
 */
package org.data.filterstrategy.util;

import it.cassaddpp.eas.util.AbstractContextFactory;
import it.cassaddpp.eas.util.ArcaOc4jContextFactory;
import it.cassaddpp.eas.util.ArcaWeblogicContextFactory;

import java.io.Serializable;

import org.data.filterstrategy.service.locator.FilterStrategyServiceLocator;
import org.utility.DataUtility;

/**
 * @author Gerina Fabrizio fabrizio.gerina@capgemini.com
 * 
 */
public class FilterStrategyServiceFactory implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;

	private FilterStrategyServiceLocator filterStrtgSL;
	private FilterStrategyProperties properties;
	
	public FilterStrategyServiceFactory(FilterStrategyProperties properties){
		this.properties=properties;
	}	
	
	public FilterStrategyServiceLocator getServiceLocator() {
		if (DataUtility.isEmpty(filterStrtgSL)) {
			//if (SisparClProperties.isServiceEJB())
			if(properties.getServiceType().equalsIgnoreCase("EJB"))
				filterStrtgSL = createFilterStrategyServiceLocator(new ArcaWeblogicContextFactory());
			else if (properties.getServiceType().equalsIgnoreCase("DIRECT"))		
				filterStrtgSL = createFilterStrategyServiceLocator(new ArcaOc4jContextFactory());
		}
		return filterStrtgSL;
	}

	private FilterStrategyServiceLocator createFilterStrategyServiceLocator(AbstractContextFactory cf) {
		if (DataUtility.isEmpty(filterStrtgSL)) {

			String applicationName =properties.getApplicationName();			
			String remoteServer = properties.getRemoteServicesServerSrv();
			String remotePort = properties.getRemotePort();
			String user = properties.getRemoteServicesJndiPrincipal();
			String password = properties.getRemoteServicesJndiCredential();			
			cf.setLookupInfo(remoteServer, remotePort, applicationName, user, password);
			filterStrtgSL = new FilterStrategyServiceLocator(cf,properties);
		}
		return filterStrtgSL;
	}
}
