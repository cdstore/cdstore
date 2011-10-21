package com.cdstore.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map.Entry;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionController extends HttpServlet {

	private String propertyFile = "/navigation.properties";
	
	private Properties props = new Properties();
		
	public SessionController(){
		super();
		
		InputStream in = getClass().getResourceAsStream(propertyFile);
		
		if (in == null) {
			//File not found! (Manage the problem)
			System.out.println(propertyFile + "not found!");
		}	

		try {
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doRedirect(req, resp);
		
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doRedirect(req, resp);
		
	}

	
	private void doRedirect(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		String actionName = req.getParameter("actionName");
		
		String nextPage = props.getProperty(actionName);		
		
		String parameters = "?";
		
		for(Entry<String, String[]> params:req.getParameterMap().entrySet()) {
			String paramName = params.getKey();
			String paramValue = params.getValue()[0];
			
			if (!paramName.equals("actionName")) {
				parameters = parameters +paramName+"="+ paramValue +"&";
				
			}
		}
		
		parameters = parameters.substring(0, parameters.length()-1);
		
		resp.sendRedirect(nextPage+parameters);
	}	
	
}
