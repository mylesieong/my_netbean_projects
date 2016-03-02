/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myprototypeimplementation;

/**
 * This is a Concept of "Singleton design pattern" Implementation Application
 * @author Myles
 * Class Client is the Main Class. It tries to instancize a Prototype more than 
 * once.
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        * Create Client Instance
        */
        Client c=new Client();

        /*
        * Client Intance call Prototype static method "getPrototype"
        */
        try{
            Prototype prototype1= c.getPrototypeInstance();
        }catch(Exception e){
            System.out.println(e);
        }
        
        /*
        * Client instance try to call Prototype Constructor and get an Exception
        */
        try{
            Prototype prototype2= c.getPrototypeInstance();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    /**
     * A Client method to get Prototype Instance
     */
    public Prototype getPrototypeInstance() throws Exception{
        try{
            return new Prototype();
        }catch(Exception e){
            throw e;
        }
    }
}
