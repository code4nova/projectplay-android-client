package com.sarlhack.projectplay;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import org.apache.cordova.*;

public class Main extends DroidGap {
	
	protected float ORIG_APP_W = 1280;
    protected float ORIG_APP_H = 800;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
    	super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        super.loadUrl("file:///android_asset/www/index.html");
        
        // get actual screen size
        Display display = ((WindowManager) getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        int width = display.getWidth(); 
        int height = display.getHeight(); 

        // calculate target scale (only dealing with portrait orientation)
        double globalScale = Math.ceil( ( width / ORIG_APP_W ) * 100 );

        // make sure we're all good
        Log.v( TAG, "ORIG_APP_W" + " = " + ORIG_APP_W );
        Log.v( TAG, "ORIG_APP_H" + " = " + ORIG_APP_H );
        Log.v( TAG, "width" + " = " + width );
        Log.v( TAG, "this.appView.getMeasuredHeight() = " + height );
        Log.v( TAG, "globalScale = " + globalScale );
        Log.v( TAG, "this.appView.getScale() index=" + this.appView.getScale() );

        // set the scale
        this.appView.setInitialScale( (int)globalScale );
    }
}
