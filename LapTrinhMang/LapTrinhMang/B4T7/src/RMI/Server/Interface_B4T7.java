/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.Server;

import Java_SQL.Sach;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Zero Ken
 */
public interface Interface_B4T7 extends Remote{
    public ArrayList<Sach> Xemdanhsach () throws RemoteException;
    public int Muonsach (String ID) throws RemoteException;
    public int Trasach (String ID) throws RemoteException;
}
