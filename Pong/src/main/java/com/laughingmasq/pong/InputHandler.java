package com.laughingmasq.pong;

import static org.lwjgl.input.Keyboard.*;
import org.lwjgl.input.Keyboard;
import com.laughingmasq.pong.game.Board;


/**
 * Handles all incoming input and relays it to a Board class.
 * @author schme
 *
 */
public class InputHandler {
	
	/** for relaying the proper actions */
	private Board board;
	
	/**
	 * Create an InputHandler for a certain board.
	 * @param board	The board we will be doing our actions on.
	 */
	public InputHandler(Board board) {
		this.board = board;
	}
	
	
	/**
	 * Runs the private methods for handling input and communicates to the board
	 * what to do.
	 */
	public void handleInput() {
		while( Keyboard.next() ) {
			
			ifPause();
			leftPlayer();
			rightPlayer();
		}
	}
	
	
	/**
	 * Takes the input from the left side player.
	 */
	private void leftPlayer() {
		
		if( Keyboard.isKeyDown(KEY_W)) {
			board.getPadLeft().movingUp();
			
		} else if( Keyboard.isKeyDown(KEY_S)) {			
			board.getPadLeft().movingDown();
			
		} else {
			board.getPadLeft().stop();
		}
	}
	
	
	/**
	 * Takes the input from the right side player.
	 */
	private void rightPlayer() {
		
		if( Keyboard.isKeyDown(KEY_UP)) {
			board.getPadRight().movingUp();
			
		} else if( Keyboard.isKeyDown(KEY_DOWN)) {
			board.getPadRight().movingDown();
			
		} else {
			board.getPadRight().stop();
		}
	}
	
	
	/**
	 * Checks if the games pause key is pressed.
	 */
	private void ifPause() {
		
		if( Keyboard.isKeyDown(KEY_P)) {
			board.pause();
		}
	}
	
}