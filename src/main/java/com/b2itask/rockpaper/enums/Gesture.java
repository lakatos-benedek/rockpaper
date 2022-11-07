package com.b2itask.rockpaper.enums;

public enum Gesture {
    ROCK(0),
    PAPER(1),
    SCISSORS(2);
	
    private Integer gestureID;

    Gesture(Integer i) {
    	gestureID = i;
    }
}
