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
import java.util.ArrayList;
public class Manager {
    ArrayList<Xenoi> listXenoi=new ArrayList<>();
    ArrayList<Xengoai> listXengoai=new ArrayList<>();
    
    public void Input ()
    {
        Xenoi xn1=new Xenoi("12k1", "Trần Văn Thảo", "12k4572", 3, 600.2, 12000000);
        listXenoi.add(xn1);
        Xenoi xn2=new Xenoi("34h5", "Phạm Quang Minh", "82h123", 1, 500, 5000000);
        listXenoi.add(xn2);
        Xenoi xn3=new Xenoi("45d3", "Đỗ Văn Thành", "45x098", 7, 45.2, 1000000);
        listXenoi.add(xn3);
        
        Xengoai xnn1=new Xengoai("111kj", "Nguyễn Thịnh", "42h123", "Thanh hóa", 2, 40000000);
        listXengoai.add(xnn1);
        Xengoai xnn2=new Xengoai("222gh", "Đoàn Cường", "ht34543", "Bình Phước", 3, 700000000);
        listXengoai.add(xnn2);
        Xengoai xnn3=new Xengoai("333qw", "Nguyễn Văn Đạt", "43h3423", "Sài gòn", 1, 10000000);
        listXengoai.add(xnn3);
    }
    public void output()
    {
        System.out.println("Danh sách chuyến xe nội:");
        for(Xenoi xn:listXenoi)
            System.out.println(xn.toString());
        System.out.println("Danh sách chuyến xe ngoại:");
        for(Xengoai xnn:listXengoai)
            System.out.println(xnn.toString());
    }
    public void Tonhdoanhthu()
    {
        double x=0,y=0;
        for(Xenoi xn:listXenoi)
            x+=xn.getDoanhthu();

        System.out.printf("\nTổng doanh thu xe nội: %.2f",x);
        for(Xengoai xnn:listXengoai)
            y+=xnn.getDoanhthu();
        System.out.printf("\nTổng doanh thu xe ngoại: %.2f",y);
    }
}
