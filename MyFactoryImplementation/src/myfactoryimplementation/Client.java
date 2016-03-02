/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfactoryimplementation;
import java.util.*;
/**
 * This is a Concept of "Factory design pattern" Implementation Application
 * @author Myles
 * Class Client is the Main Class. It tries to call Factory to build different 
 * Products.
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        * Create a factory instance.
        */
        Factory factory= new Factory();
        ArrayList<Product> productList=new ArrayList<Product>();
        
        /*
        * Create 5 product1 instance.
        */
        for (int i=0;i<5;i++){
            productList.add(factory.create("Product1"));
        }
        
        /*
        * Create 5 product2 instance.
        */
        for (int i=0;i<5;i++){
            productList.add(factory.create("Product2"));
        }
        
        /*
        * Create 5 product3 instance.
        */
        for (int i=0;i<5;i++){
            productList.add(factory.create("Product3"));
        }        
        
        /*
        * Iterate and display products in productList.
        */
        for (int i=0;i<15;i++){
            System.out.println(productList.get(i).display());
        }
        
    }
    
}
