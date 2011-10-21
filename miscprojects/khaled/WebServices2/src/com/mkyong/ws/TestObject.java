package com.mkyong.ws;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlType(name = "TestObject", propOrder = {
		"data",
		"name"
})

public class TestObject {

	public String data;
	public String name;
	public TestObject(String input, String input2)
	{
		data = input;
		name = input2;
	}
	
	public TestObject()
	{
		
	}
}
