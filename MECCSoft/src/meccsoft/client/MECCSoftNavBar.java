package meccsoft.client;

import meccsoft.navigation.NavBar;

import com.google.gwt.user.client.ui.Image;

public class MECCSoftNavBar extends NavBar {
	
	public MECCSoftNavBar()
	{
		// Set Click/Hover
		//super(new Image("images/NavSlider.png"),new SampleMouseOverImage());
		//super(new Image("images/NavSlider.png"), new Image("images/NavSlider.png"));
		super(new Image("images/NavSlider.png"), new Image("images/Clear.png"));
		
		// Set Functionality
		//this.setAnimationDuration(250); // slide
		this.setPreLoad(true); // preload web pages
		//this.setSnapBack(true); // snap hover back to currently selected
		this.setHoverPersist(true);
		
		int top = 0;
		int height = 67;
		
		// Layer images, including Click/Hover
		this.add(new Image("images/NavBar.png"),0,0);
		this.add(getClickWidget(),0,0);
		this.add(getHoverWidget(),0,0);
		this.add(new Image("images/NavText2.png"),0,0);
		
		// Sample Call:	addTargetZone(left, top, width, height)
		this.addTargetZone("About", 0, top, 290, height,true); // About && Default
		//this.addTargetZone("Services", 290, top, 172, height); // Services
		this.addTargetZone("Contact", 300, top, 170, height); // Contact
		this.addTargetZone("Office", 470, top, 135, height); // Client
		//this.addTargetZone("Gallery", 782, top, 172, height); // Blog
	}
	
}
