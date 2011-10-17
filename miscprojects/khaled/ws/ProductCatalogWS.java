/**
 * ProductCatalogWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public interface ProductCatalogWS extends java.rmi.Remote {
    public java.lang.String getCategories() throws java.rmi.RemoteException;
    public java.lang.String getCDsByCategory(int category) throws java.rmi.RemoteException;
}
