package it.ocramsoft.pattern;

import it.ocramsoft.response.BasicJSendResponse;
import it.ocramsoft.response.RequestStatus;

public interface IJSendResponseFactory<T> {
	
	public BasicJSendResponse<T> build(RequestStatus response, T t);

}
