/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java_sql.SinhVien;

/**
 *
 * @author Zero Ken
 */
public interface Interface_RMI extends Remote{
    public ArrayList<SinhVien> Xemsinhvien()throws RemoteException;
    public int Themsinhvien(SinhVien sv) throws RemoteException;
    public int XoaSinhvien(String ID) throws RemoteException;
    public int CapnhapSinhvien(SinhVien sv) throws RemoteException;
    public ArrayList<SinhVien> Timkiemsinhvien (String ID) throws RemoteException;
}
