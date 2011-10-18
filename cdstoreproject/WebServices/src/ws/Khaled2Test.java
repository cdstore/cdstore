package ws;
import javax.xml.rpc.*;
import javax.xml.namespace.*;
public class Khaled2Test {

	/**
	 * @param args
	 * @throws ServiceException 
	 */
	public static void main(String[] args) throws ServiceException {
		// TODO Auto-generated method stub
		
		Khaled2ServiceLocator K = new Khaled2ServiceLocator();
		ServiceFactory factory = ServiceFactory.newInstance();
		QName serviceName = K.getServiceName();
		QName portName = new QName( "http://ws/",K.getKhaled2PortWSDDServiceName());
		

	}

}
