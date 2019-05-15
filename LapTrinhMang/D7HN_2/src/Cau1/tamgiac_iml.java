/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Zero Ken
 */
public class tamgiac_iml extends UnicastRemoteObject implements Rmi_Interface{

    public tamgiac_iml() throws RemoteException{
    }

    
    
    @Override
    public String tamgiac(int a, int b, int c) throws RemoteException {
    String kq="";
    int x,y,z;
    x=a+b;
    y=b+c;
    z=c+a;
    if (x>c && y>a && z>b){
    kq = "Dây là 3 cạnh của tam giác";
    }else
        kq =" đay không phải là 3 cạnh của tam giác";
    return kq;
    }
    
}
