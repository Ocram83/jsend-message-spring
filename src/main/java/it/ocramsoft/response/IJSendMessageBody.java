package it.ocramsoft.response;

/**
 * The Interface IJSendResponseBody.
 * Basic definition a response implementing the JSend paradigm
 * 
 * @see https://labs.omniti.com/labs/jsend
 *
 * @param <T> the generic type
 */
public interface IJSendMessageBody<T> {
	
	/**
	 * Sets the data that represent the Response.
	 *
	 * @param o the new data
	 */
	public void setData(T o);
	
	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public T getData();
	
	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public RequestStatus getStatus();

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(RequestStatus status);
	

}
