/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai7;

/**
 *
 * @author ASM
 */
import java.util.Scanner;
public class Bai7 {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        int x,y;
        Manager m=new Manager ();
        
        do
        {
            System.out.printf ("Menu\n1: Nhập danh sách sinh viên. \n2: Xuất danh sách sinh viên \n3: Exit\nChọn: ");
            Scanner in=new Scanner (System.in);
            x=in.nextInt();
            switch (x)
            {
                case 1:
                    System.out.printf ("Số lượng sinh viên cần thêm vào danh sách là: ");
                    y=in.nextInt();
                    m.addSV(y);
                    break;
                case 2:
                    m.Show();
                    break;
                case 3:
                    System.out.println("bye ^^");
                    break;
                default:
                    System.out.println("ko có lựa chọn này hãy chọn lại.");          
            }
        }
        while (x!=3);
        
    }
    
}
