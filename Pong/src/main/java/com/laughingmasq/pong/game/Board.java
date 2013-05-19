
package com.laughingmasq.pong.game;

/**
 * @author schme
 */
public class Board {

    private Ball ball;
    private Collision collision;

    private int ballR = 15;

    public Board() {
        this.ball = new Ball(ballR);
        this.collision = new Collision();
    }

    public void tick() {

    }

}
