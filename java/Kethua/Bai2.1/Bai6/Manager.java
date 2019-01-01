/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai6;

/**
 *
 * @author ASM
 */
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Scanner;
import java.util.ArrayList;
public class Manager {
    public static Scanner in= new Scanner (System.in);
    private ArrayList<Gio> listGio= new ArrayList();
    private ArrayList<Ngay> listNgay= new ArrayList();
    //==========================================================================
    // Nhập danh sách các hóa đơn thuê phòng theo giờ.  
    public void inputgio ()
    {
        System.out.println("Cần nhập bao nhiêu hóa đơn: ");
        int i,x=in.nextInt();
        in.nextLine();
        for (i=0;i<x;i++)
        {
            System.out.println("Mã hóa đơn: ");
            String a=in.nextLine();
            System.out.println("Ngày in hóa đơn: ");
            String b=in.nextLine();
            System.out.println("Tên khách hàng: ");
            String c=in.nextLine();
            System.out.println("Số phòng: ");
            String d=in.nextLine();
            System.out.println("Đơn giá: ");
            double e=in.nextDouble();
            System.out.println("Giờ thuê: ");
            int f=in.nextInt();
            if (f>=24 && f <=30)
            {
                f=24;
            }
            else if (f>30)
            {
                System.out.println("Trên 30h không sử dụng hóa đơn giờ");
                System.exit(0);
            }
            Gio g= new Gio (a,b,c,d,e,f);
            listGio.add(g);
        }
    }
    //==========================================================================
    //Nhập danh sách các hóa đơn thuê phòng theo ngày.
    public void inputngay ()
    {
        System.out.println("Cần nhập bao nhiêu hóa đơn: ");
        int i,x=in.nextInt();
        in.nextLine();
        for (i=0;i<x;i++)
        {
            System.out.println("Mã hóa đơn: ");
            String a=in.nextLine();
            System.out.println("Ngày in hóa đơn: ");
            String b=in.nextLine();
            System.out.println("Tên khách hàng: ");
            String c=in.nextLine();
            System.out.println("Số phòng: ");
            String d=in.nextLine();
            System.out.println("Đơn giá: ");
            double e=in.nextDouble();
            System.out.println("Ngày thuê: ");
            int f=in.nextInt();
            Ngay n= new Ngay (a,b,c,d,e,f);
            listNgay.add(n);
        }
    }
    //==========================================================================
    //Xuất danh sách các hóa đon thuê phòng theo giờ;
    public void outputgio ()
    {
        System.out.printf("\n|%20s|%20s|%20s|%20s|%20s|%20s|%20s|\n============================================================================================================================================","Mã hóa đơn","Ngày hóa đơn","Tên khách hành","Mã phòng","Đơn giá","Giờ thuê","Thành tiền");
         for(Gio g: listGio)
         {
             System.out.format("\n|%20s|%20s|%20s|%20s|%20.2f|%20d|%20.2f|", g.getMahd(),g.getNgayhd(),g.getTenkh(),g.getMaphong(),g.getDongia(),g.getGiothue(),g.getThanhtien());
         }
    }
    //==========================================================================
    //Xuất danh sách các hóa đơn thuê phòng theo ngày.
    public void outputNgay ()
    {
        System.out.printf("\n|%20s|%20s|%20s|%20s|%20s|%20s|%20s|\n============================================================================================================================================","Mã hóa đơn","Ngày hóa đơn","Tên khách hành","Mã phòng","Đơn giá","Ngày thuê","Thành tiền");
         for(Ngay n: listNgay)
         {
             System.out.format("\n|%20s|%20s|%20s|%20s|%20.2f|%20d|%20.2f|", n.getMahd(),n.getNgayhd(),n.getTenkh(),n.getMaphong(),n.getDongia(),n.getNgaythue(),n.getThanhtien());
         }
    }
    //==========================================================================
    //Tính tổng số lượng cho thuê phòng theo giờ.
    public void sumGio ()
    {
        int sum=0;
        for (Gio g: listGio)
        {
            sum+=g.getGiothue();
        }
        System.out.printf("Tổng số giờ cho thuê phòng: %d",sum);
    }
    //==========================================================================
    //Tính tổng số lượng cho thuê phòng theo ngày.
    public void sumNgay ()
    {
        int sum=0;
        for (Ngay n: listNgay)
        {
            sum+=n.getNgaythue();
        }
        System.out.printf("Tổng số ngày cho thuê phòng: %d",sum);
    }
    //==========================================================================
    //Tính trung bình thành tiền của hóa đơn thuê phòng theo giờ trong tháng 9/2013.  
    public void avgGio () throws ParseException
    {
        String a="01/09/2013",z="30/09/2013";
        int x,y,i=0;
        double avg,sum=0;
        DateFormat d1= new SimpleDateFormat("dd/MM/yyyy");//chuyển a sang kiểu ngày tháng.
        DateFormat d2= new SimpleDateFormat("dd/MM/yyyy");//chuyển z sang kiểu ngày tháng.
        DateFormat d3= new SimpleDateFormat("dd/MM/yyyy");//chuyển ngayhd sang kiểu ngày tháng.
        Date da= d1.parse(a);
        Date dz= d2.parse(z);
        
        for (Gio g:listGio)
        {
            
            Date dn= d3.parse(g.getNgayhd());
            x= da.compareTo(dn);
            y= dz.compareTo(dn);
            
            if (x<=0&&y>=0)
            {
                 sum+=g.getThanhtien();
                 i++;
            }
        }
        avg=sum/i;
        System.out.printf("Trung bình thành tiền của hóa đơn thuê phòng theo giờ trong tháng 9/2018: %.2f", avg);
    }
    //==========================================================================
    //Tính trung bình thành tiền của hóa đơn thuê phòng theo ngày trong tháng 9/2013.  
    public void avgNgay () throws ParseException
    {
        String a="01/09/2013",z="30/09/2013";
        int x,y,i=0;
        double avg,sum=0;
        DateFormat d1= new SimpleDateFormat("dd/MM/yyyy");//chuyển a sang kiểu ngày tháng.
        DateFormat d2= new SimpleDateFormat("dd/MM/yyyy");//chuyển z sang kiểu ngày tháng.
        DateFormat d3= new SimpleDateFormat("dd/MM/yyyy");//chuyển ngayhd sang kiểu ngày tháng.
        Date da= d1.parse(a);
        Date dz= d2.parse(z);
        
        for (Ngay n:listNgay)
        {
            
            Date dn= d3.parse(n.getNgayhd());
            x= da.compareTo(dn);
            y= dz.compareTo(dn);
            
            if (x<=0&&y>=0)
            {
                 sum+=n.getThanhtien();
                 i++;
            }
        }
        avg=sum/i;
        System.out.printf("Trung bình thành tiền của hóa đơn thuê phòng theo ngày tổng tháng 9/2018: %.2f", avg);
    }
}
