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
 * This subclass of Exception is used as a messager to return the concrete 
 * reason of throwing an Exception.
 */
public class RequestInstanceFailureException extends Exception{
    /*
    * Package the msg into the class.
    */
    public String toString(){
        return "Fail to get instance from calling Class Constructor";
    }
}
