/**
 * 
 */
package org.data.filterstrategy.util;

import java.io.Serializable;

/**
 * @author Fabrizio Gerina 
 * fabrizio.gerina@capgemini.com 
 * 26/mag/2014
 *
 */
public interface FilterStrategyProperties extends Serializable{
	
	public String getApplicationName();	
	public String getRemoteServicesServerSrv();	
	public String getRemotePort();	
	public String getRemoteServicesJndiPrincipal();
	public String getRemoteServicesJndiCredential();
	
	public String getServiceType();
	public String getJpaServerType();
	public String getUnitName();
	public String getDozerMappingFile();
	
	
}
