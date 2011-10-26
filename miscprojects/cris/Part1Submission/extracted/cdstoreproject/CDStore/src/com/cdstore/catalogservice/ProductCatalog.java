package com.cdstore.catalogservice;


import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import com.cdstore.entities.*;
/**
 * Soap Ineterface Class
 * @author Chris
 *
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface ProductCatalog {
	public Category[] getCategoryList();
	
    public CD[] getCDList(int CategoryID);
    
    public CD[] getCDListAll();
    public CD getCDInfo(int CdID);
    
    public void validateInput();
   
}