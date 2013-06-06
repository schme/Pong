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
	private int radius;
	
	@Before
	public void setUp() throws Exception {
		
		/* init ball to the middle of the screen */
		ball = new Ball(BOARD_WIDTH, BOARD_HEIGHT);
		
		ball.setVelX(5);
		ball.setVelY(2);
		
		radius = ball.getRadius();
	}
	
	
	@Test
	public void initiatesPosToOrigoOnNegativeBoardValues() {
		
		ball = new Ball(-1440, -900);
		
		assertEquals(0, ball.getPosX(), 0.0001);
		assertEquals(0, ball.getPosY(), 0.0001);
	}
	
	
	@Test
	public void initiatesPosToOrigonOnZeroBoardValues() {
		
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
	public void collidesWithBorderSafelyInside() {
		
		assertFalse(ball.collidesWithBorder(ball.getPosX(), BOARD_WIDTH));
		assertFalse(ball.collidesWithBorder(ball.getPosY(), BOARD_HEIGHT));
		
	}
	
	
	@Test
	public void collidesWithBorderAtTheBorder() {
		
		assertTrue(ball.collidesWithBorder(BOARD_WIDTH - radius/2, BOARD_WIDTH));
		assertTrue(ball.collidesWithBorder(BOARD_HEIGHT - radius/2, BOARD_HEIGHT));
	}
	
	
	@Test
	public void ccllidesWithBorderHalfInHalfOut() {
		
		assertTrue(ball.collidesWithBorder(BOARD_WIDTH, BOARD_WIDTH));
		assertTrue(ball.collidesWithBorder(BOARD_HEIGHT, BOARD_HEIGHT));
	}
	
	
	@Test
	public void collidesWithBorderOutside() {
		
		assertTrue(ball.collidesWithBorder(BOARD_WIDTH*2, BOARD_WIDTH));
		assertTrue(ball.collidesWithBorder(BOARD_HEIGHT*2, BOARD_HEIGHT));
	}
	
	
	@Test
	public void mirrorsButDoesNotMoveWhenOutOf2dSpace() {
		
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
	
}
