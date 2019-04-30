/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Java_SQL.Older;
import java.util.Scanner;

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
        int i=0;
        Manager m=new Manager();
        Scanner in=new Scanner(System.in);
        
        System.out.println("Menu\nChọn: ");
        i=in.nextInt();
        in.nextLine();
        switch(i)
        {
            case 2:
                m.Xemdanhsach();
                break;
            default:
                System.out.println("nothing");
                break;
            case 1:
                m.Themtaikhoan();
                break;
        }
    
    }
    }

