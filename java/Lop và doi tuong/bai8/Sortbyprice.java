/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai8;

/**
 *
 * @author ASM
 */
import java.util.Comparator;
public class Sortbyprice implements Comparator<CD>{
        public int compare (CD c1,CD c2)
        {
            if(c1.getPrice()<c2.getPrice())
                return 1;
            else
                return -1;
        }
}
