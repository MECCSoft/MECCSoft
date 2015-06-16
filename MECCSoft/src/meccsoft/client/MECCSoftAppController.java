package meccsoft.client;

import meccsoft.navigation.AppController;

import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class MECCSoftAppController extends AppController {
		
	public MECCSoftAppController(HasWidgets rootLayoutPanel)
	{
		super(rootLayoutPanel);
	}
	
	
	// Navigation.  Creates widget if not already created.
	public Widget loadPage(String token)
	{

		if (token == "About") 
			return new AboutPage();
		else if (token == "Contact") 
			return new ContactPage();
		else if (token == "Office")
			return new Office();
		else 
			return new HTML("<large><b>Page not found.</b></large>");
		
	}

}
