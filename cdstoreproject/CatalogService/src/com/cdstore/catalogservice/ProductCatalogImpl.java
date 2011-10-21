package com.cdstore.catalogservice;

import com.cdstore.entities.*;
import com.cdstore.dbagent.*;
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
	
	@Override
    public CD[] getCDList(int CategoryID)
    {
    	ArrayList<CD> input =new ArrayList<CD>();
    	try{
    	 input = DB.getCDList();
    	}catch(Exception ex){
    		
    	}
	    CD[] output = new CD[input.size()];
		return input.toArray(output);
    }
    
//    public CD getCDInfo(int CdID) 
//    {
//    	return DB.getCDInfo(CdID);
//    }
    @Override
    public void validateInput()
    {
    	
    }

}
