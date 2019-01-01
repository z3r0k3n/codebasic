/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De6;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ASM
 */
public class timkiemnhiphan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Word> listWord=new ArrayList<>();
        Word w1=new Word("01", "angel", "Thiên Thần");
        listWord.add(w1);
        Word w2=new Word("02", "boss", "Ông chủ");
        listWord.add(w2);
        Word w3=new Word("03", "car", "Ô tô");
        listWord.add(w3);
        Word w4=new Word("04", "dad", "Bố");
        listWord.add(w4);
        Word w5=new Word("05", "egg", "Trứng");
        listWord.add(w5);
        Word w6=new Word("06", "fly", "Bay");
        listWord.add(w6);
        Word w7=new Word("07", "good", "tốt");
        listWord.add(w7);
        Word w8=new Word("08", "hi", "Xin chào");
        listWord.add(w8);
        Word w9=new Word("09", "i", "Tôi");
        listWord.add(w9);
        Word w10=new Word("10", "key", "chìa khóa.");
        listWord.add(w10);
        Collections.sort(listWord,new sortbyen());
        for (Word w: listWord)
        {
            System.out.println(w.toString());
        }
        int dau=0,cuoi=listWord.size(),giua;
        String test="",key="jappan";
        do
        {
            giua=(dau+cuoi)/2;
            test=listWord.get(giua).getEn();
            if (key.compareTo(test)==0)
            {
                System.out.println(listWord.get(giua).getVn());
                break;
            }
            else if(key.compareTo(test)>0)
                dau=giua;
            else
                cuoi=giua;
        }while ((cuoi-dau)!=1);
    }                                           
    
}
