package com.laughingmasq.pong;

import com.laughingmasq.pong.game.*;
import com.laughingmasq.pong.graphics.*;

/**
 * @author schme
 * Basically combines logic and graphic.
 */
public class Game {
	
	private int resolutionX = 1440;
	private int resolutionY = 900;
	
	private boolean playing = false;

	/** Logical */
    private Board board;
    
    /** Graphical */
    private Graphics graphics;
    
    public Game() {
        this.board 		= new Board(resolutionX, resolutionY);
        this.graphics   = new Graphics(resolutionX, resolutionY);
    }

    
    public void run() {
    	
    	playing = true;
    	
    	
    	while( playing && !graphics.isCloseRequested() ) {
    		board.handleInput();
    		board.move();
    		graphics.draw(board.getEntities());
    	}
    	
    	graphics.destroy();
    }
    

}