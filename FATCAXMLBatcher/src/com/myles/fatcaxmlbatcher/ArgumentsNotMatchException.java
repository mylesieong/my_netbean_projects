/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myles.fatcaxmlbatcher;

/**
 *
 * @author Myles
 */
class ArgumentsNotMatchException extends Exception {
    public ArgumentsNotMatchException() {
        super("Arguments do not match pattern:\nParse oeration: >java FATCAXMLBatcher -parse {filename}.xml\nBuild operation:>java FATCAXMLBatcher -build {filename}.xlsx {filename}.xml");     
    }
    
    
}
