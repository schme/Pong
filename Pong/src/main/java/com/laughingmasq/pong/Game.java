package com.laughingmasq.pong;

import com.laughingmasq.pong.game.Board;
import com.laughingmasq.pong.graphics.Graphics;

/**
 * @author schme
 * Basically combines logic and graphic.
 */
public class Game {
	
	private boolean playing = false;

	/** Logical */
    private Board board;
    
    /** Graphical */
    private Graphics graphics;
    
    /** Input */
    private static InputHandler inputHandler = new InputHandler();

    
    public Game() {
        this.board = new Board();
        this.graphics   = new Graphics();
    }

    
    public void run() {
    	
    	playing = true;
    	
    	
    	while( playing && !graphics.isCloseRequested() ) {
    		graphics.draw();
    	}
    	
    	graphics.destroy();
    }

}