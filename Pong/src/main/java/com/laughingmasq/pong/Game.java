package com.laughingmasq.pong;

import com.laughingmasq.pong.game.Board;
import com.laughingmasq.pong.graphics.Graphics;

/**
 * @author schme
 * Contains some of the logic in itself, but basically combines logic and
 * graphic.
 */
public class Game {

	/** Logical */
    private Board board;
    
    /** Graphical */
    private Graphics gui;

    
    public Game() {
        this.board = new Board();
        this.gui   = new Graphics();
    }

    
    public void run() {
    	gui.run();
    }

}
