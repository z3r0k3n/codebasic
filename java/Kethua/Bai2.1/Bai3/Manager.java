/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3;

/**
 *
 * @author ASM
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Manager {
    public static Scanner in=new Scanner (System.in);
    private ArrayList<Vang> listVang=new ArrayList();
    private ArrayList<Tiente> listTiente=new ArrayList();
    //==========================================================================
    //Nhập danh sách giao dich vàng.
    public void nhapVang()
    {
        int i,n;
        System.out.println("Số lượng giao dịch bạn muốn nhập: ");
        n=in.nextInt();
        for (i=0;i<n;i++)
        {
            System.out.println("Mã giao dịch: ");
            int a=in.nextInt();
            in.nextLine();
            System.out.println("Ngày giao dich: ");
            String b=in.nextLine();
            System.out.println("Đơn giá: ");
            double c=in.nextDouble();
            System.out.println("Số lượng: ");
            int d=in.nextInt();
            in.nextLine();
            System.out.println("Loại vàng: ");
            String e=in.nextLine();
            Vang v= new Vang (e,a,d,c,b);
            listVang.add(v);
        }
    }
    //==========================================================================
    //Nhập danh sách giao dich Tiền tệ.
    public void nhapTiente()
    {
        int i,n;
        System.out.println("Số lượng giao dịch bạn muốn nhập: ");
        n=in.nextInt();
        for (i=0;i<n;i++)
        {
            System.out.println("Mã giao dịch: ");
            int a=in.nextInt();
            in.nextLine();
            System.out.println("Ngày giao dich: ");
            String b=in.nextLine();
            System.out.println("Đơn giá: ");
            double c=in.nextDouble();
            System.out.println("Số lượng: ");
            int d=in.nextInt();
            double e=xetTigia();
            Tiente t= new Tiente (e,a,d,c,b);
            listTiente.add(t);
        }
    }
    //Tỉ giá giao dich VND vs USD và VND vs Euro.
    public double xetTigia()
    {
        int i;
        double x=0;
        {
            System.out.println("Tiền tệ trong giao dịch của bạn là: \n1: VND\n2: USD\n3: EUR");
            i=in.nextInt();
            switch (i)
            {
                case 1:
                    x=1;
                    break;
                case 2:
                    x= 0.00004;
                    break;
                case 3:
                    x= 0.00035;
                    break;
                default:
                    System.out.println("!!!!!Tỉ giá bạn muốn giao dich ko có!!!!!");
            }
        }
        while (i!=1&&i!=2&&i!=3);
        return x;
    }
    //==========================================================================
    //Xuất danh sách giao dịch vàng.
    public void xuatVang ()
    {
        System.out.println("Danh sách giao dich vàng: ");
        System.out.printf("\n|%20s|%20s|%20s|%20s|%20s|%20s|","Mã giao dịch","Ngày giao dịch","Đơn giá","Số lượng","Loại vàng","Thành tiền");
        for (Vang v: listVang)
        {
            System.out.format("\n|%20d|%20s|%20f|%20d|%20s|%20f|",v.getMagd(),v.getNgaygd(),v.getDongia(),v.getSoluong(),v.getLoaivang(),v.getThanhtien());
        }
    }
    //==========================================================================
    //Xuất danh sách giao dịch tiền tệ.
    public void xuatTiente ()
    {
        System.out.println("Danh sách giao dich vàng: ");
        System.out.printf("\n|%20s|%20s|%20s|%20s|%20s|%20s|","Mã giao dịch","Ngày giao dịch","Đơn giá","Số lượng","Tỉ giá","Thành tiền");
        for (Tiente v: listTiente)
        {
            System.out.format("\n|%20d|%20s|%20f|%20d|%20f|%20f|",v.getMagd(),v.getNgaygd(),v.getDongia(),v.getSoluong(),v.getTigia(),v.getThanhtien());
        }
    }
    //==========================================================================
    //Tính tổng số lượng vàng.
    public int sumVang()
    {
        int i,sum=0;
        
        for (i=0;i<listVang.size();i++)
        {
            sum+=listVang.get(i).getSoluong();
        }
        return sum;
    }
    //==========================================================================
    //Tính tổng số lượng giao dịch tiền tệ.
    public int sumTiente()
    {
        int i,sum=0;
        
        for (i=0;i<listTiente.size();i++)
        {
            sum+=listTiente.get(i).getSoluong();
        }
        return sum;
    }
    //==========================================================================
    //Tính trung bình thành tiền giao dịch tiền tệ.
    public double avgTiente()
    {
        int i;
        double sum=0,avg;
        for (i=0;i<listTiente.size();i++)
        {
            sum+=listTiente.get(i).getThanhtien();
        }
        avg=sum/listTiente.size();
        return avg;
    }
    //==========================================================================
    //Xuất ra các giao dịch vàng có đơn giá >1 tỷ.
    public void dongiaVang()
    {
        System.out.println("Các giao dịch vàng trên 1 tỷ: ");
        System.out.printf("\n|%20s|%20s|%20s|%20s|%20s|%20s|","Mã giao dịch","Ngày giao dịch","Đơn giá","Số lượng","Loại vàng","Thành tiền");
        for (Vang v: listVang)
        {
            if (v.getDongia()>1000000000)
                System.out.format("\n|%20d|%20s|%20.2f|%20d|%20s|%20.2f|",v.getMagd(),v.getNgaygd(),v.getDongia(),v.getSoluong(),v.getLoaivang(),v.getThanhtien());
        }
        
    }
    //==========================================================================
    //Xuất ra các giao dich tiền tệ có đơn giá >1 tỷ.
    public void dongiaTiente()
    {
        System.out.println("Các giao dịch tiền tệ trên 1 tỷ: ");
        System.out.printf("\n|%20s|%20s|%20s|%20s|%20s|%20s|","Mã giao dịch","Ngày giao dịch","Đơn giá","Số lượng","tỉ giá","Thành tiền");
        for (Tiente v: listTiente)
        {
            if (v.getDongia()>1000000000)
                System.out.format("\n|%20d|%20s|%20.2f|%20d|%20f|%20.2f|",v.getMagd(),v.getNgaygd(),v.getDongia(),v.getSoluong(),v.getTigia(),v.getThanhtien());
        }
        
    }
}
