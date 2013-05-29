package com.laughingmasq.pong.game;


import static com.laughingmasq.pong.TestVariables.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test the Ball- and Entity- class.
 * @author schme
 *
 */
public class BallTest {
	
	private Ball ball;

	@Before
	public void setUp() throws Exception {
		
		/* init ball to the middle of the screen */
		ball = new Ball(BOARD_WIDTH/2, BOARD_HEIGHT/2);
		ball.setVelX(5);
		ball.setVelY(2);
	}
	
	@Test
	public void ballIsWhereItIsInitiatedTo() {
		assertEquals(ball.getPosX(), BOARD_WIDTH/2, 0.0001);
		assertEquals(ball.getPosY(), BOARD_HEIGHT/2, 0.0001);
	}

	@Test
	/**
	 * Mainly an Entity-test more than a Ball test.
	 */
	public void ballMovesTheCorrectAmount() {
		float velX = ball.getVelX();
		float velY = ball.getVelY();
		float posX = ball.getPosX();
		float posY = ball.getPosY();
		ball.move();
		
		
		assertEquals( posX + velX, ball.getPosX(), 0.0001);
		assertEquals( posY + velY, ball.getPosY(), 0.0001);
	}
}
