package com.cdstore.catalogservice;


import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import com.cdstore.entities.*;

@WebService
@SOAPBinding(style = Style.RPC)
public interface ProductCatalog {
	public Category[] getCategoryList();
	
    public CD[] getCDList(int CategoryID);
    
   public CD getCDInfo(int CdID);
    
    public void validateInput();
   
}
