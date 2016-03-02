/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfactoryimplementation;
import java.lang.reflect.*;
import static java.lang.System.out;
import java.io.*;
/**
 *
 * @author Myles
 * This is a Factory Implementation according to the Design Pattern Specification.
 * Class Factory is a factory design pattern implemenation which can call by 
 * Clients to create Product1, Product2, Product3.
 */
public class Factory {

    public Product create(String productClassName) {
       try{
           Product p;
           Class cl=Class.forName("myfactoryimplementation."+productClassName);
           p=(Product)cl.newInstance();
           System.out.println(cl+" created.");
           return p;
       }catch(Exception e){
           System.out.println(e);
           return null;
       }
           
    }
    
}
