package it.acme.ejb.stateless;

import it.acme.data.dto.EmployeeDTO;
import it.acme.data.dto.MessageDTO;
import it.acme.exception.BusinessException;

import javax.ejb.Remote;

@Remote
public interface FilterStrategyFacadeRemote {
	
	public boolean insertEmployee(EmployeeDTO objDTO)  throws BusinessException;
	
	public boolean insertMessage(String message)  throws BusinessException;

}
