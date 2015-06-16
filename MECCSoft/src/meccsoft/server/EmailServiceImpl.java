package meccsoft.server;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import meccsoft.email.EmailService;
import meccsoft.shared.FieldVerifier;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class EmailServiceImpl  extends RemoteServiceServlet implements EmailService
{
	private static final long serialVersionUID = 4918295768416969248L;

	public String sendMail(String from, String to, String subject, String body)
	{

		Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);
        String message;
        
		if (!FieldVerifier.isValidEmail(from)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			message = "Please enter a valid email.";
		}
		else
		{
	        try {
	            Message msg = new MimeMessage(session);
	            msg.setFrom(new InternetAddress(from));
	            msg.addRecipient(Message.RecipientType.TO,
	                    new InternetAddress(to, "MECCSoft LLC"));
	            msg.setSubject(subject);
	            msg.setText(body);
	            Transport.send(msg);
	            message = "Thank you!";
	
	        } catch (AddressException e) {
	            message = "Sorry, there was an e-mail address error!";
	        } catch (MessagingException e) {
	            message = "Sorry, there was an message error!\n"+e.getMessage();
	        } catch (Exception e) {
	            message = "Sorry, an unknown error has occured!\n"+e.getMessage();
	        }
		}
		return message;
	}

}