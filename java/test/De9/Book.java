/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De9;

import java.io.Serializable;

/**
 *
 * @author ASM
 */
public class Book implements Serializable{
    private String id,authors,title,category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Book() {
        this.id = "";
        this.authors = "";
        this.title = "";
        this.category = "";
    }

    public Book(String id, String authors, String title, String category) {
        this.id = id;
        this.authors = authors;
        this.title = title;
        this.category = category;
    }

    @Override
    public String toString() {
        String st="";
        st+="\n|\t\t"+this.id+"|\t\t"+this.authors+"|\t\t"+this.title+"|\t\t"+this.category+"|";
        return st;
    }
    
}
