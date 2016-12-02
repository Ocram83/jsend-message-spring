package it.ocramsoft.converter.exception;

public class UnsupportedBasicJSendResponseException  extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3003271013013277642L;

	public UnsupportedBasicJSendResponseException(String msg) {
		super(msg);
	}

	public UnsupportedBasicJSendResponseException(Exception e) {
		super(e);
	}

	public UnsupportedBasicJSendResponseException(String msg, Exception e) {
		super(msg, e);
	}
}