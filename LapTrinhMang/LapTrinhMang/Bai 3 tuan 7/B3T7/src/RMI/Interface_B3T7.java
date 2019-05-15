/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Zero Ken
 */
public interface Interface_B3T7 extends Remote{
    public Older Dangnhap(Older odin) throws RemoteException;
    public String chat(String send) throws RemoteException;
}
