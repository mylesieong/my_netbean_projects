/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myprototypeimplementation;

import java.util.ArrayList;

/**
 * This is a Concept of "Prototype design pattern" Implementation Application
 * @author Myles
 * Method Client.main() will create new object according to the prototype class Prototype.
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Prototype prototype= new Prototype(); //create a new prototype object
        ArrayList<Product> productList=new ArrayList<Product>();
        /**
         * Create 10 product by cloning the prototype and set their ProductID
         */
        for (int i=0; i<10;i++){           
            Product p=new Product(prototype);
            p.setProductID(i);
            productList.add(p);
        }
        /**
         * Output the items in productList
         */
        for (Product temp:productList){
            System.out.println(temp.getProductID());
        }
        
    }
    
}
