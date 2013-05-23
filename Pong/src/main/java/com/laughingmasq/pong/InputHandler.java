package com.laughingmasq.pong;

import org.lwjgl.LWJGLException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class InputHandler {
	
	public InputHandler() {
		//Mouse.setGrabbed(true);
	}
	
	
	public int getMouseX() {
		return Mouse.getX();
	}
	
	public int getMouseY() {
		return Mouse.getY();
	}
	
}