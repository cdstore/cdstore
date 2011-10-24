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

		      System.out.println("\n Soap Request:\n");
		      sm.writeTo(System.out);
		      System.out.println();

		      URL endpoint = new URL("http://localhost:8080/ProductCatalog/catalog");
		      SOAPMessage response = connection.call(sm, endpoint);
		      response.writeTo(System.out);
		      //System.out.println(response.getContentDescription());
		    } catch (Exception ex) {
		      ex.printStackTrace();
		    }
		  }
}
