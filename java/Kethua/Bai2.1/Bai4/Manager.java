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
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Scanner;
import java.util.ArrayList;
public class Manager {
    public static Scanner in=new Scanner(System.in);
    private ArrayList<Dat> listDat=new ArrayList();
    private ArrayList<Nha> listNha=new ArrayList();
    //==========================================================================
    //1.Nhập các giao dịch đất.
    public void inputDat()
    {
        int i,n;
        System.out.println("Số lượng giao dịch bạn muốn nhập: ");
        n=in.nextInt();
        for (i=0;i<n;i++)
        {
            System.out.println("Mã giao dich: ");
            String a=in.nextLine();
            System.out.println("Ngày giao dịch: ");
            String b=in.nextLine();
            System.out.println("Đơn giá: ");
            double c=in.nextDouble();
            String d=Loaidat();
            System.out.println("Diện tích: ");
            double e=in.nextDouble();
            Dat s=new Dat (d,a,b,e,c);
            listDat.add(s);
        }
    }
    //Loại đất
    public String Loaidat ()
    {
        int x;
        String y="";
        do
        {
        System.out.println("Loại đất: \n1: A\n2: B\n3: C");
        x=in.nextInt();
        switch (x)
        {
            case 1:
                y="A";
                break;
            case 2:
                y="B";
                break;
            case 3:
                y="C";
                break;
            default:
                System.out.println("!!!!!Loại đất bạn chọn ko có.!!!!!");
                break;
        }
        }
        while (x!=1 && x!=2 && x!=3);
        return y;
    }
    //==========================================================================
    //2.Nhập các giao dịch nhà.
        public void inputNha()
    {
        int i,n;
        System.out.println("Số lượng giao dịch bạn muốn nhập: ");
        n=in.nextInt();
        for (i=0;i<n;i++)
        {
            System.out.println("Mã giao dich: ");
            String a=in.nextLine();
            System.out.println("Ngày giao dịch: ");
            String b=in.nextLine();
            System.out.println("Đơn giá: ");
            double c=in.nextDouble();
            String d=Loainha();
            System.out.println("Địa chỉ: ");
            String e=in.nextLine();
            System.out.println("Diện tích: ");
            double f=in.nextDouble();
            Nha s=new Nha (d,e,a,b,f,c);
            listNha.add(s);
        }
    }
    //Loại nhà
        public String Loainha()
        {
            int x;
            String y="";
            do
            {
                System.out.println("Loại nhà \n1: Cao cấp.\n2: Thường.");
                x=in.nextInt();
                switch (x)
                {
                    case 1:
                        y="Cao cấp.";
                        break;
                    case 2:
                        y="Thường.";
                        break;
                    default:
                        System.out.println("!!!!!Loại nhà bạn chọn ko có!!!!!");
                        break;
                }
            }
            while (x!=1&&x!=2);
            return y;
        }
    //==========================================================================
    //3.Xuất các giao dịch đất.
    public void outputDat()
    {
        System.out.printf("\n|%20s|%20s|%20s|%20s|%20s|%20s|","Mã giao dịch","Ngày giao dịch","Đơn giá","Loại đất","Diện tích","Thành tiền");
        for (Dat d:listDat)
        {
            System.out.format("\n|%20s|%20s|%20.2f|%20s|%20.2f|%20.2f|",d.getMagd(),d.getNgaygd(),d.getDongia(),d.getLoaidat(),d.getDientich(),d.getThanhtien());
        }
    }
    //==========================================================================
    //4.Xuất các giao dịch nhà.
    public void outputNha()
    {
        System.out.printf("\n|%20s|%20s|%20s|%20s|%20s|%20s|%20s|","Mã giao dịch","Ngày giao dịch","Đơn giá","Loại nhà","Địa chỉ","Diện tích","Thành tiền");
        for (Nha n:listNha)
        {
            System.out.format("\n|%20s|%20s|%20.2f|%20s|%20s|%20.2f|%20.2f|",n.getMagd(),n.getNgaygd(),n.getDongia(),n.getLoainha(),n.getDiachi(),n.getDientich(),n.getThanhtien());
        }
    }
    //==========================================================================
    //5.Tính tổng số diện tích cho giao dịch đất.
    public void sumDat()
    {
        double sum=0;
        int i;
        for (i=0;i<listDat.size();i++)
        {
            sum+=listDat.get(i).getDientich();
        }
        System.out.printf("Tổng số diện tích đất đã giao dịch: %.2f", sum);
    }
    //==========================================================================
    //6.Tính tổng số diện tích cho giao dịch nhà.
    public void sumNha()
    {
        double sum=0;
        int i;
        for (i=0;i<listNha.size();i++)
        {
            sum+=listNha.get(i).getDientich();
        }
        System.out.printf("Tổng số diện tích nhà đã giao dịch: %.2f", sum);
    }
    //==========================================================================
    //6.Tính trung bình thành tiền của giao dịch đất.
    public void avgDat()
    {
        double avg,sum=0;
        int i;
        for (i=0;i<listDat.size();i++)
        {
            sum+=listDat.get(i).getThanhtien();
        }
        avg=sum/listDat.size();
    }
    //==========================================================================
    //7.Xuất các giao dịch đất của tháng 9/2013.
    public void timDat () throws ParseException
    {
        String a="01/09/2013",z="30/09/2013";
        int x,y;
        DateFormat d1= new SimpleDateFormat("dd/MM/yyyy");//chuyển a sang kiểu ngày tháng.
        DateFormat d2= new SimpleDateFormat("dd/MM/yyyy");//chuyển z sang kiểu ngày tháng.
        DateFormat d3= new SimpleDateFormat("dd/MM/yyyy");//chuyển ngaygd sang kiểu ngày tháng.
        Date da= d1.parse(a);
        Date dz= d2.parse(z);
        int i;
        System.out.printf("\n|%20s|%20s|%20s|%20s|%20s|%20s|","Mã giao dịch","Ngày giao dịch","Đơn giá","Loại đất","Diện tích","Thành tiền");
        for (i=0;i<listDat.size();i++)
        {
            Date dn= d3.parse(listDat.get(i).getNgaygd());
            x= da.compareTo(dn);
            y= dz.compareTo(dn);
            
            if (x<=0&&y>=0)
            {
                 System.out.format("\n|%20s|%20s|%20.2f|%20s|%20.2f|%20.2f|",listDat.get(i).getMagd(),listDat.get(i).getNgaygd(),listDat.get(i).getDongia(),listDat.get(i).getLoaidat(),listDat.get(i).getDientich(),listDat.get(i).getThanhtien());
            }
        }
    }
    //==========================================================================
    //8.Xuất các giao dịch nhà của tháng 9/2013.
    public void timNha () throws ParseException
    {
        String a="01/09/2013",z="30/09/2013";
        int x,y;
        DateFormat d1= new SimpleDateFormat("dd/MM/yyyy");//chuyển a sang kiểu ngày tháng.
        DateFormat d2= new SimpleDateFormat("dd/MM/yyyy");//chuyển z sang kiểu ngày tháng.
        DateFormat d3= new SimpleDateFormat("dd/MM/yyyy");//chuyển ngaygd sang kiểu ngày tháng.
        Date da= d1.parse(a);
        Date dz= d2.parse(z);
        int i;
        System.out.printf("\n|%20s|%20s|%20s|%20s|%20s|%20s|%20s|","Mã giao dịch","Ngày giao dịch","Đơn giá","Loại nhà","Địa chỉ","Diện tích","Thành tiền");
        for (i=0;i<listNha.size();i++)
        {
            Date dn= d3.parse(listNha.get(i).getNgaygd());
            x= da.compareTo(dn);
            y= dz.compareTo(dn);
            
            if (x<=0&&y>=0)
            {
                 System.out.format("\n|%20s|%20s|%20.2f|%20s|%20s|%20.2f|%20.2f|",listNha.get(i).getMagd(),listNha.get(i).getNgaygd(),listNha.get(i).getDongia(),listNha.get(i).getLoainha(),listNha.get(i).getDiachi(),listNha.get(i).getDientich(),listNha.get(i).getThanhtien());
            }
        }
    }
}
