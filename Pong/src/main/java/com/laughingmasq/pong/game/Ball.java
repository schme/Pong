package com.laughingmasq.pong.game;

/**
 * @author schme
 */
public class Ball {

    private double posX = 0;
    private double posY = 0;
    private double dirX = 0;
    private double dirY = 0;
    private double velX = 0;
    private double velY = 0;

    private int radius = 0;


    public Ball(int radius) {
        this.radius = radius;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }


}
