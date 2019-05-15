/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP.Server;

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
public class Server_TCP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServerSocket listener;
        Socket socketServer;
        Older older = null;
        ObjectOutputStream output = null;
        ObjectInputStream input = null;
        Java_SQL js = new Java_SQL();
        //kee noi
        try{
            System.out.println("Server running...");
            older = new Older();
            listener = new ServerSocket(9999);
            socketServer = listener.accept();
            output = new ObjectOutputStream(socketServer.getOutputStream());
            input = new ObjectInputStream(socketServer.getInputStream());
            System.out.println("Accept :3");
        } catch (IOException ex) {
            Logger.getLogger(Server_TCP.class.getName()).log(Level.SEVERE, null, ex);
        }
        do{
            try{
                older = (Older) input.readObject();
                System.out.println(older.getChoice());
                switch (older.getChoice()) {
                    case Older.Xem_sach:
                        older.setListB(js.listBook());
                        output.writeObject(older);
                        break;
                    case Older.Muon_sach:
                        older.setChoice(js.Muon_sach(older.getID()));
                        output.writeObject(older);
                        break;
                    case Older.Tra_sach:
                        older.setChoice(js.Tra_sach(older.getID()));
                        output.writeObject(older);
                        break;
                    case Older.Ngat_ket_noi:
                        System.out.println("Ngắt kết nối");
                        break;
                }
            } catch (IOException ex) {
                Logger.getLogger(Server_TCP.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Server_TCP.class.getName()).log(Level.SEVERE, null, ex);
            }
        }while (older.getChoice()!=Older.Ngat_ket_noi);
        
    }
    
}
