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
public class SortbynameCustomer implements Comparator<Customer>{
    public int compare (Customer c1,Customer c2)
    {
        return c1.getHoten().compareTo(c2.getHoten());
    }
}
