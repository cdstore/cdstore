package com.mkyong.client;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.mkyong.ws.HelloWorld;
import com.mkyong.ws.TestObject;

public class HelloWorldClient{
	
	public static void main(String[] args) throws Exception {
	   
		URL url = new URL("http://localhost:8080/HelloWorld-20111017/hello?wsdl");
        QName qname = new QName("http://ws.mkyong.com/", "HelloWorldImplService");

        Service service = Service.create(url, qname);

        HelloWorld hello = service.getPort(HelloWorld.class);

        TestObject TO = hello.getHelloWorldAsString("I am ");
        System.out.println(TO.data);
        
    }

}