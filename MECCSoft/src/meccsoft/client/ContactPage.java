package meccsoft.client;

import meccsoft.email.EmailService;
import meccsoft.email.EmailServiceAsync;
import meccsoft.shared.FieldVerifier;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ContactPage extends Composite {

	private static ContactPageUiBinder uiBinder = GWT
			.create(ContactPageUiBinder.class);

	interface ContactPageUiBinder extends UiBinder<Widget, ContactPage> {
	}

	private final EmailServiceAsync emailService = GWT
			.create(EmailService.class);
	
	@UiField Button submitButton;
	@UiField TextArea txtBody;
	@UiField TextBox txtEmail;
	@UiField TextBox txtCompany;
	@UiField TextBox txtName;
	@UiField Label resultLabel;
	
	public ContactPage() {
		initWidget(uiBinder.createAndBindUi(this));
		
		
		submitButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (!FieldVerifier.isValidEmail(txtEmail.getText(),txtEmail)) {
					resultLabel.setText("Email is not a valid format.");
					return;
				}

				emailService.sendMail("michaelemerick@meccsoft.com", "info@meccsoft.com", 
						"MECCSoft: Web Site Submission", 
						"Name: "+txtName.getText()+"\n"+
						"Email: "+txtEmail.getText()+"\n"+
						"Company: "+txtCompany.getText()+"\n"+
						"Body: \n"+txtBody.getText(),
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								resultLabel.setText(caught.getMessage());
							}

							public void onSuccess(String result) {
								resultLabel.setText(result);
							}
						});
				txtName.setText("");
				txtEmail.setText("");
				txtCompany.setText("");
				txtBody.setText("");
			}
		});
		
		
	}

}
