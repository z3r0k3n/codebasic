/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

/**
 *
 * @author ASM
 */
import java.util.Scanner;
public class Testcase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Hinhchunhat hcn=new Hinhchunhat();
        Scanner in= new Scanner (System.in);
        System.out.println("Nhập chiều dai: ");
        hcn.setDai(in.nextDouble());
        System.out.println("Nhập chiều rộng: ");
        hcn.setRong(in.nextDouble());
        hcn.setCv();
        hcn.setDt();
        System.out.println(hcn.toString());
    }   
}
