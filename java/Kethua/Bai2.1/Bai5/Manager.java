/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai5;

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
    public static Scanner in=new Scanner(System.in);
    private ArrayList<Trongnuoc> listTrongnuoc=new ArrayList();
    private ArrayList<Ngoainuoc> listNgoainuoc= new ArrayList();
    //==========================================================================
    //Nhập hóa đon khách hàng Việt Nam.
    public void inputTrongnuoc()
    {
        int i,x;
        System.out.println("Số lượng hóa đơn cần nhập: ");
        x=in.nextInt();
        in.nextLine();
        for(i=0;i<x;i++)
        {
            System.out.println("Mã khách hàng: ");
            String a=in.nextLine();
            System.out.println("Họ và tên khách hành: ");
            String b=in.nextLine();
            System.out.println("Ngày ra hóa đơn: ");
            String c=in.nextLine();
            String d=Doituong();
            System.out.println("Số lượng: ");
            int e=in.nextInt();
            System.out.println("Đơn giá: ");
            double f=in.nextDouble();
            System.out.println("Định mức: ");
            int g=in.nextInt();
            Trongnuoc t= new Trongnuoc(a,b,c,d,e,f,g);
            listTrongnuoc.add(t);
        }
    }
    //Đối tượng.
    public String Doituong()
    {
        int x;
        String y="";
        do
        {
            System.out.println("Đối tượng:\n1: Sinh hoạt.\n2: Kinh doanh.\n3: Sản xuất\nChọn: ");
            x=in.nextInt();
            switch (x)
            {
                case 1:
                    y="Sinh hoạt.";
                    break;
                case 2:
                    y="Kinh doanh.";
                    break;
                case 3:
                    y="Sản xuất.";
                    break;
                default:
                    System.out.println("!!!!!Không có đối tượng từ lựa chọn của bạn!!!!!");
                    break;
            }
        }
        while (x!=1 && x!=2 && x!=3);
        return y;
    }
    //==========================================================================
    //Nhập hóa đọn khách hàng nước ngoài.
    public void inputNgoainuoc()
    {
        int i,x;
        System.out.println("Số lượng hóa đơn cần nhập: ");
        x=in.nextInt();
        in.nextLine();
        for(i=0;i<x;i++)
        {
            System.out.println("Mã khách hàng: ");
            String a=in.nextLine();
            System.out.println("Họ và tên khách hành: ");
            String b=in.nextLine();
            System.out.println("Ngày ra hóa đơn(dd/MM/yyyy): ");
            String c=in.nextLine();
            System.out.println("Quốc tịch: ");
            String d=in.nextLine();
            System.out.println("Số lượng: ");
            int e=in.nextInt();
            System.out.println("Đơn giá: ");
            double f=in.nextDouble();
            Ngoainuoc n= new Ngoainuoc(a,b,c,d,e,f);
            listNgoainuoc.add(n);
        }
    }
    //==========================================================================
    //Xuất hóa đơn khách hành Việt nam.
    public void outputTrongnuoc()
    {
        System.out.println("\n======================================================================================");
        System.out.printf("\n|%20s|%20s|%20s|%20s|%20s|%20s|%20s|","Mã khách hành","Họ và tên khách hàng","Ngày ra hóa đơn","Đối tượng khách hàng","Số lượng","Đơn giá","Định mức","Thành tiền");
        for(Trongnuoc t: listTrongnuoc)
        {
            System.out.format("\n|%20s|%20s|%20s|%20d|%20.2f|%20d|%20.2f",t.getMakh(),t.getTenkh(),t.getNgayhd(),t.getDoitương(),t.getSoluong(),t.getDongia(),t.getDinhmuc(),t.getThanhtien());
            
        }
    }
    //==========================================================================
    //Xuất hóa đơn khách hành nước ngoài.
    public void outputNgoainuoc()
    {
        System.out.println("\n======================================================================================");
        System.out.printf("\n|%20s|%20s|%20s|%20s|%20s|%20s|%20s|","Mã khách hành","Họ và tên khách hàng","Ngày ra hóa đơn","Quốc gia","Số lượng","Đơn giá","Thành tiền");
        for(Ngoainuoc n: listNgoainuoc)
        {
            System.out.format("\n|%20s|%20s|%20s|%20s|%20d|%20.2f|%20.2f|",n.getMakh(),n.getTenkh(),n.getNgayhd(),n.getNgayhd(),n.getQuoctich(),n.getSoluong(),n.getDongia(),n.getThanhtien());
        }
    }
    //==========================================================================
    //Tổng số lượng cho khách hành Việt Nam.
    public void SumTrongnuoc ()
    {
        int sum=0;
        for (Trongnuoc t: listTrongnuoc)
        {
            sum+=t.getSoluong();
        }
        System.out.printf("Tổng số lượng trong hóa hóa đơn Trong nước: %d", sum);
    }
    //==========================================================================
    //Tổng số lượng cho khách hàng nước ngoài.
    public void SumNgoainuoc ()
    {
        int sum=0;
        for (Ngoainuoc n: listNgoainuoc)
        {
            sum+=n.getSoluong();
        }
        System.out.printf("Tổng số lượng trong hóa hóa đơn ngoài nước: %d", sum);
    }
    //==========================================================================
    //Trung bình thành tiền của khách hành nước ngoài.
    public void avgNgoainuoc ()
    {
        double sum=0,avg;
        for (Ngoainuoc n:listNgoainuoc)
        {
            sum+=n.getThanhtien();
        }
        avg=sum/listNgoainuoc.size();
        System.out.printf("Trung bình tyanhf tiền trong hóa đơn nước ngoài: %0.2f",avg);
    }
    //==========================================================================
    //Xuất hóa đơn khách hàng việt nam trong 9/2013.
    public void timTrongnuoc () throws ParseException
    {
        String a="01/09/2013",z="30/09/2013";
        int x,y;
        DateFormat d1= new SimpleDateFormat("dd/MM/yyyy");//chuyển a sang kiểu ngày tháng.
        DateFormat d2= new SimpleDateFormat("dd/MM/yyyy");//chuyển z sang kiểu ngày tháng.
        DateFormat d3= new SimpleDateFormat("dd/MM/yyyy");//chuyển ngayhd sang kiểu ngày tháng.
        Date da= d1.parse(a);
        Date dz= d2.parse(z);
        int i;
        System.out.printf("\n|%20s|%20s|%20s|%20s|%20s|%20s|%20s|","Mã khách hành","Họ và tên khách hàng","Ngày ra hóa đơn","Đối tượng khách hàng","Số lượng","Đơn giá","Định mức","Thành tiền");
        for (Trongnuoc t:listTrongnuoc)
        {
            Date dn= d3.parse(t.getNgayhd());
            x= da.compareTo(dn);
            y= dz.compareTo(dn);
            
            if (x<=0&&y>=0)
            {
                 System.out.format("\n|%20s|%20s|%20s|%20d|%20.2f|%20d|%20.2f",t.getMakh(),t.getTenkh(),t.getNgayhd(),t.getDoitương(),t.getSoluong(),t.getDongia(),t.getDinhmuc(),t.getThanhtien());
            }
        }
    }
    //==========================================================================
    //Xuất hosd đơn khách hành nước ngoài trong 9/2013.
    public void timNgoainuoc () throws ParseException
    {
        String a="01/09/2013",z="30/09/2013";
        int x,y;
        DateFormat d1= new SimpleDateFormat("dd/MM/yyyy");//chuyển a sang kiểu ngày tháng.
        DateFormat d2= new SimpleDateFormat("dd/MM/yyyy");//chuyển z sang kiểu ngày tháng.
        DateFormat d3= new SimpleDateFormat("dd/MM/yyyy");//chuyển ngayhd sang kiểu ngày tháng.
        Date da= d1.parse(a);
        Date dz= d2.parse(z);
        int i;
        System.out.printf("\n|%20s|%20s|%20s|%20s|%20s|%20s|%20s|","Mã khách hành","Họ và tên khách hàng","Ngày ra hóa đơn","Quốc gia","Số lượng","Đơn giá","Thành tiền");
        for (Ngoainuoc n:listNgoainuoc)
        {
            Date dn= d3.parse(n.getNgayhd());
            x= da.compareTo(dn);
            y= dz.compareTo(dn);
            
            if (x<=0&&y>=0)
            {
                 System.out.format("\n|%20s|%20s|%20s|%20s|%20d|%20.2f|%20.2f|",n.getMakh(),n.getTenkh(),n.getNgayhd(),n.getNgayhd(),n.getQuoctich(),n.getSoluong(),n.getDongia(),n.getThanhtien());
            }
        }
    }
}
