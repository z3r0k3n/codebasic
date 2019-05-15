/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau1;

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
        String sostr;
        BufferedReader input;
        BufferedWriter output;
        Scanner in= new Scanner(System.in);

        
        try{
            socketClient = new Socket("localhost", 9999);
            output = new BufferedWriter(new OutputStreamWriter(socketClient.getOutputStream()));
            input = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            while (true) {
                System.out.println("Nhập số cần tính giai thừa ");
                output.write(in.nextLine());
                output.newLine();
                output.flush();
                //nhận
                sostr=input.readLine();
                if (sostr.equals("exit")) break;
                System.out.println("Server: ->"+sostr);
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
