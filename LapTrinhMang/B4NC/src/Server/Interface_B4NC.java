/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Zero Ken
 */
public interface Interface_B4NC extends Remote{
    public String Anh_Viet (String Anh) throws RemoteException;
    public String Viet_Anh (String Viet) throws RemoteException;
    public String Dinh_Ngia (String Anh) throws RemoteException;
}
