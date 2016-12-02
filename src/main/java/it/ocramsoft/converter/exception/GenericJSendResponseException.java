package it.ocramsoft.converter.exception;

public class GenericJSendResponseException  extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3003271013013277642L;

	public GenericJSendResponseException(String msg) {
		super(msg);
	}

	public GenericJSendResponseException(Exception e) {
		super(e);
	}

	public GenericJSendResponseException(String msg, Exception e) {
		super(msg, e);
	}
}