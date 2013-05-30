
package com.laughingmasq.pong.graphics;

import java.util.List;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import com.laughingmasq.pong.game.Entity;
 
/**
 * Combines the graphic settings. Handles most of the calls to lwjgl.
 * @author schme
 */
public class Graphics {
	
	
	private String title = "Pong v0.01";
	
	
	private int resolutionX;
	private int resolutionY;
	private int fps = 60;
	
	/* for the fun of it, mostly debug */
	private boolean clearScreen = true;

	
	/**
	 * Initializes the graphic environment.
	 * @param resolutionX	Screen width.
	 * @param resolutionY	Screen height.
	 */
    public Graphics(int resolutionX, int resolutionY) {
    	this.resolutionX = resolutionX;
    	this.resolutionY = resolutionY;
    	initialize();
    }

    
    /**
     * Initializes the graphics.
     */
    private void initialize() {
    	
    	
    	Display.setTitle(title);
    	Display.setResizable(true);
    	    	
        try {
        	
    	    Display.setDisplayMode(new DisplayMode(resolutionX,resolutionY));  	    
    	    Display.create();
    	    
    	    
    		GL11.glMatrixMode(GL11.GL_PROJECTION);
    		GL11.glLoadIdentity();
    		GL11.glOrtho(0, resolutionX, 0, resolutionY, 1, -1);
    		GL11.glMatrixMode(GL11.GL_MODELVIEW);
    		
    	    //glDisable(GL_DEPTH_TEST);   
    	    GL11.glEnable(GL11.GL_BLEND);
    	    GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    	    
    	    GL11.glClearColor(0f, 0f, 0f, 0f);
    	    
    	    
    	} catch (LWJGLException e) {
    	    e.printStackTrace();
    	    System.exit(0);
    	}
     
        
    }
    
    
    /**
     * If X has been pressed.
     * @return	True if X has been pressed, false otherwise.
     */
    public boolean isCloseRequested() {
    	return Display.isCloseRequested();
    }
    
    
    /**
     * Handles all the drawing.
     * @param entities
     */
    public void draw(List<Entity> entities) {
    	
    	if(Display.wasResized()) {
    		resize();
    	}
    	
    	if(clearScreen) {
    		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
    	}
    	
    	for( Entity e : entities) {
    		e.draw();
    	}
     
    	Display.update(); //Swaps the framebuffer
    	Display.sync(fps);
        
    }
    
    
    /**
     * Called when resized.
     */
    public void resize() {
    	GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
    }
    
    
    /**
     * Cleaner, called when exiting.
     */
    public void destroy() {
    	Display.destroy();
    }

}