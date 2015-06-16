package meccsoft.navigation;


import java.util.HashMap;

import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;

public class AppController {
	private HasWidgets rootLayoutPanel;
	private Panel container;
	
	HashMap<String, Widget> widgets = new HashMap<String, Widget>();
	
	// Takes control of the root panel
	public AppController(HasWidgets rootLayoutPanel) {
		this.rootLayoutPanel = rootLayoutPanel;
	}
	
	// Take the main page somewhere
	public void goRoot(Widget container) {
		this.rootLayoutPanel.clear();
		this.rootLayoutPanel.add(container);
	}

	// Set an internal content panel
	public Widget setContentPanel(Panel container)
	{
		return this.container=container;
	}
	
	// Go with a specific container
	public void go(final Widget container) {
		this.container.clear();
		this.container.add(container);
	}
	
	// Go using token string.
	public void go(final String token)
	{
		if (token != null) {
			this.go(getWidget(token));
		}
	}
	
	// Creates and returns a widget
	private Widget getWidget(String token)
	{
		if (widgets.get(token) == null)
			widgets.put(token, loadPage(token));
		return widgets.get(token);
	}
	
	public Widget loadPage(String token)
	{
		return null;
	}

}