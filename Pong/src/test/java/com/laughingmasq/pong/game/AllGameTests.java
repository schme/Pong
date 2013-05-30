package com.laughingmasq.pong.game;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BallTest.class, BoardTest.class, PadTest.class })
public class AllGameTests {}