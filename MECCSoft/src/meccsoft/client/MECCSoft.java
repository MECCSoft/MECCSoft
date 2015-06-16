package meccsoft.client;


import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootLayoutPanel;

public class MECCSoft implements EntryPoint {

	public void onModuleLoad() {
        
		MECCSoftAppController appViewer = new MECCSoftAppController(RootLayoutPanel.get());
		appViewer.goRoot(new MECCSoftHome(appViewer));
        
	}

}