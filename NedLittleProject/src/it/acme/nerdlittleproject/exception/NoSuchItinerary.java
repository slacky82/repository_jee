package it.acme.nerdlittleproject.exception;

public class NoSuchItinerary extends Exception{
	
	private static final long serialVersionUID = 1L;

	public NoSuchItinerary(String msg){
		super(msg);
	}

}