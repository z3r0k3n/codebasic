/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Zero Ken
 */
public interface B5NC_Interface extends Remote{
    public SanPham Laysanpham ()throws RemoteException;
    public String doangia (double gia, SanPham sp) throws RemoteException;
}
