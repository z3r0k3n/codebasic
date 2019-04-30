
public class sinhvien {
	private int masv;
	private String hoTen;
	private int tuoi;
	public int getMasv() {
		return masv;
	}
	public void setMasv(int masv) {
		this.masv = masv;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public sinhvien(int masv, String hoTen, int tuoi) {
		super();
		this.masv = masv;
		this.hoTen = hoTen;
		this.tuoi = tuoi;
	}
	
}
