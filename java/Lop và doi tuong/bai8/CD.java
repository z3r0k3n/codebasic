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
public class CD {
    private int ID,NumberSongs;
    private String Name,Singer;
    double Price;
    public void setID(int a)
    {
        this.ID=a;
    }
    public int getID()
    {
        return ID;
    }
    public void setName (String b)
    {
        this.Name=b;
    }
    public String getName ()
    {
        return Name;
    }
    public void setSinger(String c)
    {
        this.Singer=c;
    }
    public String getSinger ()
    {
        return Singer;
    }
    public void setNumberSongs(int d)
    {
        this.NumberSongs=d;
    }
    public int getNumberSongs ()
    {
        return NumberSongs;
    }
    public void setPrice (double e)
    {
        this.Price=e;
    }
    public double getPrice ()
    {
        return Price;
    }
    //--------------------------------------------------------------------------
    CD()
    {
        this.ID=0;
        this.Name="EMPTY";
        this.Singer="EMPTY";
        this.NumberSongs=0;
        this.Price=0;
    }
    CD(int a,String b,String c,int d,double e)
    {
        this.ID=a;
        this.Name=b;
        this.Singer=c;
        this.NumberSongs=d;
        this.Price=e;
    }
    //--------------------------------------------------------------------------
    public String ToString ()
    {
        String st="";
        st+="\nMã CD: " +ID;
        st+="\nTựa CD: "+Name;
        st+="\nCa sỹ: "+Singer;
        st+="\nSố bài hát: "+NumberSongs;
        st+="\nGiá: "+Price;
        return st;
    }
    
}
