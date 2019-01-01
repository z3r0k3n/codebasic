/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASM
 */
public class Docfile {
    
Skip to content

    Why GitHub?
                          


                    
Business
Explore
                      

                    
Marketplace
Pricing
                       


                        

Sign in
Sign up

0
0

    1

langocson8125/up-github
Code
Issues 0
Pull requests 0
Projects 0
Insights
Join GitHub today

GitHub is home to over 28 million developers working together to host and review code, manage projects, and build software together.
up-github/JavaTrainging/Homework02/ThongTinSinhVien/QuanLySinhVien.java
c7756a1 2 days ago
@langocson8125 langocson8125 Add files via upload
52 lines (42 sloc) 1.27 KB
package GiaiDe1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QuanLySinhVien {
	private List<SinhVien> listSinhVien;
	
	public QuanLySinhVien() {
		this.listSinhVien = new ArrayList<>();
	}

	public List<SinhVien> getListSinhVien() {
		return listSinhVien;
	}

	public void setListSinhVien(List<SinhVien> listSinhVien) {
		this.listSinhVien = listSinhVien;
	}
	
	public void readFileData() {
		try {
			List<String> allLines = Files.readAllLines(Paths.get("F:\\JAVA\\JAVA_TRAINING\\src\\GiaiDe1\\sinhvien.dat"));
			for (String line : allLines) {
				this.listSinhVien.add(this.convertLineDataToSinhVienObject(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public  SinhVien convertLineDataToSinhVienObject(String lineData) {
		String[] parts = lineData.split("\\$");
		return new SinhVien(parts[0], parts[1], parts[2], Boolean.parseBoolean(parts[3]), parts[4], parts[5], Float.valueOf(parts[6]));
	}
	
	public void ShowSinhVien() {
		if(!this.listSinhVien.isEmpty()) {
			for(SinhVien SV : listSinhVien) {
				System.out.println(SV.toString());
			}
		}
		else {
			System.out.println("Danh sach rong");
		}
	}

}

    © 2018 GitHub, Inc.
    Terms
    Privacy
    Security
    Status
    Help

    Contact GitHub
    Pricing
    API
    Training
    Blog
    About

Press h to open a hovercard with more details.

}
