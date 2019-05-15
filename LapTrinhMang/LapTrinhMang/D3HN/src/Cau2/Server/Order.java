/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2.Server;

import java.io.Serializable;

/**
 *
 * @author Zero Ken
 */
public class Order implements Serializable{
    private String user,pass;
    private boolean kq;

    public boolean isKq() {
        return kq;
    }

    public void setKq(boolean kq) {
        this.kq = kq;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
