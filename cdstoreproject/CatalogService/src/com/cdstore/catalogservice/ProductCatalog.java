package com.cdstore.catalogservice;

import com.cdstore.entities.*;


public interface ProductCatalog {
	public Category[] getCategoryList();
	
    public CD[] getCDList(int CategoryID);
    
    public CD getCDInfo(int CdID);
    
    public void validateInput();
   
}
