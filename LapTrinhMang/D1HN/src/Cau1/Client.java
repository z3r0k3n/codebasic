/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau1;

import static Cau1.Server.kiemtra;
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
        Socket socketClient;
        Scanner in= new Scanner(System.in);
        BufferedReader input = null;
        BufferedWriter output = null;
        String send;
        //=====================================================
        try{
            socketClient= new Socket("localhost", 9999);
            output = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
            input = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        do {
            try{
                System.out.println("Nhập số cần sét(nhập 'exit' để thoát): ");
                send=in.nextLine();
                if (send.equals("exit"))
                {
                    output.write(send);
                    output.newLine();
                    output.flush();
                    break;
                }
                output.write(send);
                output.newLine();
                output.flush();
                //nhan;
                System.out.println("Server: ->" + input.readLine());
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
        
    }
    
}
