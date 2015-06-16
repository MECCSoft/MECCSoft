package meccsoft.image;

import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;

public class MouseOverImage extends AbsolutePanel {
	Image img1;
	Image img2;
	
	public MouseOverImage(String path1, String path2){
		
		img1 = new Image(path1);
		img2 = new Image(path2);
		
		this.add(img1,0,0);
		this.add(img2,0,0);
		
		img1.setVisible(true);
		img2.setVisible(false);
		
		img1.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				img1.setVisible(false);
				img2.setVisible(true);
			}
		});
		img2.addMouseOutHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				img1.setVisible(true);
				img2.setVisible(false);				
			}
		});
		
	

	}
}
