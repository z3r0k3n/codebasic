package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMI_Server_Demo extends Remote {
	public int sum(int a, int b) throws RemoteException;
	public int multi (int a,int b) throws RemoteException;
}