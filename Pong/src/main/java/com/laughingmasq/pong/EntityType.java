package com.laughingmasq.pong;

/**
 * Enum for all the possible entities for easier recognision. Existing powerups
 * and/or powerup types (those that affect the board separately etc.) should be
 * held in here. A common way for each part of the program to know what kind of
 * entity they are talking about.
 * @author schme
 *
 */
public enum EntityType {
	LEFTPAD, RIGHTPAD, BALL;
}
