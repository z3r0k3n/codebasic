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
public class Sortbyname implements Comparator<CD>{
    public int compare (CD c1,CD c2)
    {
        return c1.getName().compareTo(c2.getName());
    }
}
