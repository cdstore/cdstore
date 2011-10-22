package com.cdstore.services.clients;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class ProductCatalogServiceClient {

	private ProductCatalog pCatalogIF;
	
	public ProductCatalogServiceClient() {

		URL url = null;
		
		try {
			url = new URL("http://localhost:8080/ProductCatalog/catalog?wsdl");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
        QName qname = new QName("http://catalogservice.cdstore.com/", "ProductCatalogImplService");

        Service service = Service.create(url, qname);

        pCatalogIF = service.getPort(ProductCatalog.class);
	}
	
	
	// CDStoreBean will call methods from service through this interface
	public ProductCatalog getServiceInterface(){
		return pCatalogIF;
	}
	
}
