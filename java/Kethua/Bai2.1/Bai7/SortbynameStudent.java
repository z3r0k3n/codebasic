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
public class SortbynameStudent implements Comparator<Student>{
    public int compare (Student s1,Student s2)
    {
        return s1.getHoten().compareTo(s2.getHoten());
    }
}
