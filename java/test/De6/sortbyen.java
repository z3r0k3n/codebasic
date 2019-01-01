/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De6;

import java.util.Comparator;

/**
 *
 * @author ASM
 */
public class sortbyen implements Comparator<Word>{
    @Override
    public int compare (Word w1,Word w2)
    {
        return w1.getEn().compareTo(w2.getEn());
    }
}
