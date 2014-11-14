package it.acme.ejb.jms;

import java.util.Date;

import it.acme.exception.BusinessException;

import javax.annotation.Resource;
import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
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

import com.sun.jmx.snmp.Timestamp;


@Stateless(mappedName = "messageProducer")
@LocalBean
public class MessageProducerBean implements MessageProducerBeanRemote, MessageProducerBeanLocal {
	@Resource(lookup = "jms/HelloWorldQueueFactory")
	private ConnectionFactory helloWorldQueueFactory;	
  
    @Resource(mappedName = "jms/myQueue")
    private Queue helloWorldQueue;
   
    public MessageProducerBean() {
       
    }   
    
    
	public void sendMessage(String message) {
		try {
			sendJMSMessageToHelloWorldQueue(message);
		}
		catch (JMSException ex) {
			System.out.println("JMSException");
		} 
	}

    private  Message createJMSMessageForjmsHelloWorldQueue(Session session, Object messageData) throws JMSException {        
        TextMessage tm = session.createTextMessage();
        tm.setStringProperty("type", "text");
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

}
