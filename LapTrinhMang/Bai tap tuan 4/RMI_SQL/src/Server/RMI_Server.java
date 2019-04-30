/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero Ken
 */
public class RMI_Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            LocateRegistry.createRegistry(9999);
            RMI_SQL RS= new RMI_SQL();
            Naming.rebind("rmi://localhost:9999/sinhvien", RS);
            System.out.println("Server Running ...");
        } catch (RemoteException ex) {
            Logger.getLogger(RMI_Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(RMI_Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
