package com.laughingmasq.pong.game;

import static com.laughingmasq.pong.TestVariables.BOARD_HEIGHT;
import static com.laughingmasq.pong.TestVariables.BOARD_WIDTH;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EntityTest {
	
	private Entity ball;

	@Before
	public void setUp() throws Exception {
		
		/* init ball to the middle of the screen */
		ball = new Ball(BOARD_WIDTH, BOARD_HEIGHT);
		
		ball.setVelX(5);
		ball.setVelY(2);
	}

	
	@Test
	public void movesTheCorrectAmountWithSimpleValues() {
		
		float velX = ball.getVelX();
		float velY = ball.getVelY();
		float posX = ball.getPosX();
		float posY = ball.getPosY();
		ball.move();
		
		assertEquals( posX + velX, ball.getPosX(), 0.0001);
		assertEquals( posY + velY, ball.getPosY(), 0.0001);
	}
	
	
	@Test
	public void movesTheCorrectAmountWithSimpleNegativeValues() {
		
		ball.setVelX(-32);
		ball.setVelY(-5);
		float posX = ball.getPosX();
		float posY = ball.getPosY();
		ball.move();
		
		assertEquals( posX + -32, ball.getPosX(), 0.0001);
		assertEquals( posY + -5, ball.getPosY(), 0.0001);
	}
	
	
	@Test
	public void doesNotMoveWithZeroVelocity() {
		
		ball.setVelX(0);
		ball.setVelY(0);
		float posX = ball.getPosX();
		float posY = ball.getPosY();
		ball.move();
		
		assertEquals(posX, ball.getPosX(), 0.0001);
		assertEquals(posY, ball.getPosY(), 0.0001);
	}
	
	
	@Test
	public void moveAmountMovesGivenAmount() {

		ball.moveAmount(33, -50);
		
		assertEquals(BOARD_WIDTH/2 + 33, ball.getPosX(), 0.0001);
		assertEquals(BOARD_HEIGHT/2 - 50, ball.getPosY(), 0.0001);	
	}
}
