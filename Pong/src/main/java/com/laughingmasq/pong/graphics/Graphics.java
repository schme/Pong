
package com.laughingmasq.pong.graphics;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import com.laughingmasq.pong.InputHandler;
 
/**
 * @author schme
 */
public class Graphics {
	
	
	private String title = "Pong v0.01";
	
	
	private int resolutionX = 1440;
	private int resolutionY = 900;

	
    public Graphics() {
    	initialize();
    }

    
    private void initialize() {
    	
    	
    	Display.setTitle(title);
    	    	
        try {
    	    Display.setDisplayMode(new DisplayMode(resolutionX,resolutionY));
    	    Display.create();
    	} catch (LWJGLException e) {
    	    e.printStackTrace();
    	    System.exit(0);
    	}
     
        
    }
    
    
    public boolean isCloseRequested() {
    	return Display.isCloseRequested();
    }
    
    
    public void draw() {
     
    	// render here
     
    	Display.update(); //Swaps the framebuffer
        
    }
    
    
    public void destroy() {
    	Display.destroy();
    }

}