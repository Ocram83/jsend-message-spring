package it.ocramsoft;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import it.ocramsoft.pattern.IJSendResponseFactory;
import it.ocramsoft.response.BasicJSendResponse;
import it.ocramsoft.response.RequestStatus;

public abstract class AbstractJSendMessageConverter<T> extends AbstractHttpMessageConverter<BasicJSendResponse<T>>{

	public static final Charset DEFAULT_CHARSET = Charset.forName("ISO-8859-1");
	
	protected final static String status_string_val = "status";
	protected final static String T_string_val = "data";


	IJSendResponseFactory<T> jSendResponseFactory;
		
	@Override
	protected boolean supports(Class<?> clazz)
	{
		if(clazz.equals(BasicJSendResponse.class))
			return true;
		
		return false;
	}
	
	public AbstractJSendMessageConverter(IJSendResponseFactory<T> responseFactory)
	{
		this.jSendResponseFactory = responseFactory;
	
		setSupportedMediaTypes(Arrays.asList(new MediaType("application","json")));
	}

	@Override
	protected BasicJSendResponse<T> readInternal(Class<? extends BasicJSendResponse<T>> clazz, HttpInputMessage inputMessage)
			throws IOException, HttpMessageNotReadableException
	{	
		
		JSONObject obj = null;
		try
		{
			Charset charset = getContentTypeCharset(inputMessage.getHeaders().getContentType());
			obj = new JSONObject(StreamUtils.copyToString(inputMessage.getBody(), charset));
			
		} catch (JSONException e)
		{
			throw new IOException(e);
			
		}
		
		try
		{
			String n = obj.getString(status_string_val);
			BasicJSendResponse<T> response = jSendResponseFactory.build(RequestStatus.getEnumFromString(n),readObject(obj) );
			return response;
			
		} catch (JSONException e)
		{
			throw new  HttpMessageNotReadableException(e.getMessage());
		}
		
	}

	@Override
	protected void writeInternal(BasicJSendResponse<T> t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException
	{
		throw new HttpMessageNotWritableException("Functionality not implemented");
		// TODO Auto-generated method stub
		
	}
	
	private Charset getContentTypeCharset(MediaType contentType) {
		if (contentType != null && contentType.getCharSet() != null) {
			return contentType.getCharSet();
		}
		else {
			return AbstractJSendMessageConverter.DEFAULT_CHARSET;
		}
	}

	
	protected abstract T readObject(JSONObject s) throws JSONException;


}
