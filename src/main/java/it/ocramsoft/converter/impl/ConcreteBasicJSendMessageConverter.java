package it.ocramsoft.converter.impl;

import java.lang.reflect.InvocationTargetException;

import org.json.JSONException;
import org.json.JSONObject;

import it.ocramsoft.converter.AbstractJSendMessageConverter;
import it.ocramsoft.converter.exception.GenericJSendResponseException;
import it.ocramsoft.converter.exception.UnsupportedBasicJSendResponseException;

public class ConcreteBasicJSendMessageConverter<T> extends AbstractJSendMessageConverter<T> {

	private Class<T> clazz;

	public ConcreteBasicJSendMessageConverter(Class<T> clazz) throws UnsupportedBasicJSendResponseException {
		if (!clazz.equals(String.class) && 
				!clazz.equals(Boolean.class) && 
				!clazz.equals(Double.class) &&
				!clazz.equals(Long.class) &&
				!clazz.equals(Integer.class))
			throw new UnsupportedBasicJSendResponseException("Class " + clazz
					+ " is not supported by ConcreteBasicJSendMessageConverter. "
					+ "Please provide a specific implementation for this class.");
		
		this.clazz = clazz;
	}

	@Override
	protected T readObject(JSONObject s) throws JSONException,GenericJSendResponseException {
		
	
			T t = null;
			
			try {
				
				if (clazz.equals(String.class))
				{
					
					t = clazz.getDeclaredConstructor(String.class).newInstance(s.getString(T_string_val));
					
				}
				else if (clazz.equals(Boolean.class))
				{
					t = clazz.getDeclaredConstructor(Boolean.TYPE).newInstance(s.getBoolean(T_string_val));
				}
				else if(clazz.equals(Double.class))
				{
					t = clazz.getDeclaredConstructor(Double.TYPE).newInstance(s.getDouble(T_string_val));

				}
				else if(clazz.equals(Long.class))
				{
					t = clazz.getDeclaredConstructor(Long.TYPE).newInstance(s.getLong(T_string_val));

				}
				else if(clazz.equals(Integer.class))
				{
					t = clazz.getDeclaredConstructor(Integer.TYPE).newInstance(s.getInt(T_string_val));

				}
						
		
			} catch (InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				throw new GenericJSendResponseException(e);
			}
			
		return t;
	}

}
