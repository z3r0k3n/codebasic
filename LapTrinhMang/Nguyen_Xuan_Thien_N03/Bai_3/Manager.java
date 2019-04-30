package Bai_3;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Manager {
	private Danhsachsinhvien dsSV=new Danhsachsinhvien();
// Them sinh vien vao list
	void themSV ()
	{
		SinhVien sv1= new SinhVien("1a", "AAAA", 20);
		dsSV.themSinhVien(sv1);
		SinhVien sv2= new SinhVien("1b", "BBB", 21);
		dsSV.themSinhVien(sv2);
		SinhVien sv3= new SinhVien("1c", "CC", 22);
		dsSV.themSinhVien(sv3);
		System.out.println("Them cac sinh vien vao list thanh cong !");
		dsSV.toString();
	}
// luu list sinh vien vao file SV.dat
	void Luusinhvien ()
	{
		try {
			FileOutputStream fos= new FileOutputStream("D:\\best\\code\\codebasic\\LapTrinhMang\\Nguyen_Xuan_Thien_N03\\Bai_3\\sv.dat");
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			oos.writeObject(this.dsSV);
			oos.close();
			System.out.println("Da lu danh sach thanh cong :3");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
// Doc file SV.dat và xuat ra màn hinh
	void docSinhVien()
	{
		FileInputStream fis;
		try {
			fis = new FileInputStream("D:\\best\\code\\codebasic\\LapTrinhMang\\Nguyen_Xuan_Thien_N03\\Bai_3\\sv.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			this.dsSV= (Danhsachsinhvien) ois.readObject();
			ois.close();
			System.out.println("doc danh sach thanh cong :3");
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// Cho ma sinh vien tim sinh vien
		String timkiem (String maSV)
		{
			return dsSV.timkiem(maSV);
		}
}
