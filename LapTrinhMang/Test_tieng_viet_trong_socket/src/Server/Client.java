/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
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
        String send;
        BufferedReader input;
        BufferedWriter output;
        Socket socketClient;
        Scanner in= new Scanner(System.in);
        //=======================================================
        try{
            socketClient = new Socket("localhost", 9999);
            output = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
            input = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            
            System.out.println("Nhập một từ tiếng việt.");
            send = in.nextLine();
            output.write(send);
            output.newLine();
            output.flush();
            send = input.readLine();
            System.out.println("Server: ->"+send);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
