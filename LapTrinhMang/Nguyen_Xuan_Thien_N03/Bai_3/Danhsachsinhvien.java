package Bai_3;

import java.io.Serializable;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class Danhsachsinhvien implements Serializable {
	ArrayList<SinhVien> listSinhVien=new ArrayList<>();
	public boolean themSinhVien (SinhVien sinhVien)
	{
		if (this.listSinhVien.contains(sinhVien)) return false;
		else
		{
			this.listSinhVien.add(sinhVien);
			return true;
		}
	}
	
	public String toString ()
	{
		String st="";
		for (SinhVien sv:listSinhVien)
		{
			System.out.println(sv.toString());
			st+=sv.toString();
		}
		return st;
	}
	
	// Cho ma sinh vien tim sinh vien
		String timkiem (String maSV)
		{
			String kq="";
			for (SinhVien sv:listSinhVien)
			{
				if (sv.getMaSv().equals(maSV)) kq=sv.toString();
			}
			return kq;
		}
}
