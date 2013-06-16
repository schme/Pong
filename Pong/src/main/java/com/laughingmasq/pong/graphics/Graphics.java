
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
	
	/** for faster circle drawing */
	private final float DEG2RAD = (float)3.14159/180;
	
	private int resolutionX;
	private int resolutionY;
	private int fps = 60;
	
	private float middleLineWidth = 10f;
	private float middleBallRadius = 15f;
	
	private float scorePadding = 30f;
	private float scoreGap = 5f;
	private float scoreSide = 5f;
	
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
    
    
    private void drawBackground() {
    	
		GL11.glColor3f(0.2f,0.2f,0.2f);
		
	    GL11.glBegin(GL11.GL_QUADS);
	    GL11.glVertex2f(resolutionX/2 - middleLineWidth/2, 0);
		GL11.glVertex2f(resolutionX/2 - middleLineWidth/2,resolutionY);
		GL11.glVertex2f(resolutionX/2 + middleLineWidth/2,resolutionY);
		GL11.glVertex2f(resolutionX/2 + middleLineWidth/2, 0);
	    GL11.glEnd();
	    
		GL11.glColor3f(0.2f,0.2f,0.2f);

		GL11.glBegin(GL11.GL_TRIANGLE_FAN);

		for (int i=0; i < 360; i++)
		{
			float degInRad = i*DEG2RAD;
			GL11.glVertex2f((float)Math.cos(degInRad)*middleBallRadius + resolutionX/2,
							(float)Math.sin(degInRad)*middleBallRadius + resolutionY/2);
		}

		GL11.glEnd();
    }
    
    
    private void drawScore(float x, float y) {
    	
    	GL11.glBegin(GL11.GL_QUADS);
    	GL11.glVertex2f(x, y);
    	GL11.glVertex2f(x + scoreSide, y);
    	GL11.glVertex2f(x + scoreSide, y + scoreSide);
    	GL11.glVertex2f(x, y + scoreSide);
    	GL11.glEnd();
    }
    
    
    private void drawScores(int leftScore, int rightScore) {
    	
    	GL11.glColor3f(0.0f, 1.0f, 0.0f);
    	
    	for( int i=0; i < leftScore; i++) {
    		drawScore(resolutionX/2 - scorePadding - (i+1)*scoreSide - i*scoreGap,
    				  resolutionY - scorePadding);
    	}
    	
    	for( int i=0; i < rightScore; i++) {
    		drawScore(resolutionX/2 + scorePadding + i*scoreSide + i*scoreGap,
    				  resolutionY - scorePadding);
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
    public void draw(List<Entity> entities, int leftScore, int rightScore, boolean paused) {
    	
    	
    	if(Display.wasResized()) {
    		resize();
    	}
    	
    	if(clearScreen) {
    		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
    	}
    	
    	drawBackground();
    	drawScores(leftScore, rightScore);
    	
    	for( Entity e : entities) {
    		e.draw();
    	}
     
    	if(paused) { pause(); }
    	
    	update();
        
    }
    
    
    /**
     * Called when resized.
     */
    public void resize() {
    	GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
    }
    
    
    public void update() {
    	Display.update();	// Swaps the framebuffer
    	Display.sync(fps);
    }
    
    
    /**
     * Cleaner, called when exiting.
     */
    public void destroy() {
    	Display.destroy();
    }
    
    
    public void pause() {
    	
    	GL11.glColor4f(0f, 0f, 0f, 0.5f);
	    GL11.glBegin(GL11.GL_QUADS);
	    GL11.glVertex2f(0,0);
		GL11.glVertex2f(0,resolutionY);
		GL11.glVertex2f(resolutionX, resolutionY);
		GL11.glVertex2f(resolutionX, 0);
	    GL11.glEnd();
	    
    }

}