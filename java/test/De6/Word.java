/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De6;

/**
 *
 * @author ASM
 */
public class Word {
    private String id,en,vn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public Word() {
        this.id = "";
        this.en = "";
        this.vn = "";
    }

    public Word(String id, String en, String vn) {
        this.id = id;
        this.en = en;
        this.vn = vn;
    }

    @Override
    public String toString() {
        String st="";
        st+="\n|\t"+this.id+"|\t"+this.en+"|\t"+this.vn+"|";
        return st;
    }
    
    
}
