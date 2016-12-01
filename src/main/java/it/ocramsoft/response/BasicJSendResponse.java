package it.ocramsoft.response;

import it.ocramsoft.response.RequestStatus;

/**
 * The Class BasicJSendResponse.
 * 
 * Extends this abstract class to obtain a response that follow the JSend paradigm
 * 
 * @see https://labs.omniti.com/labs/jsend
 *
 * @param <T> the generic type
 */
public class BasicJSendResponse<T> implements IJSendResponseBody<T> {
	
	/** The status. */
	RequestStatus status;
	
	/** The data that represent the response */
	protected T data;
	
	/**
	 * Instantiates a new Jsend response.
	 *
	 * @param o the o
	 * @param response the response
	 */
	public BasicJSendResponse(RequestStatus response,T o)
	{
		this.status = response;
		setData(o);
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public RequestStatus getStatus()
	{
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(RequestStatus status)
	{
		this.status = status;
	}

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	public T getData()
	{
		return data;
	}
	
	/* (non-Javadoc)
	 * @see it.ceiweb.decisionMakerApi.response.IJSendResponseBody#setData(java.lang.Object)
	 */
	public void setData(T data)
	{
		this.data = data;
	}
	
}
