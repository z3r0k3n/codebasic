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
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zero Ken
 */
public class Server {
    public static int day (int month){
        int day=0;
        int[] month31={1,3,5,7,8,10,12},month30={4,6,9,11};
        if (month == 2) day =28;
        for (int i:month31)
        {
            if (i==month) day =31;
        }
        for (int i:month30)
        {
            if (i==month) day =30;
        }
        return day;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ServerSocket listener;
        Socket socketServer;
        String monthstr;
        int month;
        BufferedReader input;
        BufferedWriter output;
        //=======================
        try{
            listener = new ServerSocket(9999);
            socketServer = listener.accept();
            output = new BufferedWriter(new OutputStreamWriter(socketServer.getOutputStream()));
            input = new BufferedReader(new InputStreamReader(socketServer.getInputStream()));
            while (true) {
                //nhận
                monthstr = input.readLine();
                if (monthstr.equals("exit")) break;
                month = Integer.parseInt(monthstr);
                month = day(month);
                //gửi
                output.write(String.valueOf(month));
                output.newLine();
                output.flush();
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
