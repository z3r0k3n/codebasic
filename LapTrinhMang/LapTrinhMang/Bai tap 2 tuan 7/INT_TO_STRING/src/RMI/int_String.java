/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Zero Ken
 */
public class int_String extends UnicastRemoteObject implements Interface{

    public int_String() throws RemoteException{
    }
    
    
    @Override
    public String INT_String(String no) throws RemoteException {
        String kq="";
        switch (no) {
            case "1":
                kq="một";
                break;
            case "2":
                kq="Hai";
                break;
            case "3":
                kq="Ba";
                break;
            case "4":
                kq="Bốn";
                break;
            case "5":
                kq="Năm";
                break;
            case "0":
                kq="Không";
                break;
            default:
                kq= "Số bạn vừa chọn ko phải là số nguyên từ 0 đến 5";
                break;
        }
        return kq;
    }
    
}
