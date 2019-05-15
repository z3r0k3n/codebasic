/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2.Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Zero Ken
 */
public interface RMI_interface extends Remote{
    public String VT_DD (String VT) throws RemoteException;
    public String DD_VT (String DD) throws RemoteException;
}
