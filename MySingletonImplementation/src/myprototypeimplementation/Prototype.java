/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myprototypeimplementation;
import java.io.*;

/**
 *
 * @author Myles
 * This is a Prototype Implementation according to the Design Pattern Specification.
 * Class Prototype is a prototype design pattern implemenation which can only con-
 * struc once.
 */
public class Prototype {
    /*
    * The unified Prototype instance
    */
    static private Prototype p;
    
    /**
    * The constructor is public but when it is called once, static attribute is 
    * set to the created instance, if client call this public constructor again,
    * it will throw an exeption.
    */
    public Prototype() throws Exception {
        if (Prototype.p==null){
            System.out.println("Creating Prototype Instance");
            p=this;         //set p = this, so p is not null anymore.
        }else{
            throw new RequestInstanceFailureException();
        }
    }  
}