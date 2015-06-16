package meccsoft.client;

import meccsoft.shared.FieldVerifier;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class Office extends Composite {

	private static OfficeUiBinder uiBinder = GWT.create(OfficeUiBinder.class);

	@UiField Button btnLogin;
	@UiField Button btnSignup;
	@UiField TextBox txtUserName;
	@UiField PasswordTextBox txtPassword;
	@UiField Label lblResult;
	
	interface OfficeUiBinder extends UiBinder<Widget, Office> {
	}

	public Office() {
		initWidget(uiBinder.createAndBindUi(this));
		
		btnLogin.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (!FieldVerifier.isValidUserName(txtUserName.getText(),txtUserName)) {
					lblResult.setText("User Name must be at least 6 characters long.");
					return;
				}
				if (!FieldVerifier.isValidPassword(txtPassword.getText(),txtPassword)) {
					lblResult.setText("Password must be at least 6 characters long.");
					return;
				}
				
				// VerifyLogin
			}
		});
		
		btnSignup.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (!FieldVerifier.isValidUserName(txtUserName.getText(),txtUserName)) {
					lblResult.setText("User Name must be at least 6 characters long.");
					return;
				}
				if (!FieldVerifier.isValidPassword(txtPassword.getText(),txtPassword)) {
					lblResult.setText("Password must be at least 6 characters long.");
					return;
				}
				
				// CreateAccount
			}
		});
		
		
	}

}
