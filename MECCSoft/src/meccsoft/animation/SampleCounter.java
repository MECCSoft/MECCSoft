package meccsoft.animation;

import com.google.gwt.animation.client.Animation;


public class SampleCounter extends Animation {
	
	int Counter = 0;
	
    @Override
    protected void onComplete() {
      super.onComplete();
    }

    @Override
    protected void onStart() {
      super.onStart();
    }

    @Override
    protected void onUpdate(double progress) {
    	Counter++;
    }

}