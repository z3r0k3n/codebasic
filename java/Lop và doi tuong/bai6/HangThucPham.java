/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai6;

/**
 *
 * @author ASM
 */
import java.util.Date;//Để lấy ngày ở hiện tại
//Để chuyển ngày và tháng từ String-->date
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
public class HangThucPham {
    private String mahang,tenhang,nsx,hsd;
    private float gia;
//------------------------------------------------------------------------------
    //constructor có đầy đủ tham số
    HangThucPham(String a,String b,float c,String d,String e)
    {
        mahang=a;
        tenhang=b;
        gia=c;
        nsx=d;
        hsd=e;
    }
    //constructor có tham số là mã hàng.
    HangThucPham(String a)
    {
        mahang=a;
        tenhang="Không có tên.";
        gia=0;
        nsx="Không có Ngày sản xuất.";
        hsd="Không có ngày hết hạn.";
    }
//------------------------------------------------------------------------------
    //setters/getters.
    public void setMaHang(String a)
    {
        if (a == null)
            mahang="Chưa có mã";
        else
            mahang=a;
    }
    public String getMaHang()
    {
        return mahang;
    }
    public void setTenHang(String b)
    {
        if (b==null)
            tenhang="Không có tên hàng.";
        else
            tenhang=b;
    }
    public String getTenHang()
    {
        return tenhang;
    }
    public void setGia(float c)
    {
        if (c<0)
            gia=0;
        else
            gia=c;
    }
    public void setNSX(String d)
    {
        if (d==null)
            nsx="Không có ngày sản xuất.";
        else
            nsx=d;
    }
    public String getNSX()
    {
        return nsx;
    }
    public void setHSD(String e)
    {
        if(e==null)
            hsd="Không có ngày hết hạn.";
        hsd=e;
    }
    public String getHSD ()
    {
        return hsd;
    }
    public void Test () throws ParseException
    {
        Date d1=new Date();
        DateFormat d2=new SimpleDateFormat("dd/MM/yyyy");
        Date date=d2.parse(hsd);
        int i= d1.compareTo(date);
        if (i>=0)
            System.out.printf("Hết hạn sử dụng.");
        else
            System.out.printf("Còn hạn sử dụng.");
    }
//------------------------------------------------------------------------------
    public String ToString()
    {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String st="";
        st+="\nMã hàng: "+ mahang;
        st+="\nTên hàng: "+ tenhang;
        st+="\nĐơn giá: "+nf.format(gia);
        st+="\nNgày sản xuất: "+nsx;
        st+="\nNgày hết hạn: "+hsd;
        return st;
    }
}
