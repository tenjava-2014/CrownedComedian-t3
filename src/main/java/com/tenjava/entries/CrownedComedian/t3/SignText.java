package com.tenjava.entries.CrownedComedian.t3;

public enum SignText {
	/*
	 * Library of signtext
	 */
	Blank(""),
	HI ("hello"),
	ISEEYOU ("I see you"),
	TURNAROUND("turn around"),
	IMCOMING("I'm coming"),
	GUESSWHO("guess who..."),
	CLOSER("closer..."),
	DOWN("down...");
	
	private final String text;
	
	SignText(String textToSign) {
		this.text = textToSign;
	}
	
	public String getText() {
		return text;
	}
}
