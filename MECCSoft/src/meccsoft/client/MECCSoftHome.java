package meccsoft.client;

import meccsoft.navigation.NavBar;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;

public class MECCSoftHome extends Composite {

	private static MECCSoftStackUiBinder uiBinder = GWT
			.create(MECCSoftStackUiBinder.class);
	@UiField FlowPanel contentPanel;
	@UiField NavBar navBar;

	
	interface MECCSoftStackUiBinder extends UiBinder<Widget, MECCSoftHome> {
	}

	public MECCSoftHome(MECCSoftAppController ac) {
		initWidget(uiBinder.createAndBindUi(this));
		
		ac.setContentPanel(contentPanel);
		navBar.setAppController(ac);
		ac.go("About");
	}
		
}
