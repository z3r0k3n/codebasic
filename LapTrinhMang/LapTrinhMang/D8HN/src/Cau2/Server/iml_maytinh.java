/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2.Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Zero Ken
 */
public class iml_maytinh extends UnicastRemoteObject implements mayint_inf{

    public iml_maytinh() throws RemoteException{
    }
    

    @Override
    public double Cong(double a, double b) throws RemoteException {
        return a+b;
    }

    @Override
    public double Tru(double a, double b) throws RemoteException {
        return a-b;
    }

    @Override
    public double nhan(double a, double b) throws RemoteException {
        return a*b;
    }

    @Override
    public double chia(double a, double b) throws RemoteException {
        return a/b;
    }

    @Override
    public int uocchung(int a, int b) throws RemoteException {
        int i=1,x,y,z=0;
        while (i<=a && i<=b) {
            x=a%i;
            y=b%i;
            if (x==0 && y==0) z = i;
            i++;
        }
        return z;
    }
    
}
