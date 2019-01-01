/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

/**
 *
 * @author ASM
 */
import java.util.Scanner;
import java.util.ArrayList;
public class Manager {
    public static Scanner in = new Scanner (System.in);
    private ArrayList<Sachgiaokhoa> listSachgiaokhoa = new ArrayList();
    private ArrayList<Sachthamkhao> listSachthamkhao = new ArrayList();
    //==========================================================================
    //Thêm n sách giao khoa.    
    public void addSachgiaokhoa(int n)
    {
        int i;
        for (i=0;i<n;i++)
        {
        System.out.println("Nhập mã sách: ");
        int a=in.nextInt();
        in.nextLine();
        System.out.println("Ngày Nhập(dd/MM/yyyy): ");
        String b=in.nextLine();
        System.out.println("Đơn giá: ");
        double c=in.nextDouble();
        in.nextLine();
        System.out.println("Số lượng: ");
        int d=Integer.parseInt(in.nextLine());
        System.out.println("Nhà xuất bản: ");
        String e=in.nextLine();
        System.out.println("Nhập tình trạng: ");
        String f=in.nextLine();
        Sachgiaokhoa s= new Sachgiaokhoa (f,a,b,c,d,e);
        listSachgiaokhoa.add(s);
        }
    }
     //==========================================================================
    //Them n sach tham khao.
    public void addSachthamkhao (int n)
    {
        int i;
        for (i=0;i<n;i++)
        {
        System.out.println("Nhập mã sách: ");
        int a=in.nextInt();
        in.nextLine();
        System.out.println("Ngày Nhập: ");
        String b=in.nextLine();
        System.out.println("Đơn giá: ");
        double c=in.nextDouble();
        in.nextLine();
        System.out.println("Số lượng: ");
        int d=Integer.parseInt(in.nextLine());
        System.out.println("Nhà xuất bản: ");
        String e=in.nextLine();
        System.out.println("Nhập thuế: ");
        double f=in.nextDouble();
        Sachthamkhao s= new Sachthamkhao (f,a,b,c,d,e);
        listSachthamkhao.add(s);
        }
    }
    //==========================================================================
    //Xuất danh sách sách giao khoa.
    public void showSachgiaokhoa ()
    {
        System.out.printf("\n|%10s|%10s|%10s|%10s|%10s|%10s|%10s|","Mã Sách","Ngày nhập","Đơn giá","Số lượng","Nhà xuất bản","Tình trạng","Thành tiền");
        for (Sachgiaokhoa s: listSachgiaokhoa)
        {
            System.out.format("\n|%10s|%10s|%10s|%10s|%10s|%10s|%10.2f|", s.getMasach(),s.getNgaynhap(),s.getDongia(),s.getSoluong(),s.getNhaxuatbat(),s.setTinhtrang(),s.getThanhtien());
        }
    }
    //==========================================================================
    //Xuất danh sách sách tham khảo.
    public void showSachthamkhao()
    {
         System.out.printf("\n|%10s|%10s|%10s|%10s|%10s|%10s|%10s|","Mã Sách","Ngày nhập","Đơn giá","Số lượng","Nhà xuất bản","Thuế","Thành tiền");
        for (Sachthamkhao s: listSachthamkhao)
        {
            System.out.format("\n|%10s|%10s|%10s|%10s|%10s|%10.2f|%10.2f|", s.getMasach(),s.getNgaynhap(),s.getDongia(),s.getSoluong(),s.getNhaxuatbat(),s.getThue(),s.getThanhtien());
        }
    }
    //==========================================================================
    //Tính tổng tiền cho sách giao khoa.
    public double sumSachgiaokhoa ()
    {
        int i;
        double sum=0;
        for (i=0;i<listSachgiaokhoa.size();i++)
        {
            sum+=listSachgiaokhoa.get(i).getThanhtien();
        }
        return sum;
    }
    //==========================================================================
    //Tính tổng tiền cho sách tham khảo.
    public double sumSachthamkhao ()
    {
        int i;
        double sum=0;
        for (i=0;i<listSachthamkhao.size();i++)
        {
            sum+=listSachthamkhao.get(i).getThanhtien();
        }
        return sum;
    }
    //==========================================================================
    //Trung bình cộng đơn giá của các sách tham khảo.
    public double avgDongiasachthamkhao ()
    {
        int i;
        double sum=0,avg;
        for (i=0;i<listSachthamkhao.size();i++)
        {
            sum+=listSachthamkhao.get(i).getDongia();
        }
        avg=sum/listSachthamkhao.size();
        return avg;
    }
    //==========================================================================
    //Tìm ra các sách giao khoa của nhà xuât bản.
    public void timsachtheonhaxuatban (String x)
    {
        int i;
        System.out.printf("Các sách giao khoa của nhà xuất bản %s: ",x);
        System.out.printf("\n|%10s|%10s|%10s|%10s|","Mã sách","Ngày nhập","Đơn giá","Số lượng");
        for (i=0;i<listSachgiaokhoa.size();i++)
        {
            if (x==listSachgiaokhoa.get(i).getNhaxuatbat())
                System.out.printf("\n|%10d|%10S|%10.2f|%10d|",listSachthamkhao.get(i).getMasach(),listSachthamkhao.get(i).getNgaynhap(),listSachthamkhao.get(i).getDongia(),listSachthamkhao.get(i).getSoluong());
        }
    }
    
}
