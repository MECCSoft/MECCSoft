package meccsoft.navigation;

import meccsoft.animation.MoveElementAnimation;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;

public class NavBar extends AbsolutePanel {
	
	private MoveElementAnimation clickElement;
	private MoveElementAnimation hoverElement;
	
	private Widget clickWidget;
	private Widget hoverWidget;
	
	private AppController ac;
	private Boolean preLoad = false;
	private Boolean snapBack = true;
	private Boolean hoverPersist = false;
	private int animationDuration = 0;

	
	public NavBar(Widget clickWidget, Widget hoverWidget)
	{
		setClickWidget(clickWidget);
		setHoverWidget(hoverWidget);
	}
	public NavBar(Widget clickWidget)
	{
		this(clickWidget, new Image("images/clear.png"));
	}
	public NavBar()
	{
		this(new Image("images/clear.png"));
	}
	
	protected void targetZoneClick(String id)
	{
		if (ac!= null)
			ac.go(id);
	}
	protected void targetZoneMouseOver(String id)
	{
		if (preLoad && ac != null)
			this.ac.loadPage(id);
	}
	protected void targetZoneMouseOut(String id)
	{
	}
	
	public AppController getAppController() 
	{
		return ac;
	}
	public void setAppController(AppController ac) 
	{
		this.ac = ac;
	}
	public Boolean getPreLoad() {
		return preLoad;
	}
	public void setPreLoad(Boolean preLoad) {
		this.preLoad = preLoad;
	}
	public Boolean getSnapBack() {
		return snapBack;
	}
	public void setSnapBack(Boolean snapBack) {
		this.snapBack = snapBack;
	}
	public MoveElementAnimation getClickElement() {
		return clickElement;
	}
	public void setClickElement(MoveElementAnimation clickElement) {
		this.clickElement = clickElement;
	}
	public MoveElementAnimation getHoverElement() {
		return hoverElement;
	}
	public void setHoverElement(MoveElementAnimation hoverElement) {
		this.hoverElement = hoverElement;
	}
	public Widget getClickWidget() {
		return clickWidget;
	}
	public void setClickWidget(Widget clickWidget) {
		this.clickWidget = clickWidget;
		this.clickElement = new MoveElementAnimation(clickWidget.getElement());
	}
	public Widget getHoverWidget() {
		return hoverWidget;
	}
	public void setHoverWidget(Widget hoverWidget) {
		this.hoverWidget = hoverWidget;
		this.hoverElement = new MoveElementAnimation(hoverWidget.getElement());
	}
	public int getAnimationDuration() {
		return animationDuration;
	}
	public void setAnimationDuration(int animationDuration) {
		this.animationDuration = animationDuration;
	}
	public Boolean getHoverPersist() {
		return hoverPersist;
	}
	public void setHoverPersist(Boolean hoverPersist) {
		this.hoverPersist = hoverPersist;
	}
	
	
	public void addTargetZone(final String id, final int left, final int top, final int width, final int height)
	{
		Image tz = new Image("images/Clear.png");
		tz.setStyleName("ImageLink");
		tz.setWidth(width+"PX");
		tz.setHeight(height+"PX");
		
		tz.addMouseOverHandler(new MouseOverHandler() {
			@Override
			public void onMouseOver(MouseOverEvent event) {
				hoverWidget.fireEvent(event); // Don't think this does anything...
				if (!hoverPersist)
					hoverWidget.setVisible(true);
				if (hoverElement != null) // Move hover widget to TargetZone
					hoverElement.scrollTo(left, top, width, height, animationDuration);
				targetZoneMouseOver(id);
			}
		});
		
		tz.addMouseOutHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				hoverWidget.fireEvent(event); // Don't think this does anything...
				if (!hoverPersist)
					hoverWidget.setVisible(false);
				if (hoverElement != null && clickElement != null && snapBack) // Go hover widget to Click widget Location (could be wrong if they are quick and animation is set)
					hoverElement.scrollTo(clickWidget.getElement().getOffsetLeft(), clickWidget.getElement().getOffsetTop(), 
							clickWidget.getElement().getOffsetWidth(), clickWidget.getElement().getOffsetHeight(), animationDuration);
				targetZoneMouseOut(id);				
			}
		});
		
		tz.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				clickWidget.fireEvent(event); // Don't think this does anything...
				if (clickElement != null) // Move click widget to TargetZone
					clickElement.scrollTo(left, top, width, height, animationDuration);
				targetZoneClick(id);
			}
		});
		
		if (!hoverPersist)
			hoverWidget.setVisible(true);
		
		this.add(tz,left,top);
	}
	public void addTargetZone(final String id, final int left, final int top, final int width, final int height, boolean go)
	{
		if (go)
		{
			hoverElement.scrollTo(left, top, width, height, animationDuration);
			clickElement.scrollTo(left, top, width, height, animationDuration);
		}
		addTargetZone(id,left, top, width, height);
	}

	
	
}
