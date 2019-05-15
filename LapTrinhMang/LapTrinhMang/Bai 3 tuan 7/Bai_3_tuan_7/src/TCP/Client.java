/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
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
    public static void main(String[] args) {
        // TODO code application logic here
        Socket socketClient;
        ObjectInputStream input;
        ObjectOutputStream output;
        Older older = null;
        //BufferedReader input;
        //BufferedWriter output;
        //String send;
        Scanner in= new Scanner(System.in);
        //=============
        try {
            socketClient = new Socket("localhost", 9999);
            input= new ObjectInputStream(socketClient.getInputStream());
            output= new ObjectOutputStream(socketClient.getOutputStream());
            //gui
            older= new Older();
            System.out.println("Kết nối thành công: ");
            older.setSend(in.nextLine());
            output.writeObject(older);
            //nhan
            older= (Older) input.readObject();
            System.out.println(older.getSend());
            /*input = new  BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            output = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
            // gui
            System.out.println("Nhập văn bản :");
            send = in.nextLine();
            output.write(send);
            output.newLine();
            output.flush();
            //nhan
            send = input.readLine();
            System.out.println("Server: ->" + send);*/
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
