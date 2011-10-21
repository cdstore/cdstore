package com.cdstore.catalogservice;

import com.cdstore.entity.*;
import com.cdstore.dbagent.*;
import java.util.*;
import java.sql.*;

public class ProductCatalogImpl {
	
	private DBAgent DB;
	
	public ProductCatalogImpl()
	{
		DB = new DBAgent();
	}
	
	public ArrayList <Category> getCategoryList() throws SQLException
	{
		return DB.getCategories();
	}
	
    public ArrayList<Cds> getCDList(int CategoryID) throws SQLException
    {
    	return DB.getCDList(CategoryID);
    }
    
    public Cds getCDInfo(int CdID) throws SQLException
    {
    	return DB.getCDInfo(CdID);
    }
    
    public void validateInput()
    {
    	
    }

}
