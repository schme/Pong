package com.laughingmasq.pong;

import com.laughingmasq.pong.game.*;
import com.laughingmasq.pong.graphics.*;

/**
 * @author schme
 * Combines logic and graphic.
 * 
 * This class relays information between graphics and logic. See Board class to
 * compare what part of logic is held in here, and what in Board.
 */
public class Game {
	
	/** The size of the board */
	private int boardWidth = 1440;
	private int boardHeight = 900;
	
	private boolean playing = false;

	/** Logical */
    private Board board;
    
    /** Graphical */
    private Graphics graphics;
    
    /**
     * Game takes no arguments. Initializes a board and a graphics class.
     */
    public Game() {
        this.board 		= new Board(boardWidth, boardHeight);
        this.graphics   = new Graphics(boardWidth, boardHeight);
    }

    /**
     * Starting point for the program. Contains the game loop.
     */
    public void run() {
    	
    	playing = true;
    	
    	
    	while( playing && !graphics.isCloseRequested() ) {
    		
    		board.handleInput();
 
    		/** if board is paused, don't move entities */
    		if( !board.isPaused() && board.moveEntities()) {
    			board.resetBall();
    		}
    		graphics.draw(board.getEntities(), board.getLeftScore(), board.getRightScore(),
    						board.isPaused());
    	}
    	
    	graphics.destroy();
    }
    

}