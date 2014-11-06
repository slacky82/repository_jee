package it.acme.ejb.jms;

import java.util.Date;

import it.acme.ejb.stateless.FilterStrategyFacadeRemote;
import it.acme.exception.BusinessException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.management.RuntimeErrorException;

import com.sun.jmx.snmp.Timestamp;

/**
 * Message-Driven Bean implementation class for: MessageDrivenBean
 */
@MessageDriven(
		activationConfig = { 
					@ActivationConfigProperty(propertyName = "acknowledgeMode", 
											  propertyValue = "Auto-acknowledge"),
					@ActivationConfigProperty(propertyName = "destinationType", 
											  propertyValue = "javax.jms.Queue")	
					}, 
		mappedName = "jms/myQueue")
public class MessageDrivenBean implements MessageListener {
	
	@EJB
	FilterStrategyFacadeRemote ejbRef;
    
    public MessageDrivenBean() {
        
    }
    
	
    @PostConstruct
    private void postConstruct(){
    	System.out.println("#MessageDrivenBean: @PostConstruct CALLED!! -> "+ new Timestamp(new Date().getTime()));     	
    }
    
    @PreDestroy
    private void preDestroy(){
    	System.out.println("#MessageDrivenBean: @PreDestroy CALLED!!");    	
    }
    
	
	public void onMessage(Message message) {
		//String ex = null; per test domanda 57
		try {
			TextMessage tm = (TextMessage) message;
			//ex=tm.getText(); per test domanda 57
			ejbRef.insertMessage(tm.getText());
			System.out.println("#MessageDrivenBean: Consumed Message= "	+ tm.getText());
			System.out.println("#MessageDrivenBean: onMessage CALLED!!");
			//throw new JMSException("unexpected error..."); per test domanda 57
		} catch (JMSException jex) {
			System.out.println("Exception in onMessage(): " + jex);
		}catch (BusinessException be){
			System.out.println("Exception in insertMessage(): " + be);
		}
		/*per test domanda 57
		if(ex.equalsIgnoreCase("aaa")){
			throw new RuntimeException();
		}	
		*/	
	}

}
