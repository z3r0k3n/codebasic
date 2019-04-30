package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculatoriml extends UnicastRemoteObject implements RMI_Server_Demo {
	protected Calculatoriml() throws RemoteException
	{
		
	}
	public int sum (int a,int b) throws RemoteException
	{
		return a+b;
	}
	public int multi (int a,int b) throws RemoteException
	{
		return a*b;
	}
}
