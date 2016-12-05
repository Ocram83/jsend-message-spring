package it.ocramsoft.pattern;

import it.ocramsoft.response.BasicJSendMessage;
import it.ocramsoft.response.RequestStatus;

public interface IJSendResponseFactory<T> {
	
	public BasicJSendMessage<T> build(RequestStatus response, T t);

}
