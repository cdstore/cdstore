package com.cdstore.catalogservice;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
/**
 * Product Catalog Webservice Interface Class. All Methods will call the webservice through this class
 * @author Chris
 *
 */
public class ProductCatalogServiceClient {

	private ProductCatalog pCatalogIF;
	
	public ProductCatalogServiceClient() {
		System.setProperty("javax.net.ssl.trustStore", System.getenv("TOMCAT_HOME")+"/conf/keystore.jks");
		System.setProperty("javax.net.ssl.trustStorePassword", "asdasd");
		URL url = null;
		
		try {
			url = new URL("https://localhost:8443/ProductCatalog/catalog?wsdl");
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
