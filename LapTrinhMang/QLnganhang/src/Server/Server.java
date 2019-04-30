/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Java_SQL.Java_SQL;
import Java_SQL.Older;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        ServerSocket Listener=null;
        Socket serverSocket=null;
        ObjectOutputStream Output=null;
        ObjectInputStream Input=null;
        Older older=null;
        Java_SQL js = new Java_SQL();
        //=========================================================================================================
  
        try {
            older= new Older();
            System.out.println("Server running....!!!");
            Listener=new ServerSocket(9999);
            serverSocket = Listener.accept();
            Output=new ObjectOutputStream(serverSocket.getOutputStream());
            Input=new ObjectInputStream(serverSocket.getInputStream());
            System.out.println("Acept :>");
            
            //============================================
            older =(Older) Input.readObject();
            
            
            switch(older.getChoice())
            {
                case Older.TAO_MOI_TAI_KHOAN:
                    older.setRow(js.newacc(older.getNewacc()));
                    Output.writeObject(older);
                    break;
                case Older.XEM_DANH_SACH_TAI_KHOAN:
                    older.setList(js.danhsach());
                    Output.writeObject(older);
                    break;
                case Older.RUT_TIEN:
                    older.setRow(js.rut(older.getID(), older.getSotien()));
                    Output.writeObject(older);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
