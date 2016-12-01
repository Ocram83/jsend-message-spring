package it.ocramsoft.response;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpInputMessage;
import org.springframework.mock.http.MockHttpInputMessage;

import it.ocramsoft.response.impl.BooleanMessageConverter;

public class BooleanMessageConverterTest {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test1() throws IOException
	{
		BooleanMessageConverter bmc = new BooleanMessageConverter();
		
		HttpInputMessage him = new MockHttpInputMessage("{status:\"success\", data:true }".getBytes());

		Class clazz = BasicJSendResponse.class;
		
		BasicJSendResponse<Boolean> bjsr= bmc.read(clazz, him);
		
		Assert.assertEquals(bjsr.getData(), new Boolean(true));
		Assert.assertEquals(bjsr.getStatus(), RequestStatus.SUCCESS);
		
		bjsr.getData();

	}

}
