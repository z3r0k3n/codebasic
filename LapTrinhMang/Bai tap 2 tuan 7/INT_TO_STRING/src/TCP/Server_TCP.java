package TCP;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        BufferedReader input = null;
        BufferedWriter output = null;
        String receiveClient,sendClient;
        try {
            //======================================================================
            listener= new ServerSocket(9999);
            socketServer= listener.accept();
            input=new BufferedReader (new InputStreamReader(socketServer.getInputStream()));
            output= new BufferedWriter( new OutputStreamWriter(socketServer.getOutputStream()));
        } catch (IOException ex) {
            Logger.getLogger(Server_TCP.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (true)
        {
        try {
            receiveClient= input.readLine();
            if(receiveClient.equals("ex"))
            {
                output.write("ex");
                output.newLine();
                output.flush();
                break;
            }
            output.write(INT_String(receiveClient));
            output.newLine();
            output.flush();
        } catch (IOException ex) {
            Logger.getLogger(Server_TCP.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
    public static String INT_String (String no)
    {
        String kq="";
        switch(no)
        {
            case "0":
                kq="Không";
                break;
            case "1":
                kq="Một";
                break;
            case "2":
                kq="Hai";
                break;
            case "3":
                kq="Ba";
                break;
            case "4":
                kq="Bốn";
                break;
            case "5":
                kq="Năm";
                break;
            default:
                kq="Số vừa nhập không nằm trong khoảng từ 0 đến 5";
                break;
        }
        return kq;
    }
    
}
