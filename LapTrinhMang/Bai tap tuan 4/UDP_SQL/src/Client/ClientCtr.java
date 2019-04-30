/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_sql.Older;
import java_sql.SinhVien;

/**
 *
 * @author Zero Ken
 */
public class ClientCtr {
    
    /*try {
            //test
            older=new Older();
            address=InetAddress.getByName("localhost");
            //gửi yêu cầu xem sinh viên
            sendBuff= new byte[1024];
            arrout= new ByteArrayOutputStream();
            older.setChoice(Older.Xem_danh_sach_sinh_vien);
            output= new ObjectOutputStream(arrout);
            output.writeObject(older);
            sendBuff= arrout.toByteArray();
            sendServer = new DatagramPacket(sendBuff, sendBuff.length, address, 9999);
            Manager m= new Manager();
            theclient= new DatagramSocket();
            older= new Older();
            older.setChoice(Older.Xem_danh_sach_sinh_vien);
            theclient.send(m.SendPacket(older));
            //nhan
            receiveBuff= new byte[1024];
            receiveServer= new DatagramPacket(receiveBuff, receiveBuff.length);
            theclient.receive(receiveServer);
            /*arrin= new ByteArrayInputStream(receiveServer.getData());
            input= new ObjectInputStream(arrin);
            older= (Older) input.readObject();
            older= m.receivePacket(receiveServer);
            ArrayList<SinhVien> listSV= older.getListSv();
            for (SinhVien sv:listSV)
            {
                System.out.println(sv.toString());
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    
    /**
     * @param args the command line arguments
     */
    static Scanner in= new Scanner(System.in);
    static Manager m= new Manager();
    public static int menu()
    {
        
        System.out.println("Menu:\n1.Xem danh sach sinh vien\n2. Thêm một sinh viên.\n3. Xóa một sinh viên.\n4. Cập nhập một sinh viên.\n5. Tìm kiếm một sinh viên.\n6. Exit.");
        int i=in.nextInt();

        return i;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int x=0;
        do{
        x=menu();
        switch (x)
        {
            case Older.Xem_danh_sach_sinh_vien:
                m.Xemdanhsach();
                break;
            case Older.Them_mot_sinh_vien:
                m.themsinhvien();
                break;
            case Older.Xoa_mot_sinh_vien:
                m.Xoasinhvien();
                break;
            case Older.Cap_nhap_mot_sinh_vien:
                m.capnhapsinhvien();
                break;
            case Older.Tim_kiem_mot_sinh_vien:
                m.timkiemsinhvien();
                break;
            case Older.Ngat_ket_noi:
                System.out.println("Ngat ket noi");
                break;
            default:
                System.out.println("Số bạn chọn ko có trong menu ==!!!");
                break;
        }
        }while (x!=Older.Ngat_ket_noi);
        
    }
}
    
        
        
        
        

    