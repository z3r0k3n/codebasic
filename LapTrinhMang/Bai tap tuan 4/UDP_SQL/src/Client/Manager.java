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
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class Manager {
    private Scanner in= new Scanner(System.in);
    private DatagramPacket sendServer;
    private DatagramPacket receiveServer;
    private DatagramSocket theclient;
    private byte[] sendBuff;
    private byte[] receiveBuff;
    private InetAddress address;
    private Older older;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private ByteArrayOutputStream arrout;
    private ByteArrayInputStream arrin;
    //=======================================================================
    public Manager() 
    {
        try {
            sendBuff= new byte[1024];
            receiveBuff= new byte [1024];
            older= new Older();
            theclient= new DatagramSocket();
            receiveServer= new DatagramPacket(receiveBuff, receiveBuff.length);
        } catch (SocketException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //==========================================================================
    /*+ Xem toàn bộ danh sách sinh viên.
		
		
		
		2 Xóa một sinh viên: người dùng Nhập ID của sinh viên nếu tìm thấy ID chương trình tiến hành xóa sinh viên và nhận
		được thông báo thành công còn ngược lại thì chương trình sẽ báo ko tìm thấy id
		
		3 Cập nhập thông tin một sinh vien: Người dùng sẽ nhập mã sinh viên cần cập nhật nếu không có id thì sẽ báo ko có id 
		cần chỉnh sửa. nếu ID có thì tiến hành cập nhập tên, quê quán, Ngay sinh.
		
		4 Tìm sinh viên: người dùng nhập ID của sinh viên cần tìm server trả về thông tin theo mã sinh viên nếu sinh viên 
		đó không có trong danh sách thì thông báo sinh viên đó không năm trong danh sách.*/
    //1. xem danh sach sinh vien
    public void Xemdanhsach()
    {
        try {
            //gui
            older.setChoice(Older.Xem_danh_sach_sinh_vien);
            theclient.send(SendPacket(older));
            //nhan
            
            theclient.receive(receiveServer);
            older= receivePacket(receiveServer);
            ArrayList<SinhVien> listSV = older.getListSv();
            for (SinhVien sv: listSV)
            {
                System.out.println(sv.toString());
            }
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
    
    public void themsinhvien()
    {
        try {
            //gui
            older.setChoice(Older.Them_mot_sinh_vien);
            older.setSv(SV());
            theclient.send(SendPacket(older));
            //nhan
            theclient.receive(receiveServer);
            older= receivePacket(receiveServer);
            System.out.println("Server-> Row:"+older.getRow());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Xoasinhvien()
    {
        try {
            //gui
            older.setChoice(Older.Xoa_mot_sinh_vien);
            System.out.println("Nhập ID: ");
            older.setThongbao(in.nextLine());
            theclient.send(SendPacket(older));
            //nhan
            theclient.receive(receiveServer);
            older= receivePacket(receiveServer);
            System.out.println("Server-> Row:"+older.getRow());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void capnhapsinhvien()
    {
        try {
            //gui
            older.setChoice(Older.Cap_nhap_mot_sinh_vien);
            older.setSv(SV());
            theclient.send(SendPacket(older));
            //nhan
            theclient.receive(receiveServer);
            older=receivePacket(receiveServer);
            System.out.println("Server-> Row:"+older.getRow());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void timkiemsinhvien ()
    {
        try {
            //gui
            older.setChoice(Older.Tim_kiem_mot_sinh_vien);
            System.out.println("Nhập ID:");
            older.setThongbao(in.nextLine());
            theclient.send(SendPacket(older));
            //nhan
            theclient.receive(receiveServer);
            older= receivePacket(receiveServer);
            for (SinhVien sv: older.getListSv())
            {
                System.out.println(sv.toString());
            }
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //==========================================================================
    // đóng gói packet để gửi đi 
    public DatagramPacket SendPacket(Older odin)
    {
        try {
            address= InetAddress.getLocalHost();
            arrout= new ByteArrayOutputStream();
            output= new ObjectOutputStream(arrout);
            output.writeObject(odin);
            sendBuff=arrout.toByteArray();
            sendServer= new DatagramPacket(sendBuff, sendBuff.length, address, 9999);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sendServer;
    }
    //gỡ gói packet nhận được và lấy dữ liệu
    public Older receivePacket (DatagramPacket rp)
    {
        try {
            //Older odin= new Older();
            arrin= new ByteArrayInputStream(rp.getData());
            input= new ObjectInputStream(arrin);
            older= (Older) input.readObject();
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return older;
    }
    public SinhVien SV ()
    {
        SinhVien sv= new SinhVien();
        try {
        System.out.println("Nhập ID: ");
        sv.setID(in.nextLine());
        System.out.println("Nhập Name: ");
        sv.setName(in.nextLine());
        System.out.println("Nhập Quê quan: ");
        sv.setQue_quan(in.nextLine());
        System.out.println("Nhập Birthday: ");
        String srtBirth = in.nextLine();
        DateFormat form= new SimpleDateFormat("dd/MM/yyyy");
        
        sv.setBirthday(form.parse(srtBirth));
        } catch (ParseException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sv;
    }
}

