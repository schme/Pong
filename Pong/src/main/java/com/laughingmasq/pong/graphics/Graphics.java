
package com.laughingmasq.pong.graphics;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.laughingmasq.pong.InputHandler;
 
/**
 * @author schme
 */
public class Graphics {
	
	
	private String WINDOW_TITLE = "Pong v0.01";
	
	private int resolutionX = 1440;
	private int resolutionY = 900;
	
	/** Object with all the control of controls */
	private InputHandler inputHandler;

    public Graphics() {
    	initialize();
    	inputHandler = new InputHandler();
    }

    
    private void initialize() {
    	
    	
    	Display.setTitle(WINDOW_TITLE);
    	    	
        try {
    	    Display.setDisplayMode(new DisplayMode(resolutionX,resolutionY));
    	    Display.create();
    	} catch (LWJGLException e) {
    	    e.printStackTrace();
    	    System.exit(0);
    	}
     
    	
        
    }
    
    
    public void run() {

    	while (!Display.isCloseRequested()) {
     
    	    // render here
     
    	    Display.update(); //Swaps the framebuffer
    	}
     
    	Display.destroy();
        
    }

}