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
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class Manager {
    public static Scanner in=new Scanner(System.in);
    private List<SinhVien> SVList;
/*    Manager ()
    {
        
    }
*/
    //--------------------------------------------------------------------------
    //Thêm sinh viên mới.
    public void addSV(int n)
    {
        if(SVList==null)
            SVList=new ArrayList() {};
        int i;
        for (i=0;i<n;i++)
        {
            System.out.println("Nhập mã sinh viên: ");
            int a=in.nextInt();
            System.out.println("Nhập tên sinh viên: ");
            String b=in.next();
            System.out.println("Nhập địa chỉ sinh viên: ");
            String c=in.next();
            System.out.println("Nhập số điện thoại sinh viên: ");
            int d=in.nextInt();
            SinhVien sv=new SinhVien(a,b,c,d);
            SVList.add(sv);
        }
    }
    //--------------------------------------------------------------------------
    public void Show()
    {
        //Sắp xếp lại danh sách sinh viên.
        Collections.sort(SVList,new SapXep());
        //show danh sách sinh viên theo danh sách.
        System.out.printf ("%10s|%30s|%25s|%10s","Code","Name","Address","Phone");
        for (SinhVien sv: SVList)
        {
            System.out.format("\n%10d|%30s|%25s|%10d",sv.getMaSV(),sv.getName(),sv.getDC(),sv.getSDT());
        }
    }
}
