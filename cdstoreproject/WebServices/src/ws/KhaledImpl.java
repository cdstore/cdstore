package ws;

public class KhaledImpl implements Khaled{
	
	public String get(String input) throws java.rmi.RemoteException
	{
		return input + "Done!";
	}

}
