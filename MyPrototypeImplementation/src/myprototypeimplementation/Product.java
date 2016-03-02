/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myprototypeimplementation;

/**
 *This class has a constructor which can construct the class with a Prototype argument. It has 
 * an internal property ProductID with Getter and Setter as well.
 * @author Myles
 */
class Product {
    public int productID;          //Declare the productID
    public Prototype productCore;  //Declare the productCore
    /**
     * This Constructor built the object with Prototype Object
    */
    public Product(Prototype p){
        try{
            this.productCore=p.clone();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * Ths method returns the productID
     */
    public int getProductID(){
        return this.productID;
    }
    
    /**
     * Ths method sets the productID
     */
    public void setProductID(int i){
        this.productID=i;
    }    
    
}
