package backend;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailHelper {
	
	public EmailHelper(){
		Properties properties = new Properties();
		properties.put("mail.smtp.starttls.enable",  "true");
		properties.put("mail.smtp.auth",  "true");
		properties.put("mail.smtp.host",  "smtp.gmail.com");
		properties.put("mail.smtp.port",  "587");
		
		Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("zach.md.sims97@gmail.com", "zachery1997");
			}
		});
		
		try{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("zach.md.sims97@gmail.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("milolika.smol@gmail.com"));
			message.setSubject("hey there");
			message.setText("your mom gay");
			
			Transport.send(message);
		}
		catch(MessagingException e){
			e.printStackTrace();
		}
	}
}
