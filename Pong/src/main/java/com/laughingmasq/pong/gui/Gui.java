
package com.laughingmasq.pong.gui;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
 
/**
 * @author schme
 */
public class Gui {
	
	int resolutionX = 1440;
	int resolutionY = 900;

    public Gui() {}

    public void run() {
    	
        try {
    	    Display.setDisplayMode(new DisplayMode(resolutionX,resolutionY));
    	    Display.create();
    	} catch (LWJGLException e) {
    	    e.printStackTrace();
    	    System.exit(0);
    	}
     
    	// init OpenGL here
     
    	while (!Display.isCloseRequested()) {
     
    	    // render OpenGL here
     
    	    Display.update();
    	}
     
    	Display.destroy();
        
    }

}