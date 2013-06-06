package com.laughingmasq.pong.game;


import static com.laughingmasq.pong.TestVariables.*;
import static org.junit.Assert.*;

import com.laughingmasq.pong.EntityType;

import org.junit.Before;
import org.junit.Test;

/**
 * Test Pad class.
 * @author schme
 *
 */
public class PadTest {
	
	private Pad leftPad = null;
	private Pad rightPad = null;

	@Before
	public void setUp() throws Exception {
		
		leftPad = new Pad(EntityType.LEFTPAD, BOARD_WIDTH, BOARD_HEIGHT);
		rightPad = new Pad(EntityType.RIGHTPAD, BOARD_WIDTH, BOARD_HEIGHT);
	}


	@Test
	public void testLeftPadCorrectCoordinatesOnConstruct() {	
		
		Pad lPad = new Pad(EntityType.LEFTPAD, BOARD_WIDTH, BOARD_HEIGHT);
		
		assertEquals(Pad.PADDING, lPad.getPosX(), 0.0001);
		assertEquals(BOARD_HEIGHT/2 + Pad.HEIGHT/2, lPad.getPosY(), 0.0001);
	}
	
	
	@Test
	public void testLeftPadCorrectAbsurdBoardSizeCoordinatesOnConstruct() {
		
		final float newBoardWidth = 1234567;
		final float newBoardHeight = 9877;
		Pad lPad = new Pad(EntityType.LEFTPAD, newBoardWidth, newBoardHeight);
		
		assertEquals(Pad.PADDING, lPad.getPosX(), 0.0001);
		assertEquals(newBoardHeight/2 + Pad.HEIGHT/2, lPad.getPosY(), 0.0001);
	}
	
	
	@Test
	public void testRightPadCorrectCoordinatesOnConstruc() {
		
		Pad rPad = new Pad(EntityType.RIGHTPAD, BOARD_WIDTH, BOARD_HEIGHT);
		
		assertEquals(BOARD_WIDTH - Pad.PADDING - Pad.WIDTH, rPad.getPosX(), 0.0001);
		assertEquals(BOARD_HEIGHT/2 + Pad.HEIGHT/2, rPad.getPosY(), 0.0001);
	}

	
	@Test
	public void testRightPadCorrectAbsurdBoardSizeCoordinatesOnConstruct() {
		
		final float newBoardWidth = 9276;
		final float newBoardHeight = 1892724;
		Pad rPad = new Pad(EntityType.RIGHTPAD, newBoardWidth, newBoardHeight);
		
		assertEquals(newBoardWidth - Pad.PADDING - Pad.WIDTH, rPad.getPosX(), 0.0001);
		assertEquals(newBoardHeight/2 + Pad.HEIGHT/2, rPad.getPosY(), 0.0001);
	}
	
	
	@Test
	public void testMovingUpSetsVelocityCorrectly() {
		
		leftPad.movingUp();
		rightPad.movingUp();
		
		assertEquals(Pad.MOVE_VELOCITY, leftPad.getVelY(), 0.0001);
		assertEquals(Pad.MOVE_VELOCITY, rightPad.getVelY(), 0.0001);
	}
	
	
	@Test
	public void testMovingDownSetsVelocityCorrectly() {
		
		leftPad.movingDown();
		rightPad.movingDown();
		
		assertEquals(-Pad.MOVE_VELOCITY, leftPad.getVelY(), 0.0001);
		assertEquals(-Pad.MOVE_VELOCITY, rightPad.getVelY(), 0.0001);
	}
	
	
	@Test
	public void testStopRemovesVelocityCorrectly() {
		
		leftPad.setVelY(Pad.MOVE_VELOCITY + 5000);
		leftPad.stop();
		rightPad.setVelY(-537822);
		rightPad.stop();
		
		assertEquals(0, leftPad.getVelY(), 0.0001);
		assertEquals(0, rightPad.getVelY(), 0.0001);
	}
}
