package it.ocramsoft.response.impl;

import org.json.JSONException;
import org.json.JSONObject;

import it.ocramsoft.AbstractJSendMessageConverter;


public class BooleanMessageConverter extends AbstractJSendMessageConverter<Boolean> {

	@Override
	protected Boolean readObject(JSONObject s) throws JSONException
	{
		return new Boolean(s.getBoolean(T_string_val));
	}

}
