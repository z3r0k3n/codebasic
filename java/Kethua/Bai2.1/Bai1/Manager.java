/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

/**
 *
 * @author ASM
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Manager {
    public static Scanner in=new Scanner (System.in);
    private ArrayList<Xenoi> listXenoi=new ArrayList();
    private ArrayList<Xengoai> listXengoai=new ArrayList();
    //==========================================================================
    //Nhập xe nội
    public void addXenoi(int n)
    {
        int i;
        for(i=0;i<n;i++)
        {
            System.out.println("Nhập mã số chuyển: ");
            String Sochuyen=in.nextLine();
            System.out.println("Họ và tên tài xế: ");
            String Taixe=in.nextLine();
            System.out.println("Số xe: ");
            String Soxe=in.nextLine();
            System.out.println("Doanh thu: ");
            double Doanhthu=in.nextDouble();
            System.out.println("Số tuyến");
            int Sotuyen=in.nextInt();
            in.nextLine();
            System.out.println("Số km đi được: ");
            double Sokm=Integer.parseInt(in.nextLine());
            Xenoi xe=new Xenoi(Sochuyen,Taixe,Soxe,Doanhthu,Sotuyen,Sokm);
            listXenoi.add(xe);
        }   
    }
    //==========================================================================
    //Nhập xe ngoại
     public void addXengoai(int n)
    {
        int i;
        for(i=0;i<n;i++)
        {
            System.out.println("Nhập mã số chuyển: ");
            String Sochuyen=in.nextLine();
            System.out.println("Họ và tên tài xế: ");
            String Taixe=in.nextLine();
            System.out.println("Số xe: ");
            String Soxe=in.nextLine();
            System.out.println("Doanh thu: ");
            double Doanhthu=in.nextDouble();
            System.out.println("Nơi đến: ");
            String Noiden=in.nextLine();
            System.out.println("Số ngày đi được: ");
            int Songay=Integer.parseInt(in.nextLine());
            Xengoai xe=new Xengoai(Sochuyen,Taixe,Soxe,Doanhthu,Noiden,Songay);
            listXengoai.add(xe);
        }   
        
    }
     //=========================================================================
     //Xuất danh sách xe nội
     public void showXenoi()
     {
         System.out.printf("|%20s|%25s|%20s|%20s|%20s|%20s|\n============================================================================================================================================","Mã số chuyến","Họ tên tài xế","Số xe","Số tuyến","Số km đi được","Doanh thu");
         for(Xenoi xe: listXenoi)
         {
             System.out.format("\n|%20s|%25s|%20s|%20d|%20.2f|%20.2f|", xe.getSochuyen(),xe.getTaixe(),xe.getSoxe(),xe.getSotuyen(),xe.getSokm(),xe.getDoangthu());
         }
     }
     //=========================================================================
     //Xuất danh sách xe ngoại.
     public void showXengoai()
     {
         System.out.printf("|%20s|%25s|%20s|%20s|%20s|%20s|\n============================================================================================================================================","Mã số chuyến","Họ tên tài xế","Số xe","Nơi đến","Số ngày đi được","Doanh thu");
         for(Xengoai xe: listXengoai)
         {
             System.out.format("\n|%20s|%25s|%20s|%20d|%20.2f|%20.2f|", xe.getSochuyen(),xe.getTaixe(),xe.getSoxe(),xe.getNoiden(),xe.getSongay(),xe.getDoangthu());
         }
     }
     //=========================================================================
     //Tính tổng doanh thu xe nội.
     public double sumDoanhthuxenoi()
     {
         int i;
         double sum=0;
         for (i=0;i<listXenoi.size();i++)
         {
             sum+=listXenoi.get(i).getDoangthu();
         }
         return sum;
     }
     //=========================================================================
     //Tính tổng doanh thu xe ngoại.
     public double sumDoanhthuxengoai()
     {
         int i;
         double sum=0;
         for (i=0;i<listXengoai.size();i++)
         {
             sum+=listXenoi.get(i).getDoangthu();
         }
         return sum;
     }
     
     
}
