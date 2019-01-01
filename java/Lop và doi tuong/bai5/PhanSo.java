/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai5;

/**
 *
 * @author ASM
 */
public class PhanSo {
    private int numerator;
    private int denominator;
//------------------------------------------------------------------------------
    PhanSo ()
    {
        numerator=0;
        denominator=1;
    }
    PhanSo (int a,int b)
    {
        numerator=a;
        denominator=b;
    }
//------------------------------------------------------------------------------
    public void setNumerator (int a)
    {
        numerator=a;
    }
    
    public int getNumerator ()
    {
        return numerator;
    }
//------------------------------------------------------------------------------
    public void setDenominator (int b)
    {
        denominator=b;
    }
    
    public int getdenominator()
    {
        return denominator;
    }
//------------------------------------------------------------------------------
    public void Reduce ()//tối giản phân số
    {
        int i,t=0;
        //tìm ước chung lớn nhất.
        for (i=1;i<=numerator;i++)
        {
            if (numerator%i==0&&denominator%i==0)
            {
                t=i;
            }
        }
        if (t!=0)
        {
            numerator/=t;
            denominator/=t;
        }
    }
//------------------------------------------------------------------------------
    public void Reciprocal () //nghịch đảo phân số
    {
        numerator+=denominator;
        denominator=numerator-denominator;
        numerator-=denominator;
    }
//------------------------------------------------------------------------------
    public void Add (int n,int d)//cộng 2 phân số
//n là tử số của phân số thứ 2, m là mẫu số của phân số chứ 2
    {
        //trường hợp cùng mẫu số thì cộng 2 tử số lại cho nhau
        if (d==denominator)
        {
            numerator+=n;
        }
        //Trường hợp 2 mẫu số khác nhau thì quy đồng trước. 
        else
        {
            numerator=numerator*d+n*denominator;
            denominator *=d;
        }
        //tối giản kết quả
        Reduce();
    }
//------------------------------------------------------------------------------
    public void Subtract (int n,int d)//Trừ 2 phân số
    {
        //n và d tương tự như Add. cách làm tương tự như Add thay + thành -
         if (d==denominator)
        {
            numerator-=n;
        }
        else
        {
            numerator=numerator*d-n*denominator;
            denominator *=d;
        }
        Reduce();
    }
//------------------------------------------------------------------------------
    public void Multiply (int n,int d)//Nhân 2 phân số.
    {
        numerator*=n;
        denominator*=d;
        Reduce();
    }
//------------------------------------------------------------------------------
    public void  Divide (int n, int d)// Chia 2 số.
    {
        numerator*=d;
        denominator*=n;
        Reduce();
    }
//------------------------------------------------------------------------------
//Làm tròn đến chữ số thập phân thứ 4
    public double Round (double n)
    {
        n*=Math.pow(10,4);
            return Math.floor(n+0.5)/Math.pow(10,4);// hàm floor(x) ko làm chòn đến số nguyên gân nhất bé hơn x
    }
            
//so sánh 2 phân số
    public void Compare (int n, int d)
    {
        //trường hợp 2 số có cùng mẫu số
        if (d==denominator)
        {
            if (numerator>n)
                System.out.printf ("Phân số %d/%d lớn hơn %d/%d.",numerator,denominator,n,d);
            if (numerator<n)
                System.out.printf ("Phân số %d/%d nhỏ hơn %d/%d.",numerator,denominator,n,d);
            if (numerator==n)
                System.out.printf ("Phân số %d/%d bằng %d/%d.",numerator,denominator,n,d);     
        }
        //Trường hợp 2 số ko cùng mẫu thì so sánh đến sai số 0.0001
        else
        {
            //Đưa về dạng số thập phân
            double x=Round(numerator/denominator);
            double y=Round(n/d);
            if (x>y)
                System.out.printf ("Phân số %d/%d lớn hơn %d/%d.",numerator,denominator,n,d);
            if (x<y)
                System.out.printf ("Phân số %d/%d nhỏ hơn %d/%d.",numerator,denominator,n,d);
            if (x==y)
                System.out.printf ("Phân số %d/%d bằng %d/%d.",numerator,denominator,n,d);
        }
    }
    public String ToString ()
    {
        String st="";
        //Tử số bằng mẫu số thì kết quả là 1.
        if (numerator==denominator)
            st+="\n Kết quả: 1";
        //Tử số khác mẫu số
        else
        {
            st+="\n Kết quả: " + numerator + "/" + denominator;
        }
        return st;
            
    }
}
