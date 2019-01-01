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
import java.util.Comparator;
public class SapXep implements Comparator<SinhVien>{
    public int compare (SinhVien sv1, SinhVien sv2)
    {
     if (sv1.getMaSV()>sv2.getMaSV())
         return 1;
     else 
         return -1;
    }
}
