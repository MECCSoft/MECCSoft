package meccsoft.email;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EmailServiceAsync {
	void sendMail(String from, String to, String subject, String body, AsyncCallback<String> callback)
			throws IllegalArgumentException;
}
