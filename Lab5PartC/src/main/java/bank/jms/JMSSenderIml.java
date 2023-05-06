package bank.jms;

import org.springframework.stereotype.Service;

@Service
public class JMSSenderIml implements JMSSender {
	
	public void sendJMSMessage (String text){
		System.out.println("JMSSender: sending JMS message ="+text);
	}

}
