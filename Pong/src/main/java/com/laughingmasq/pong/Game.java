package com.laughingmasq.pong;

import com.laughingmasq.pong.game.Board;
import com.laughingmasq.pong.gui.Gui;

/**
 * @author schme
 */
public class Game {

    private Board board = null;
    private Gui gui	= null;

    public Game() {
        this.board = new Board();
        this.gui   = new Gui();
    }

    
    public void run() {
    	gui.run();
    }

}
