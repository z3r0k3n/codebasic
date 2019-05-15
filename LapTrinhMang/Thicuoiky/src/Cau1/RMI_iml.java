/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau1;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Zero Ken
 */
public interface RMI_iml extends Remote{
    public int giaithua (int x) throws RemoteException;
}
