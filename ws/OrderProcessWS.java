/**
 * OrderProcessWS.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package ws;

public interface OrderProcessWS extends java.rmi.Remote {
    public java.lang.String createOrder(java.lang.String str) throws java.rmi.RemoteException;
    public java.lang.String getAccount(int number) throws java.rmi.RemoteException;
    public java.lang.String createAccount(java.lang.String str) throws java.rmi.RemoteException;
}
