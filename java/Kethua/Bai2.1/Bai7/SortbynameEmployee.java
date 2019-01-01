/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai7;

import java.util.Comparator;

/**
 *
 * @author ASM
 */
public class SortbynameEmployee implements Comparator<Employee>{
    public int compare (Employee e1,Employee e2)
    {
        return e1.getHoten().compareTo(e2.getHoten());
    }
}
