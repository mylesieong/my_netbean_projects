/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demohibernate4;

/**
 *
 * @author Myles
 */
public class CigarNews {
    private int id;
    private String news;
    
    /* Constructor*/
    public CigarNews(){
        this.news="Blank";
    }
    public CigarNews(String news){
        this.news=news;
    }
    
    /* Getters*/
    public int getId(){
        return this.id;
    }
    public String getNews(){
        return this.news;
    }
    
    /* Setters*/
    public void setId(int id){
        this.id=id;
    }
    public void setNews(String news){
        this.news=news;
    }

}
