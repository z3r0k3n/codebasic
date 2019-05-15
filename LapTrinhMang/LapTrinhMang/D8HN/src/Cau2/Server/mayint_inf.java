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
public interface mayint_inf extends Remote{
    public double Cong (double a, double b)throws RemoteException;
    public double Tru (double a, double b)throws RemoteException;
    public double nhan (double a, double b)throws RemoteException;
    public double chia (double a, double b)throws RemoteException;
    public int uocchung (int a, int b)throws RemoteException;
}
