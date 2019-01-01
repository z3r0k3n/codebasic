/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai4;

/**
 *
 * @author ASM
 */
import java.text.ParseException;
import java.util.Scanner;
public class Test {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        Scanner in= new Scanner (System.in);
        int x;
        Manager m= new Manager ();
        do
        {
            System.out.println("\n===========================================================================================================");
            System.out.println("\nMenu:\n1: Nhập giao dịch đất.\n2: Nhập giao dịch nhà.\n3: Danh sách giao dịch đất.\n4: Danh sách giao dịch nhà.\n5: Tổng diện tích đất giao dịch.\n6: Tổng diện tích nhà giao dịch.\n7: Trung bình thành tiền giao dịch đât.\n8: Danh sách giao dịch đất 9/2013.\n9: Danh sách giao dịch nhà 9/2013.\n10: Exit.\nChọn: ");
            x=in.nextInt();
            in.nextLine();
            System.out.println("\n===========================================================================================================");
            switch (x)
            {
                case 1:
                    m.inputDat();
                    break;
                case 2:
                    m.inputNha();
                    break;
                case 3:
                    m.outputDat();
                    break;
                case 4:
                    m.outputNha();
                    break;
                case 5:
                    m.sumDat();
                    break;
                case 6:
                    m.sumNha();
                    break;
                case 7:
                    m.avgDat();
                    break;
                case 8:
                    m.timDat();
                    break;
                case 9:
                    m.timNha();
                    break;
                case 10:
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!( REMEMBER-ME )!!!!!!!!!!!!!!!!!!!!!!");
                    break;
                default:
                    System.out.println("!!!!!Lựa chọn vủa bạn ko có!!!!!");
                    break;
            }
        }
        while (x!=10);
    }
}
