/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI.Server;

import Java_SQL.Hoadon;
import Java_SQL.SanPham;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Zero Ken
 */
public interface B3NC_Interface extends Remote{
    public ArrayList<SanPham> listSP (String ID) throws RemoteException;
    public ArrayList<Hoadon> Taohoadon (ArrayList<Hoadon> hoadontruoc) throws RemoteException;
}
