/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP.Client;

import Java_SQL.Older;
import Java_SQL.Sach;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero Ken
 */
public class Manager {
    private Socket socketClient;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private Scanner in= new Scanner(System.in);
    private Older older;

    public Manager() {
        try {
            older = new Older();
            socketClient = new Socket("localhost", 9999);
            output = new ObjectOutputStream(socketClient.getOutputStream());
            input = new ObjectInputStream(socketClient.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Xemsach ()
    {
        try {
            //gui
            older.setChoice(Older.Xem_sach);
            output.writeObject(older);
            //nhan
            older = (Older) input.readObject();
            ArrayList<Sach> listBook = older.getListB();
            for (Sach s:listBook)
            {
                System.out.println(s.toString());
            }
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Muonsach ()
    {
        try {
            //gui
            System.out.println("Nhập ID: ");
            older.setID(in.nextLine());
            older.setChoice(Older.Muon_sach);
            output.writeObject(older);
            //nhan
            older =(Older) input.readObject();
            System.out.println("Server: ->" + older.getChoice());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Trasach()
    {
        try{
            //gui
            System.out.println("Nhập ID: ");
            older.setChoice(Older.Tra_sach);
            older.setID(in.nextLine());
            output.writeObject(older);
            //nhan
            older =(Older) input.readObject();
            System.out.println("Server: ->" + older.getChoice());
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ngatketnoi()
    {
        try{
            older.setChoice(Older.Ngat_ket_noi);
            output.writeObject(older);
        } catch (IOException ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
