/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

/**
 *
 * @author Zero Ken
 */
public class Message extends UnicastRemoteObject implements Interface_B3T7{

    private Scanner in= new Scanner(System.in);
    public Message() throws RemoteException                                                      {
    }

    

    @Override
    public String chat(String receiveClient) throws RemoteException {
        String sendClient;
        System.out.println("Client: ->"+receiveClient);
        sendClient = in.nextLine();
        return sendClient;
    }

    @Override
    public Older Dangnhap(Older odin) throws RemoteException {
        Older older = new Older();
        if(odin.getUser().equals("sa") && odin.getPass().equals("123"))
        {
            older.setSend("đăng nhập thành công :>");
            System.out.println("Chuyển qua chat:");
            older.setUser("1");
        }
        else
        {
                older.setSend("đăng nhập không thành công");
                older.setUser("0");
        }
        return older;
    }

      
}
