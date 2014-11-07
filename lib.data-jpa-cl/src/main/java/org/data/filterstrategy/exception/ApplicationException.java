/**
 * 
 */
package org.data.filterstrategy.exception;

/**
 * @author Gerina Fabrizio fabrizio.gerina@capgemini.com
 *
 */
public class ApplicationException extends Exception {
	
private static final long serialVersionUID = 1L;
	
	public ApplicationException(String message) {
		super(message);
	}
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}
	public ApplicationException(Throwable cause) {
		super(cause);
	}

}
