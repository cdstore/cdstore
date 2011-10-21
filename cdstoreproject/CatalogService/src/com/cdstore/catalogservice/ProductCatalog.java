package com.cdstore.catalogservice;

import entity.Category;
import java.util.*;
import entity.Cds;

public interface ProductCatalog {
	public ArrayList<Category> getCategoryList();
	
    public ArrayList<Cds> getCDList(int CategoryID);
    
    public Cds getCDInfo(int CdID);
    
    public void validateInput();
   
}
