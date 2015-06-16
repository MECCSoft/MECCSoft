package meccsoft.email;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client side stub for the RPC service.
 */
@RemoteServiceRelativePath("email")
public interface EmailService extends RemoteService {
	String sendMail(String from, String to, String subject, String body) throws IllegalArgumentException;
}
