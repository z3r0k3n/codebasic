package Bai_3;

import java.io.Serializable;

public class SinhVien implements Serializable{
	private String MaSv,HovaTen;
	private int age;
	public String getMaSv() {
		return MaSv;
	}
	public void setMaSv(String maSv) {
		this.MaSv = maSv;
	}
	public String getHovaTen() {
		return HovaTen;
	}
	public void setHovaTen(String hovaTen) {
		this.HovaTen = hovaTen;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public SinhVien(String maSv, String hovaTen, int age) {
		this.MaSv = maSv;
		this.HovaTen = hovaTen;
		this.age = age;
	}
	@Override
	public String toString() {
		return "SinhVien [MaSv=" + MaSv + ", HovaTen=" + HovaTen + ", age=" + age + "]";
	}
	
}
