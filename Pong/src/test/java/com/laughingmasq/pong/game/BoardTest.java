package com.laughingmasq.pong.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import static com.laughingmasq.pong.TestVariables.*;

public class BoardTest {
	
	private Board board;
	private Board newBoard;
	
	private int absurdWidth = 24019824;
	private int absurdHeight = 998765;

	@Before
	public void setUp() throws Exception {
		
		board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
		newBoard = new Board(absurdWidth, absurdHeight);
	}

	
	@Test
	public void boardInitiatesGivenBoardWidth() {
		
		assertEquals(BOARD_WIDTH, board.getBoardWidth(), 0.0001);
		assertEquals(BOARD_HEIGHT, board.getBoardHeight(), 0.0001);
		assertEquals(absurdWidth, newBoard.getBoardWidth(), 0.0001);
		assertEquals(absurdHeight, newBoard.getBoardHeight(), 0.0001);
	}
	
	
	@Test
	public void boardHasThreeEntitiesWhenInitiated() {
		
		assertEquals(3, board.getEntities().size());
		assertEquals(3, newBoard.getEntities().size());
	}

}
