package it.ocramsoft.converter;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import it.ocramsoft.converter.exception.GenericJSendResponseException;
import it.ocramsoft.pattern.IJSendResponseFactory;
import it.ocramsoft.response.BasicJSendMessage;
import it.ocramsoft.response.RequestStatus;

public abstract class AbstractJSendMessageConverter<T> extends AbstractHttpMessageConverter<BasicJSendMessage<T>>{

	public static final Charset DEFAULT_CHARSET = Charset.forName("ISO-8859-1");
	
	private final Charset defaultCharset;

	private final List<Charset> availableCharsets;
	
	protected final static String status_string_val = "status";
	protected final static String T_string_val = "data";
		
	@Override
	protected boolean supports(Class<?> clazz)
	{
		if(clazz.equals(BasicJSendMessage.class))
			return true;
		
		return false;
	}
	
	/**
	 * A default constructor that uses {@code "ISO-8859-1"} as the default charset.
	 * @see #StringHttpMessageConverter(Charset)
	 */
	public AbstractJSendMessageConverter() {
		this(DEFAULT_CHARSET);
		setSupportedMediaTypes(Arrays.asList(new MediaType("application","json")));

	}

	/**
	 * A constructor accepting a default charset to use if the requested content
	 * type does not specify one.
	 */
	public AbstractJSendMessageConverter(Charset defaultCharset) {
		
		setSupportedMediaTypes(Arrays.asList(new MediaType("application","json")));
		this.defaultCharset = defaultCharset;
		this.availableCharsets = new ArrayList<Charset>(Charset.availableCharsets().values());
	}


	@Override
	protected BasicJSendMessage<T> readInternal(Class<? extends BasicJSendMessage<T>> clazz, HttpInputMessage inputMessage)
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
			BasicJSendMessage<T> response = new BasicJSendMessage<T>(RequestStatus.getEnumFromString(n),readObject(obj) );
			return response;
			
		} catch (JSONException | GenericJSendResponseException e )
		{
			throw new  HttpMessageNotReadableException(e.getMessage(),e.getCause());
		}
		
	}

	@Override
	protected void writeInternal(BasicJSendMessage<T> t, HttpOutputMessage outputMessage)
			throws IOException, HttpMessageNotWritableException
	{
		outputMessage.getHeaders().setAcceptCharset(getAcceptedCharsets());
		
		JSONObject jsonObject = new JSONObject(t);
		
		Charset charset = getContentTypeCharset(outputMessage.getHeaders().getContentType());
		StreamUtils.copy(jsonObject.toString(), charset, outputMessage.getBody());
//		throw new HttpMessageNotWritableException("Functionality not implemented");
	}
	
	protected List<Charset> getAcceptedCharsets() {
		return this.availableCharsets;
	}
	
	private Charset getContentTypeCharset(MediaType contentType) {
		if (contentType != null && contentType.getCharSet() != null) {
			return contentType.getCharSet();
		}
		else {
			return AbstractJSendMessageConverter.DEFAULT_CHARSET;
		}
	}

	
	protected abstract T readObject(JSONObject s) throws JSONException,GenericJSendResponseException;


}
