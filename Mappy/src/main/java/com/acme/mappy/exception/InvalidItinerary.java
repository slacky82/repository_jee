package com.acme.mappy.exception;

public class InvalidItinerary extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidItinerary() {

	}

	public InvalidItinerary(String message) {
		super(message);
	}

}
