import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

public class WSTesting {

	  public static void main(String[] args) {
		    try {
		      SOAPConnectionFactory sfc = SOAPConnectionFactory.newInstance();
		      SOAPConnection connection = sfc.createConnection();

		      MessageFactory mf = MessageFactory.newInstance();
		      SOAPMessage sm = mf.createMessage();

		      SOAPHeader sh = sm.getSOAPHeader();
		      SOAPBody sb = sm.getSOAPBody();
		      sh.detachNode();
		      
		      //valid
		      //QName bodyName = new QName("http://catalogservice.cdstore.com/", "getCategoryList", "d");
		      
		      //invalid
		      QName bodyName = new QName("http://catalogservice.cdstore.com/", "getCategoryBlah", "d");
		      		      
		      SOAPBodyElement bodyElement = sb.addBodyElement(bodyName);
		      QName qn = new QName("aName");
		      SOAPElement quotation = bodyElement.addChildElement(qn);

		      quotation.addTextNode("TextMode");

		      System.out.println("Error Soap Request:");
		      sm.writeTo(System.out);
		      System.out.println();
		      
		      URL endpoint = new URL("http://localhost:8080/ProductCatalog/catalog");
		      SOAPMessage response = connection.call(sm, endpoint);
		      System.out.println();
		      System.out.println("Soap Response:");	      
		      response.writeTo(System.out);
		      System.out.println();
		      
		      System.out.println();
		      System.out.println("Expected Soap Response:");
		      System.out.println("<?xml version=\"1.0\" ?><S:Envelope xmlns:S=\"http://schemas.xmlsoap.org/soap/envelope/\"><S:Body><S:Fault xmlns:ns3=\"http://www.w3.org/2003/05/soap-envelope\"><faultcode>S:Client</faultcode><faultstring>Cannot find dispatch method for {http://catalogservice.cdstore.com/}getCategoryBlah</faultstring></S:Fault></S:Body></S:Envelope>");
		      
		      
		      //System.out.println(response.getContentDescription());
		    } catch (Exception ex) {
		      ex.printStackTrace();
		    }
		  }
}
