/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

/**
 *
 * @author ASM
 */
public class hinhchunhat {
    private int dai;
    private int rong;
    
    public void setDai (int d)
    {
        dai=d;
    }
    public int getDai ()
    {
        return dai;
    }
    public void setRong (int r)
    {
        rong = r;
    }
    public int getRong ()
    {
        return rong;
    }
    public float DienTich ()
    {
        float dt=dai*rong;
        return dt;
    }
    public float ChuVi ()
    {
        float cv=(dai + rong)*2;
        return cv;
    }
    public String ToString ()
    {
        String st="";
        st+="\n Chiều Dài: "+dai;
        st+="\n Chiều Rộng: "+rong;
        st+="\n Diện Tích: "+DienTich();
        st+="\n Chu Vi"+ ChuVi();
        return st;
    }
}