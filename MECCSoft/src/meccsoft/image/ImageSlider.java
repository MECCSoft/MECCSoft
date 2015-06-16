package meccsoft.image;

import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.TabLayoutPanel;

public class ImageSlider extends AbsolutePanel {
	
	protected TabLayoutPanel tabPanel = new TabLayoutPanel(0, Unit.PCT);
	protected Timer timer;
	protected int tabCount = 0;
	protected Image leftButton;
	protected Image rightButton;
	// Possibly add timer milliseconds
	// Possibly add timer on/off
	// Possibly add button gap width
	// Possibly allow different button types / labels (couldn't get click to work with labels first try)
	
	public ImageSlider(int height, int width)
	{
		timer = new Timer(){
	    public void run() {
	        tabPanel.selectTab((tabPanel.getSelectedIndex()+1)%tabCount);
	        updateButtons();
	    	}        
	    };
	    timer.scheduleRepeating(5000);
	      
		tabPanel.setWidth("100%");
		tabPanel.setHeight("100%");
		tabPanel.setAnimationDuration(1000);
		
		this.setHeight(height+"PX");
		this.setWidth(width+"PX");
		
		leftButton = new Image("images/LeftArrow.png");
		rightButton = new Image("images/RightArrow.png");
		
		leftButton.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    	  tabPanel.selectTab(tabPanel.getSelectedIndex()-1);
		    	  updateButtons();
		    	  timer.cancel(); // Cancel the timer if user takes control
		      }
		});
		rightButton.addClickHandler(new ClickHandler() {
		      public void onClick(ClickEvent event) {
		    	  tabPanel.selectTab(tabPanel.getSelectedIndex()+1);
		    	  updateButtons();
		    	  timer.cancel(); // Cancel the timer if user takes control
		      }
		});
		
		this.add(tabPanel);
		// 50% down, half of button size back up.		
//		this.add(leftButton,0,(int)(height*.5)-(int)(leftButton.getHeight()/2));
//		this.add(rightButton,width-rightButton.getWidth(),(int)(height*.5)-(int)(rightButton.getHeight()/2));
		// Height and width is 45 of arrows.  getHeight and getWidth doesn't render soon enough.  Could use ID and move after constructor is set using and initialize (i think)
		this.add(leftButton,5,(int)(height*.5)-(int)(45/2));
		this.add(rightButton,width-50,(int)(height*.5)-(int)(45/2));
	}
	public void updateButtons()
	{
		if (tabPanel.getSelectedIndex()==0)
			leftButton.setVisible(false);
		else
			leftButton.setVisible(true);
		
		if (tabPanel.getSelectedIndex()==tabCount-1)
			rightButton.setVisible(false);
		else
			rightButton.setVisible(true);
	}
	public void addImage(Image img)
	{
		tabCount++; // Count the tabs
		
		img.setWidth("100%"); // Stretch the image
		img.setHeight("100%");

		tabPanel.add(img);
		updateButtons();
	}
	
}
