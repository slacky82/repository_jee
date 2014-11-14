package it.acme.controller.managedBean;


import it.acme.ejb.jms.MessageProducerBeanRemote;
import it.acme.ejb.stateless.FilterStrategyFacadeRemote;
import it.acme.exception.BusinessException;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;


@ManagedBean(name="messageProducerApp")
@RequestScoped
public class MessageProducerAppMB {
	
	private String message;
	
	
	//@Resource(mappedName = "jms/HelloWorldQueueFactory")
	@Resource(lookup = "jms/HelloWorldQueueFactory")
	private ConnectionFactory helloWorldQueueFactory;	
  
    @Resource(mappedName = "jms/myQueue")
    private Queue helloWorldQueue;
    
    
    @EJB
	MessageProducerBeanRemote ejbRef;
    
    
    public MessageProducerAppMB(){
    	
    }
    
    public void sendMessage(ActionEvent event){     	
    	
         try {
             sendJMSMessageToHelloWorldQueue(message);  
             createFacesMessage(message,false);
         } catch (JMSException ex) {
        	 createFacesMessage("Message NOT sent: " + message,true);   	     
             System.err.println("MessageProducerApp.main: failed to send message - " + ex);
         }   	
	}
    
    public void sendMessageByEJB(ActionEvent event){       	
        try {        	
        	ejbRef.sendMessage(message); 
        	createFacesMessage(message,false);
        } catch (BusinessException ex) {
       	 createFacesMessage("Message NOT sent: " + message,true);   	     
            System.err.println("MessageProducerApp.main: failed to send message - " + ex);
        }   	
	}
    
    
    private void createFacesMessage(String message, boolean errorType){
    	FacesContext facesContext = FacesContext.getCurrentInstance();
    	FacesMessage facesMessage = new FacesMessage("Message sent: " + message);    	
    	if(errorType){
    		facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
    	}
    	else{
    		 facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
    	}    	
        facesContext.addMessage(null, facesMessage);
    }    

    private  Message createJMSMessageForjmsHelloWorldQueue(Session session, Object messageData) throws JMSException {        
        TextMessage tm = session.createTextMessage();
        tm.setStringProperty("type", "text");//ho messo un messageSelector nel message-driven-bean che fa passare solo messaggi con la property type=text
        tm.setText(messageData.toString());
        return tm;
    }

    private  void sendJMSMessageToHelloWorldQueue(Object messageData) throws JMSException {
        Connection connection = null;
        Session session = null;
        try {
            connection = helloWorldQueueFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(helloWorldQueue);
            messageProducer.send(createJMSMessageForjmsHelloWorldQueue(session, messageData));
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e) {
                    System.err.println("Cannot close session - " + e);
                }
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
    
	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

}
