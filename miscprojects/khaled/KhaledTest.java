/**
 * 
 */
package test;

import javax.xml.namespace.QName;
import org.apache.axis.client.*;
import ws.*;


/**
 * @author Khaled
 *
 */
public class KhaledTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
		String endpoint = "http://localhost:8080/DreamteamCDStore/services/Habal";
		Service service = new Service();
		Call call = (Call) service.createCall();
		call.setTargetEndpointAddress( new java.net.URL(endpoint) );
		call.setOperationName( new QName("http://ws", "faflk"));
//		String ret = (String) call.invoke( new Object[] {"Hello World"} );
//		System.out.println(ret);\
		HabalProxy HP = new HabalProxy(endpoint);
		String ret = HP.faflk("Zamalek");
		System.out.println(ret);
		}

		
		catch(Exception e)
		{
			System.err.println(e.toString());
		}
		
	}

}
