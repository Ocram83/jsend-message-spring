package it.ocramsoft.response;

/**
 * The Interface IJSendResponseBody.
 * Basic definition a response implementing the JSend paradigm
 * 
 * @see https://labs.omniti.com/labs/jsend
 *
 * @param <T> the generic type
 */
public interface IJSendResponseBody<T> {
	
	/**
	 * Sets the data that represent the Response.
	 *
	 * @param o the new data
	 */
	public void setData(T o);

}
