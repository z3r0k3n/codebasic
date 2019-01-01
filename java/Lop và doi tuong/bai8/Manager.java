/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai8;

/**
 *
 * @author ASM
 */
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Manager {
    public static Scanner in=new Scanner (System.in);
    private List<CD> CDList;
    //--------------------------------------------------------------------------
    //Thêm n CD vào danh sách;
    public void AddCD (int n)
    {
        int i;
        if (CDList == null)
            CDList=new ArrayList(){};
        for (i=0;i<n;i++)
        {
            int a = 0;
            System.out.println("Mã CD: ");
            a= in.nextInt();
            in.nextLine();//Lệnh chống trôi
            while(check(a)==true)
            {
                System.out.println("!!!!!!ID trùng, nhập lại!!!!!!");
                System.out.println("Mã CD: ");
                a= Integer.parseInt(in.nextLine());
            }
                System.out.println("Tựa CD: ");
                String b=in.nextLine();
                System.out.println("Ca sỹ: ");
                String c=in.nextLine();
                System.out.println("Số bài hát: ");
                int d=in.nextInt();
                System.out.println("Giá: ");
                double e=in.nextDouble();
                CD cd=new CD(a,b,c,d,e);
                CDList.add(cd);
                
        }
    }
    //check mã CD
    public boolean check (int n)
    {
        int i,t=0;
        for (i=0;i<CDList.size();i++)
        {
            if (CDList.get(i).getID()==n)
                return true;
        }
        return false;
                
    }
    //--------------------------------------------------------------------------
    //Tính Số lượng CD có trong giá sách.
    public int totalcd()
        {
            return CDList.size();
        }
    //--------------------------------------------------------------------------
    //Tính tổng giá thành của các CD.
    public double totalprice()
    {
        double gia=0;
        for (int i=0;i<CDList.size();i++)
        {
            gia+=CDList.get(i).getPrice();
        }
        return gia;
    }
    //--------------------------------------------------------------------------
    //Sắp sếp danh sách giảm dần  theo giá thành.
    public void SortbyPriace()
    {
        Collections.sort(CDList,new Sortbyprice());
    }
    //--------------------------------------------------------------------------
    //Sắp sếp Xuất toàn bộ danh sách
    public void SortbyName()
    {
        Collections.sort(CDList,new Sortbyname());
    }
    //--------------------------------------------------------------------------
    //Show toàn bộ danh sách.
    public void show ()
    {
        System.out.printf("%8s|%30s|%25s|%20s|%10s|","Mã CD","Tựa CD","Ca sỹ","Số bài hát","giá");
        for (CD cd:CDList)
        {
            System.out.format("\n%8d|%30s|%25s|%20d|%10.2f|", cd.getID(),cd.getName(),cd.getSinger(),cd.getNumberSongs(),cd.getPrice());
        }
    }
}
