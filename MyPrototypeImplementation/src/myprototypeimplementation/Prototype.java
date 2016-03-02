/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myprototypeimplementation;

/**
 * This is a Prototype Desgin Pattern Implementation. This Prototype class will inmplemente
 * the Cloneable interface so that when we call Object.clone(), it wont throw Exception
 * to client.
 * @author Myles
 */
class Prototype implements Cloneable {
    @Override
    public Prototype clone() throws CloneNotSupportedException {
        Prototype p=null;
        try{
            p=(Prototype)super.clone();
        }catch(Exception e){
            e.printStackTrace();
        }
        return p;
    } 
}
