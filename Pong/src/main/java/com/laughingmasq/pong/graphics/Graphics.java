
package com.laughingmasq.pong.graphics;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_DEPTH_TEST;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glViewport;

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
    	Display.setResizable(true);
    	    	
        try {
    	    Display.setDisplayMode(new DisplayMode(resolutionX,resolutionY));
    	    
    	    glDisable(GL_DEPTH_TEST);
    	    
    	    glEnable(GL_BLEND);
    	    glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    	    
    	    glClearColor(0f, 0f, 0f, 0f);
    	    
    	    //init here
    	    
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