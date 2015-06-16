package meccsoft.animation;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.Element;

public class MoveElementAnimation extends Animation {
    private final Element element;
    private int startX;
    private int startY;
    private int startW;
    private int startH;
    
    private int finalX;
    private int finalY;
    private int finalW;
    private int finalH;
    
 
    public MoveElementAnimation(Element element)
    {
        this.element = element;
    }
 
    public void scrollTo(int x, int y, int w, int h, int milliseconds)
    {
        this.finalX = x;
        this.finalY = y;
        this.finalW = w;
        this.finalH = h;
 
        startX = element.getOffsetLeft();
        startY = element.getOffsetTop();
        startW = element.getOffsetWidth();
        startH = element.getOffsetHeight();
 
        run(milliseconds);
    }
 
    @Override
    protected void onUpdate(double progress)
    {
        double positionX = startX + (progress * (this.finalX - startX));
        double positionY = startY + (progress * (this.finalY - startY));

        double positionW = startW + (progress * (this.finalW - startW));
        double positionH = startH + (progress * (this.finalH - startH));
        
        this.element.getStyle().setWidth(positionW, Unit.PX);
        this.element.getStyle().setHeight(positionH, Unit.PX);
        
        this.element.getStyle().setLeft(positionX, Unit.PX);
        this.element.getStyle().setTop(positionY, Unit.PX);
    }
 
    @Override
    protected void onComplete()
    {
        super.onComplete();
        this.element.getStyle().setLeft(this.finalX, Unit.PX);
        this.element.getStyle().setTop(this.finalY, Unit.PX);
        this.element.getStyle().setWidth(this.finalW, Unit.PX);
        this.element.getStyle().setHeight(this.finalH, Unit.PX);
    }
}
