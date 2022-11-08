package com.b2itask.rockpaper.exceptions;

public class UnknownGestureException extends RuntimeException {
	public UnknownGestureException(String gesture) {
		super("Unknown gesture : " + gesture);
	}
}
