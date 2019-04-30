package RMI_Client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import RMI.Calculatoriml;
import RMI.RMI_Server_Demo;

public class CLient_demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			RMI_Server_Demo cal = (RMI_Server_Demo)Naming.lookup("rmi://localhost:6789/calRemote");
			int sum =cal.sum(5, 6);
			System.out.println("Ket qua: "+ sum);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
