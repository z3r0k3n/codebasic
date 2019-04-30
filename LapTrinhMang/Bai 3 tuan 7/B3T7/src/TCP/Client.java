/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero Ken
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
        Scanner in= new Scanner(System.in);
        Socket socketClient;
        ObjectInputStream input=null;
        ObjectOutputStream output = null;
        Older older=null;
        
        //==========
        
        try{
            socketClient = new Socket("localhost", 9999);
            output = new ObjectOutputStream (socketClient.getOutputStream());
            input = new ObjectInputStream(socketClient.getInputStream());
            System.out.println("accept :>");
            older= new Older();
            //dang nhap
            do{
                //gui user vs pass
                System.out.println("Server: ->Nhap user: ");
                older.setUser(in.nextLine());
                System.out.println("Server: ->Nhap pass: ");
                older.setPass(in.nextLine());
                output.writeObject(older);
                //nhan ket qua
                older= (Older) input.readObject();
                System.out.println("Server: ->"+older.getSend());
            }while(older.getUser().equals("0"));
            //chat
            System.out.println("Đã chuyển qua chat");
            while (true){
                //gui
                
                older.setSend(in.nextLine());
                output.writeObject(older);
                //nhan
                older = (Older) input.readObject();
                if(older.getSend().equals("ex"))
                {
                    older.setSend("ex");
                    output.writeObject(older);
                    System.out.println("Ngat ket noi");
                    break;
                }
                System.out.println("Server: ->"+older.getSend());
            }
        
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
