package com.mkyong.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.mkyong.ws.HelloWorld;
import com.mkyong.ws.TestContainer;
import com.mkyong.ws.TestObject;
import java.util.*;

public class HelloWorldClient{
	
	public static void main(String[] args) throws Exception {
	   
		URL url = new URL("http://localhost:8080/HelloWorld-20111020/hello?wsdl");
        QName qname = new QName("http://ws.mkyong.com/", "HelloWorldImplService");

        Service service = Service.create(url, qname);

        HelloWorld hello = service.getPort(HelloWorld.class);

        // ArrayList<TestObject> TO = hello.getHelloWorldAsString("I am ", "He is");
        TestObject[] Test = hello.getHelloWorldAsString("I am ", "He is");
        //for (int i = 1; i<TO.size(); i++)
        //System.out.println(TO.get(i));
        System.out.println(Test[1].data);
        
    }

}