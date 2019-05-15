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
public class giaithua_iml extends UnicastRemoteObject implements RMI_iml{

    public giaithua_iml() throws RemoteException{
    }

    
    
    @Override
    public int giaithua(int x) throws RemoteException {
        int y=1;
        if (x<0) y=-1;
        else if (x==0) y=1;
        else{
            for (int i=1;i<=x;i++){
                y*=i;
            }
        }
        return y;
    }
    
}
