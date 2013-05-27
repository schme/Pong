package com.laughingmasq.pong;

import org.lwjgl.LWJGLException;
import static org.lwjgl.input.Keyboard.*;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import com.laughingmasq.pong.game.Board;



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
	
	
	public void handleInput() {
		while( Keyboard.next() ) {
			leftPlayer();
			rightPlayer();
		}
	}
	
	
	private void leftPlayer() {
		
		if( Keyboard.isKeyDown(KEY_W)) {
			board.getPadLeft().movingUp();
			
		} else if( Keyboard.isKeyDown(KEY_S)) {			
			board.getPadLeft().movingDown();
			
		} else {
			board.getPadLeft().stop();
		}
	}
	
	
	private void rightPlayer() {
		if( Keyboard.isKeyDown(KEY_UP)) {
			board.getPadRight().movingUp();
			
		} else if( Keyboard.isKeyDown(KEY_DOWN)) {
			board.getPadRight().movingDown();
			
		} else {
			board.getPadRight().stop();
		}
	}
	
}