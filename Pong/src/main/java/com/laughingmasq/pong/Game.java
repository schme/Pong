package com.laughingmasq.pong;

import com.laughingmasq.pong.game.Board;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 * @author schme
 */
public class Game implements ActionListener {

    private Timer timer;
    private Board board;

    public Game() {
        this.timer = new Timer(16, this); // ~60fps
        this.board = new Board();
    }

    
    public void run() {}

    
    public void actionPerformed(ActionEvent ae) {
    }

}
