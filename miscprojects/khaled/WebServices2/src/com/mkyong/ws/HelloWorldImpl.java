package com.mkyong.ws;

import javax.jws.WebService;
import java.util.*;
//Service Implementation Bean

@WebService(endpointInterface = "com.mkyong.ws.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

	@Override
	public TestObject[] getHelloWorldAsString(String in, String in2) {
		TestObject one = new TestObject(in + "done and ", in2 + " done!");
		TestObject two = new TestObject(in + "done and ", in2 + " done!");
		TestObject three = new TestObject(in + "done and ", in2 + " done!");
		TestObject four = new TestObject(in + "done and ", in2 + " done!");
		ArrayList <String> TO = new ArrayList<String>();
		//String [] result = new String [4];
		TestObject [] Test = new TestObject[4];
		Test[1] = one;
		Test[2] = two;
		Test[3] = three;
		Test[4] = four;
		
 		TO.add(one.toString());
		TO.add(two.toString());
		TO.add(three.toString());
		TO.add(four.toString());
		/*result[1] = one.data;
		result[2] = two.data;
		result[3] = three.data;
		result[4] = four.data; */
	    TestContainer result = new TestContainer(TO);
		return Test ;
	}
}