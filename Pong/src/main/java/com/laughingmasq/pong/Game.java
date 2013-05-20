package com.laughingmasq.pong;

import com.laughingmasq.pong.game.Board;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author schme
 */
public class Game implements ActionListener {

    private Board board = null;

    public Game() {
        this.board = new Board();
    }

    
    public void run() {}

    
    public void actionPerformed(ActionEvent ae) {
    }

}
