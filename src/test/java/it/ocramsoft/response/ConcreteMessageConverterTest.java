package it.ocramsoft.response;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.mock.http.MockHttpInputMessage;

import it.ocramsoft.converter.exception.UnsupportedBasicJSendResponseException;
import it.ocramsoft.converter.impl.ConcreteBasicJSendMessageConverter;

public class ConcreteMessageConverterTest {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testString_OK() throws IOException, UnsupportedBasicJSendResponseException
	{
		ConcreteBasicJSendMessageConverter<String> bmc = new ConcreteBasicJSendMessageConverter(String.class);
		
		HttpInputMessage him = new MockHttpInputMessage("{status:\"success\", data:\"HelloWorld\" }".getBytes());

		Class clazz = BasicJSendResponse.class;
		
		BasicJSendResponse<String> bjsr= bmc.read(clazz, him);
		
		Assert.assertEquals(bjsr.getData(), "HelloWorld");
		Assert.assertEquals(bjsr.getStatus(), RequestStatus.SUCCESS);
		
		bjsr.getData();

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test(expected=HttpMessageNotReadableException.class)
	public void testString_KO() throws IOException, UnsupportedBasicJSendResponseException
	{
		ConcreteBasicJSendMessageConverter<String> bmc = new ConcreteBasicJSendMessageConverter(String.class);
		
		HttpInputMessage him = new MockHttpInputMessage("{status:\"success\", data:12 }".getBytes());

		Class clazz = BasicJSendResponse.class;
		
		BasicJSendResponse<String> bjsr= bmc.read(clazz, him);
		
		Assert.assertEquals(bjsr.getData(), "HelloWorld");
		Assert.assertEquals(bjsr.getStatus(), RequestStatus.SUCCESS);
		
		bjsr.getData();

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testBoolean_OK() throws IOException, UnsupportedBasicJSendResponseException
	{
		ConcreteBasicJSendMessageConverter<String> bmc = new ConcreteBasicJSendMessageConverter(Boolean.class);
		
		HttpInputMessage him = new MockHttpInputMessage("{status:\"success\", data:true }".getBytes());

		Class clazz = BasicJSendResponse.class;
		
		BasicJSendResponse<Boolean> bjsr= bmc.read(clazz, him);
		
		Assert.assertEquals(bjsr.getData(), new Boolean(true));
		Assert.assertEquals(bjsr.getStatus(), RequestStatus.SUCCESS);
		
		bjsr.getData();

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test(expected=HttpMessageNotReadableException.class)
	public void testBoolean_KO() throws IOException, UnsupportedBasicJSendResponseException
	{
		ConcreteBasicJSendMessageConverter<String> bmc = new ConcreteBasicJSendMessageConverter(Boolean.class);
		
		HttpInputMessage him = new MockHttpInputMessage("{status:\"success\", data:1234 }".getBytes());

		Class clazz = BasicJSendResponse.class;
		
		BasicJSendResponse<Boolean> bjsr= bmc.read(clazz, him);
		
		Assert.assertEquals(bjsr.getData(), new Boolean(true));
		Assert.assertEquals(bjsr.getStatus(), RequestStatus.SUCCESS);
		
		bjsr.getData();

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testInteger_OK() throws IOException, UnsupportedBasicJSendResponseException
	{
		ConcreteBasicJSendMessageConverter<String> bmc = new ConcreteBasicJSendMessageConverter(Integer.class);
		
		HttpInputMessage him = new MockHttpInputMessage("{status:\"success\", data:1234 }".getBytes());

		Class clazz = BasicJSendResponse.class;
		
		BasicJSendResponse<Integer> bjsr= bmc.read(clazz, him);
		
		Assert.assertEquals(bjsr.getData(), new Integer(1234));
		Assert.assertEquals(bjsr.getStatus(), RequestStatus.SUCCESS);
		
		bjsr.getData();

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testIntegerNegativeNumber_OK() throws IOException, UnsupportedBasicJSendResponseException
	{
		ConcreteBasicJSendMessageConverter<String> bmc = new ConcreteBasicJSendMessageConverter(Integer.class);
		
		HttpInputMessage him = new MockHttpInputMessage("{status:\"success\", data:-1234 }".getBytes());

		Class clazz = BasicJSendResponse.class;
		
		BasicJSendResponse<Integer> bjsr= bmc.read(clazz, him);
		
		Assert.assertEquals(bjsr.getData(), new Integer(-1234));
		Assert.assertEquals(bjsr.getStatus(), RequestStatus.SUCCESS);
		
		bjsr.getData();

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test(expected=HttpMessageNotReadableException.class)
	public void testInteger_KO() throws IOException, UnsupportedBasicJSendResponseException
	{
		ConcreteBasicJSendMessageConverter<String> bmc = new ConcreteBasicJSendMessageConverter(Integer.class);
		
		HttpInputMessage him = new MockHttpInputMessage("{status:\"success\", data:true}".getBytes());

		Class clazz = BasicJSendResponse.class;
		
		BasicJSendResponse<Integer> bjsr= bmc.read(clazz, him);
		
		Assert.assertEquals(bjsr.getData(),new Integer(1234));
		Assert.assertEquals(bjsr.getStatus(), RequestStatus.SUCCESS);
		
		bjsr.getData();

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testLong_OK() throws IOException, UnsupportedBasicJSendResponseException
	{
		ConcreteBasicJSendMessageConverter<String> bmc = new ConcreteBasicJSendMessageConverter(Long.class);
		
		HttpInputMessage him = new MockHttpInputMessage("{status:\"success\", data:1234 }".getBytes());

		Class clazz = BasicJSendResponse.class;
		
		BasicJSendResponse<Long> bjsr= bmc.read(clazz, him);
		
		Assert.assertEquals(bjsr.getData(), new Long(1234));
		Assert.assertEquals(bjsr.getStatus(), RequestStatus.SUCCESS);
		
		bjsr.getData();

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testLongNegativeNumber_OK() throws IOException, UnsupportedBasicJSendResponseException
	{
		ConcreteBasicJSendMessageConverter<String> bmc = new ConcreteBasicJSendMessageConverter(Long.class);
		
		HttpInputMessage him = new MockHttpInputMessage("{status:\"success\", data:-1234 }".getBytes());

		Class clazz = BasicJSendResponse.class;
		
		BasicJSendResponse<Long> bjsr= bmc.read(clazz, him);
		
		Assert.assertEquals(bjsr.getData(), new Long(-1234));
		Assert.assertEquals(bjsr.getStatus(), RequestStatus.SUCCESS);
		
		bjsr.getData();

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test(expected=HttpMessageNotReadableException.class)
	public void testLong_KO() throws IOException, UnsupportedBasicJSendResponseException
	{
		ConcreteBasicJSendMessageConverter<String> bmc = new ConcreteBasicJSendMessageConverter(Long.class);
		
		HttpInputMessage him = new MockHttpInputMessage("{status:\"success\", data:\"Hello world!!\" }".getBytes());

		Class clazz = BasicJSendResponse.class;
		
		BasicJSendResponse<Long> bjsr= bmc.read(clazz, him);
		
		Assert.assertEquals(bjsr.getData(), new Long(1234));
		Assert.assertEquals(bjsr.getStatus(), RequestStatus.SUCCESS);
		
		bjsr.getData();

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testDouble_OK() throws IOException, UnsupportedBasicJSendResponseException
	{
		ConcreteBasicJSendMessageConverter<String> bmc = new ConcreteBasicJSendMessageConverter(Double.class);
		
		HttpInputMessage him = new MockHttpInputMessage("{status:\"success\", data:1234.1234 }".getBytes());

		Class clazz = BasicJSendResponse.class;
		
		BasicJSendResponse<Double> bjsr= bmc.read(clazz, him);
		
		Assert.assertEquals(bjsr.getData(), new Double(1234.1234));
		Assert.assertEquals(bjsr.getStatus(), RequestStatus.SUCCESS);
		
		bjsr.getData();

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void testDoubleNegativeNumber_OK() throws IOException, UnsupportedBasicJSendResponseException
	{
		ConcreteBasicJSendMessageConverter<String> bmc = new ConcreteBasicJSendMessageConverter(Double.class);
		
		HttpInputMessage him = new MockHttpInputMessage("{status:\"success\", data:-1234.1234 }".getBytes());

		Class clazz = BasicJSendResponse.class;
		
		BasicJSendResponse<Double> bjsr= bmc.read(clazz, him);
		
		Assert.assertEquals(bjsr.getData(), new Double(-1234.1234));
		Assert.assertEquals(bjsr.getStatus(), RequestStatus.SUCCESS);
		
		bjsr.getData();

	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test(expected=HttpMessageNotReadableException.class)
	public void testDouble_KO() throws IOException, UnsupportedBasicJSendResponseException
	{
		ConcreteBasicJSendMessageConverter<String> bmc = new ConcreteBasicJSendMessageConverter(Double.class);
		
		HttpInputMessage him = new MockHttpInputMessage("{status:\"success\", data:\"Hello world!!\" }".getBytes());

		Class clazz = BasicJSendResponse.class;
		
		BasicJSendResponse<Double> bjsr= bmc.read(clazz, him);
		
		Assert.assertEquals(bjsr.getData(), new Double(1234.1234));
		Assert.assertEquals(bjsr.getStatus(), RequestStatus.SUCCESS);
		
		bjsr.getData();

	}
}
