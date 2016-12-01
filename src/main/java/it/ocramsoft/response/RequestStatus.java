package it.ocramsoft.response;

public enum RequestStatus
{
	SUCCESS("success"),
	ERROR("error");
	
	String value;
	
	private RequestStatus(String s)
	{
		value = s;
	}
	
	public static RequestStatus getEnumFromString(String s)
	{
		switch (s.toUpperCase()) {
			case "SUCCESS":
				return SUCCESS;
			case "ERROR":
				return ERROR;
			default:
				return null;
		}
	}
	
	@Override
	public String toString()
	{
		return value;
	}
}
