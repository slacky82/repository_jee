package it.acme.ejb.jms;

import it.acme.exception.BusinessException;

import javax.ejb.Remote;

@Remote
public interface MessageProducerBeanRemote {
	public void sendMessage(String message)throws BusinessException;

}
