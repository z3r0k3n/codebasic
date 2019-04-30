/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Java_SQL.Account;
import Java_SQL.Older;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero Ken
 */
public class Manager {
    private Scanner in= new Scanner(System.in);
    private Socket clientSocket=null;
    private ObjectOutputStream Output=null;
    private ObjectInputStream Input=null;
    private Older older=null;

    public Manager() {
        try {
            older = new Older();
            clientSocket=new Socket("localhost", 9999);
            Output=new ObjectOutputStream(clientSocket.getOutputStream());
            Input=new ObjectInputStream(clientSocket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public  void Themtaikhoan ()
    {
        try {
            Account acc = new Account();
            older.setChoice(Older.TAO_MOI_TAI_KHOAN);
            System.out.println("Nhập ID: ");
            acc.setID(in.nextLine());
            System.out.println("Nhập Số tiền trong tài khoản");
            acc.setBALANCE(in.nextInt());
            in.nextLine();
            System.out.println("Nhập ngày gửi: ");
            String datestr=in.nextLine();
            DateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            acc.setDEPOSITDAY(format.parse(datestr));
            System.out.println("Nhập ngày Rút");
            String gui =in.nextLine();
            acc.setWITHDRAWDAY(format.parse(gui));
            older.setNewacc(acc);
            Output.writeObject(acc);
            //nhan
            
            older = (Older) Input.readObject();
            System.out.println("Server: -> row: "+ older.getRow());
        } catch (ParseException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public  void Xemdanhsach()
    {
        try {
            older.setChoice(Older.XEM_DANH_SACH_TAI_KHOAN);
            Output.writeObject(older);
            
            
            //nhan
            older= (Older) Input.readObject(); 
            ArrayList<Account> listA= older.getList();
            
            for (Account a:listA) {
                System.out.println(a.toString());
            }
                    } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ruttien()
    {
        
    }
    
    
    
}
