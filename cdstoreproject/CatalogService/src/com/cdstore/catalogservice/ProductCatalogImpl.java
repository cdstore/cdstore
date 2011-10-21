package com.cdstore.catalogservice;

import com.cdstore.entities.*;
import com.cdstore.dbagent.*;
import java.util.*;
import java.sql.*;

public class ProductCatalogImpl {
	
	private DBAgent DB;
	
	public ProductCatalogImpl()
	{
		DB = new DBAgent();
	}
	
	public Category[] getCategoryList() throws SQLException
	{
		ArrayList<Category> input = DB.getCategories();
	    Category[] output = new Category[input.size()];
		return input.toArray(output);
	}
	
    public CD[] getCDList(int CategoryID) throws SQLException
    {
    	ArrayList<CD> input = DB.getCDList();
	    CD[] output = new CD[input.size()];
		return input.toArray(output);
    }
    
    public CD getCDInfo(int CdID) throws SQLException
    {
    	return DB.getCDInfo(CdID);
    }
    
    public void validateInput()
    {
    	
    }

}
