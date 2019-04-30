/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_sql.Java_SQl;
import java_sql.Older;



/**
 *
 * @author Zero Ken
 */
public class ServerCtr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ServerSocket Listener=null;
        Socket serverSocket=null;
        ObjectOutputStream Output=null;
        ObjectInputStream Input=null;
        Older older=null;
        java_sql.Java_SQl js=new Java_SQl();
        //=========================================================================================================
  
        try {
            System.out.println("Server running....!!!");
            Listener=new ServerSocket(9999);
            serverSocket = Listener.accept();
            Output=new ObjectOutputStream(serverSocket.getOutputStream());
            Input=new ObjectInputStream(serverSocket.getInputStream());
            System.out.println("Acept :>");
            
            //============================================
            do{
            older=(Older) Input.readObject();
            switch(older.getChoice())
            {
                
            //Xuất danh sách sinh viên
                case Older.Xem_danh_sach_sinh_vien:
                    older.setListSv(js.Xemdanhsach());
                    Output.writeObject(older);
                    Output.flush();
                    break;
            //Thêm sinh viên
                case Older.Them_mot_sinh_vien:
                    older.setRow(js.Themsinhvien(older.getSv()));
                    Output.writeObject(older);
                    Output.flush();
                    break;
            //Xoa sinh vien
                case Older.Xoa_mot_sinh_vien:
                    older.setRow(js.xoasinhvien(older.getThongbao()));
                    Output.writeObject(older);
                    Output.flush();
                    break;
            //Cập nhập sinh viên
                case Older.Cap_nhap_mot_sinh_vien:
                    older.setRow(js.Capnhapsinhvien(older.getSv()));
                    Output.writeObject(older);
                    break;
            //Tìm sinh viên
                case Older.Tim_kiem_mot_sinh_vien:
                    older.setListSv(js.Timsinhvien(older.getThongbao()));
                    Output.writeObject(older);
                    break;
                case Older.Ngat_ket_noi:
                    System.out.println("Ngắt kết nối");
                    break;
            }
            }while(older.getChoice()!=Older.Ngat_ket_noi);
        } catch (IOException ex) {
            Logger.getLogger(ServerCtr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerCtr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
