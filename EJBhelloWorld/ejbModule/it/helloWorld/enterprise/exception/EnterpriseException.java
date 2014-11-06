package it.helloWorld.enterprise.exception;

public class EnterpriseException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EnterpriseException(String message){
		super(message);	
		}
	
	public EnterpriseException(Exception exception){
		super(exception);
		}

}
