/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.internal.util.xml.impl.Input;

/**
 *
 * @author Zero Ken
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in= new Scanner(System.in);
        ServerSocket listener;
        Socket socketServer;
        ObjectInputStream input;
        ObjectOutputStream output;
        Older older;
        //==============
        try{
            System.out.println("server running ...");
            listener = new ServerSocket(9999);
            socketServer = listener.accept();
            output= new ObjectOutputStream(socketServer.getOutputStream());
            input= new ObjectInputStream(socketServer.getInputStream());
            System.out.println("accept");
            //dang nhap
            do{
                older= (Older) input.readObject();
                System.out.println("Client: ->"+older.getUser());
                System.out.println("Client: ->"+older.getPass());
                if(older.getUser().equals("sa") && older.getPass().equals("123"))
                {
                    older.setSend("Đăng nhập thành công :>");
                    output.writeObject(older);
                    break;
                }
                else
                {
                    System.out.println("Client: ->"+older.getUser());
                    System.out.println("Client: ->"+older.getPass());
                    older.setSend("Đăng nhập không thành công TT^TT");
                    older.setUser("0");
                    output.writeObject(older);
                }
            }while (true);
            //chat su dung thread để chạy nhập và xuất cùng lúc
            System.out.println("Đã chuyển qua chat");
            new Read(socketServer);
            while (true) {
                //nhan
                
                /*older = (Older) input.readObject();
                System.out.println("Server: ->" + older.getSend());
                if(older.getSend().equals("ex"))
                {
                    older.setSend("ex");
                    output.writeObject(older);
                    System.out.println("Ngắt kết nối");
                    break;
                }
                */
                //gui
                older.setSend(in.nextLine());
                output.writeObject(older);
                
                
                
            }
        }   catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static class Read extends Thread
    {
        ObjectInputStream input= null;
        Older older = null;
        public Read (Socket socket)
        {
            try {
                input=new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
            start();
        }
        @Override
        public void run()
        {
            while (true) {                
                try {
                    older = (Older) input.readObject();
                    if (older.getSend()!=null)
                        System.out.println("Client: ->"+older.getSend());
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
