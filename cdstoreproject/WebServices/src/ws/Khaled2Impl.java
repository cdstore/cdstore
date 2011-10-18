package ws;

public class Khaled2Impl implements Khaled{
	
	public String get(String input) throws java.rmi.RemoteException
	{
		return input + "Done!";
	}

}
