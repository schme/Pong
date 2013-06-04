package com.laughingmasq.pong.game;


import static com.laughingmasq.pong.TestVariables.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Test the Ball and Entity classes.
 * @author schme
 *
 */
public class BallTest {
	
	private Ball ball;
	
	@Before
	public void setUp() throws Exception {
		
		/* init ball to the middle of the screen */
		ball = new Ball(BOARD_WIDTH, BOARD_HEIGHT);
		
		ball.setVelX(5);
		ball.setVelY(2);
	}
	
	
	@Test
	public void ballInitiatesPosToOrigoOnNegativeBoardValues() {
		
		ball = new Ball(-1440, -900);
		
		assertEquals(0, ball.getPosX(), 0.0001);
		assertEquals(0, ball.getPosY(), 0.0001);
	}
	
	
	@Test
	public void ballInitiatesPosToOrigonOnZeroBoardValues() {
		
		ball = new Ball(0, 140);
		
		assertEquals(0, ball.getPosX(), 0.0001);
		assertEquals(0, ball.getPosY(), 0.0001);
	}
	
	
	@Test
	public void ballIsWhereItIsInitiatedTo() {
		
		assertEquals(BOARD_WIDTH/2, ball.getPosX(), 0.0001);
		assertEquals(BOARD_HEIGHT/2, ball.getPosY(), 0.0001);
	}

	
	@Test
	public void ballCollidesWithBorderWorksProperly() {
		
		int radius = ball.getRadius();
		
		/** safely inside */
		assertFalse(ball.collidesWithBorder(ball.getPosX(), BOARD_WIDTH));
		assertFalse(ball.collidesWithBorder(ball.getPosY(), BOARD_HEIGHT));
		
		/** at the border */
		assertTrue(ball.collidesWithBorder(BOARD_WIDTH - radius/2, BOARD_WIDTH));
		assertTrue(ball.collidesWithBorder(BOARD_HEIGHT - radius/2, BOARD_HEIGHT));
		
		/** half in, half out */
		assertTrue(ball.collidesWithBorder(BOARD_WIDTH, BOARD_WIDTH));
		assertTrue(ball.collidesWithBorder(BOARD_HEIGHT, BOARD_HEIGHT));
		
		/** totally outside of X */
		assertTrue(ball.collidesWithBorder(BOARD_WIDTH*2, BOARD_WIDTH));
		assertTrue(ball.collidesWithBorder(BOARD_HEIGHT*2, BOARD_HEIGHT));
	}
	
	
	@Test
	public void ballMirrorsButDoesNotMoveWhenOutOf2dSpace() {
		
		ball.setPosX(50);
		ball.setPosY(50);
		ball.setVelX(15);
		ball.setVelY(15);
		ball.moveWithin2D(55, 55);
		
		assertEquals(-15, ball.getVelX(), 0.0001);
		assertEquals(-15, ball.getVelY(), 0.0001);
		assertEquals(50, ball.getPosX(), 0.0001);
		assertEquals(50, ball.getPosY(), 0.0001);
	}
	
	
	@Test
	/**
	 * Entity.move() test more than a Ball test.
	 */
	public void entityMovesTheCorrectAmountWithSimpleValues() {
		
		float velX = ball.getVelX();
		float velY = ball.getVelY();
		float posX = ball.getPosX();
		float posY = ball.getPosY();
		ball.move();
		
		assertEquals( posX + velX, ball.getPosX(), 0.0001);
		assertEquals( posY + velY, ball.getPosY(), 0.0001);
	}
	
	
	@Test
	public void entityMovesTheCorrectAmountWithSimpleNegativeValues() {
		
		ball.setVelX(-32);
		ball.setVelY(-5);
		float posX = ball.getPosX();
		float posY = ball.getPosY();
		ball.move();
		
		assertEquals( posX + -32, ball.getPosX(), 0.0001);
		assertEquals( posY + -5, ball.getPosY(), 0.0001);
	}
	
	
	@Test
	public void entityDoesNotMoveWithZeroVelocity() {
		
		ball.setVelX(0);
		ball.setVelY(0);
		float posX = ball.getPosX();
		float posY = ball.getPosY();
		ball.move();
		
		assertEquals(posX, ball.getPosX(), 0.0001);
		assertEquals(posY, ball.getPosY(), 0.0001);
	}
	
	
	@Test
	public void entityMoveAmountMovesGivenAmount() {

		ball.moveAmount(33, -50);
		
		assertEquals(BOARD_WIDTH/2 + 33, ball.getPosX(), 0.0001);
		assertEquals(BOARD_HEIGHT/2 - 50, ball.getPosY(), 0.0001);	
	}
	
	
}
