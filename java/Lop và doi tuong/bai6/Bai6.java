/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai6;

import java.text.ParseException;

/**
 *
 * @author ASM
 */
public class Bai6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        HangThucPham htp= new HangThucPham("111111");
        
        htp.Test();
        System.out.println(htp.ToString());
        
    }
    
}
