package com.cdstore.catalogservice;

import com.cdstore.entities.*;
import com.cdstore.dbagent.*;

import java.sql.SQLException;
import java.util.*;


import javax.jws.WebService;

//Service Implementation Bean

@WebService(endpointInterface = "com.cdstore.catalogservice.ProductCatalog")
public class ProductCatalogImpl implements ProductCatalog {
	
	private DBAgent DB;
	
	public ProductCatalogImpl()
	{
		DB = new DBAgent();
	}
	/**
	 * Get List of all categories from web service
	 */
	@Override
	public Category[] getCategoryList()
	{
		ArrayList<Category> input=new ArrayList<Category>();
		try{
		input = DB.getCategories();
	   
		}catch(Exception ex){
		
		}
		 Category[] output = new Category[input.size()];
		return input.toArray(output);
	}
	/**
	 * Get List of all CDs from Webservice
	 */
	@Override
    public CD[] getCDListAll()
    {
    	ArrayList<CD> input =new ArrayList<CD>();
    	try{
    	 input = DB.getCDList();
    	}catch(Exception ex){
    		
    	}
	    CD[] output = new CD[input.size()];
		return input.toArray(output);
    }
	/**
	 * Get List of CDs per Category from Webservice
	 */
	@Override
    public CD[] getCDList(int CategoryID)
    {
    	ArrayList<CD> input =new ArrayList<CD>();
    	try{
    	 input = DB.getCDList(CategoryID);
    	}catch(Exception ex){
    		
    	}
	    CD[] output = new CD[input.size()];
		return input.toArray(output);
    }
    /**
     * Get CD Information from Webservice
     */
    @Override
    public CD getCDInfo(int CdID) 
    {
    	CD input = new CD();
    	try {
			input =  DB.getCDInfo(CdID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return input;
    }
    
    @Override
    public void validateInput()
    {
    	
    }

}
