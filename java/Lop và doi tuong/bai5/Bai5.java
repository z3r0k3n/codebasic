/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai5;

/**
 *
 * @author ASM
 */
import java.util.Scanner;
public class Bai5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in=new Scanner(System.in);
        int x,n,d;
        PhanSo ps=new PhanSo();
        do
        {
            System.out.printf("Menu:\n1: Input. \n2: Reduce(Tối giản phân số). \n3: Reciprocal(Nghịch đảo phân số). \n4: Add(Cộng 2 phân số).\n5: Subtract (Trừ 2 phân số). \n6: Multiply (Nhân 2 phân số).\n7: Divide (Chia 2 phân số).\n8: Compare (So sánh). \n9: Exit.\n Chọn: ");
            x=in.nextInt();
            if (x>0 && x<9)
            {
                switch (x)
                {
                    case 1:
                        System.out.printf("Nhập phân số: \nTử số: ");
                        ps.setNumerator(in.nextInt());
                        System.out.printf("\nMẫu số: ");
                        ps.setDenominator(in.nextInt());
                    case 2:
                        ps.Reduce();
                        System.out.println(ps.ToString());
                        break;
                    case 3:
                        ps.Reciprocal();
                        System.out.println(ps.ToString());
                        break;
                    case 4:
                        System.out.printf ("\n Nhập tử số thứ 2: ");
                        n=in.nextInt();
                        System.out.printf ("\n Nhập mẫu số thứ 2: ");
                        d=in.nextInt();
                        ps.Add(n,d);
                        System.out.println(ps.ToString());
                        break;
                    case 5:
                        System.out.printf ("\n Nhập tử số thứ 2: ");
                        n=in.nextInt();
                        System.out.printf ("\n Nhập mẫu số thứ 2: ");
                        d=in.nextInt();
                        ps.Subtract(n, d);
                        System.out.println(ps.ToString());
                        break;
                    case 6:
                        System.out.printf ("\n Nhập tử số thứ 2: ");
                        n=in.nextInt();
                        System.out.printf ("\n Nhập mẫu số thứ 2: ");
                        d=in.nextInt();
                        ps.Multiply(n, d);
                        System.out.println(ps.ToString());
                        break;
                    case 7:
                        System.out.printf ("\n Nhập tử số thứ 2: ");
                        n=in.nextInt();
                        System.out.printf ("\n Nhập mẫu số thứ 2: ");
                        d=in.nextInt();
                        ps.Divide(n, d);
                        System.out.println(ps.ToString());
                    case 8:
                        System.out.printf ("\n Nhập tử số thứ 2: ");
                        n=in.nextInt();
                        System.out.printf ("\n Nhập mẫu số thứ 2: ");
                        d=in.nextInt();
                        ps.Compare(n, d);
                }
            }
            else
                System.out.printf ("Try again!");
              
        }
        while (x!=9);
                
    }
    
}
