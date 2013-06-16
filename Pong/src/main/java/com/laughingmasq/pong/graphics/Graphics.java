
package com.laughingmasq.pong.graphics;

import java.util.List;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import com.laughingmasq.pong.game.Entity;
 
/**
 * Combines the graphic settings. Handles window, sync rate and rendering that is not
 * related to a certain entity (sprites do that).
 * @author schme
 */
public class Graphics {
	
	
	private String title = "Pong Alpha v0.9";
	
	/** for faster circle drawing */
	private final float DEG2RAD = (float)3.14159/180;
	
	private int resolutionX;
	private int resolutionY;
	private int fps = 60;
	
	/** the dimensions for the middle line */
	private float middleLineWidth = 10f;
	private float middleBallRadius = 15f;
	
	/** settings for score displaying */
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
    
    
    /**
     * Draw things behind the entities. e.g. the middle line.
     */
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
    
    
    /**
     * Draw a score box.
     * @param x		X value of the top left corner of the score box.
     * @param y		Y value of the top left corner of the score box.
     */
    private void drawScore(float x, float y) {
    	
    	GL11.glBegin(GL11.GL_QUADS);
    	GL11.glVertex2f(x, y);
    	GL11.glVertex2f(x + scoreSide, y);
    	GL11.glVertex2f(x + scoreSide, y + scoreSide);
    	GL11.glVertex2f(x, y + scoreSide);
    	GL11.glEnd();
    }
    
    
    /**
     * Draw the current scores as tiny green squares.
     * @param leftScore		Score of the left player
     * @param rightScore	Score of the right player
     */
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
     * If X (in the game window) has been pressed.
     * @return	True if X has been pressed, false otherwise.
     */
    public boolean isCloseRequested() {
    	return Display.isCloseRequested();
    }
    
    
    /**
     * Does all the drawing. If you something to be drawn, add it here.
     * @param entities		List of entities on the board
     * @param leftScore		Score for the left hand player
     * @param rightScore	Score for the right hand player
     * @param paused		If the game is currently paused
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
     
    	/** darkens the screen */
    	if(paused) { pause(); }
    	
    	update();
        
    }
    
    
    /**
     * Called when resized. Adjust the viewport.
     */
    public void resize() {
    	GL11.glViewport(0, 0, Display.getWidth(), Display.getHeight());
    }
    
    
    /**
     * Swaps the framebuffer and calls the sync function.
     */
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
    
    
    /**
     * Dims the screen (draws an opaque dark square on the board).
     * Used when the game is paused.
     */
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