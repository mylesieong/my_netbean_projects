/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myles.fatcaxmlbatcher;

import java.io.*;

/**
 * FATCAXMLBatcher: an utility to read in certain XML format and build a new XML with 
 * excel file. 
 * Get Started:
 * 1.   Prepare an XML file embedding <loop id='open'/> and <loop id='close'> representing
 *      the looping part of the XML and the '$' symbol represent a variable. For 
 *      example, an example.xml would be:
 *          |   <xml header>
 *          |   <root>
 *          |       <signature>
 *          |           <author> Myles Ieong </author>
 *          |       </signature>
 *          |       <loop id="open"/>
 *          |       <branch>
 *          |           <projectname> $ </projectname>
 *          |           <style id= "$" > $ </style>
 *          |           <date> $ </date>
 *          |       </branch>
 *          |       <loop id="close"/>
 *          |   </root>
 * 2.   Parse the prepared XML with command: 
 *      >java -jar FATCAXMLBatcher.jar -parse example.xml
 *      By calling the command, FATCAXMLBatcher will generate an excel 2007 file
 *      "example-data.xlsx" at the same directory which carries below columns:
 *          ---------------------------------------------
 *          | # | projectname | style:id | style | date |
 *          ---------------------------------------------
 * 3.   Fill in the "example-data.xlsx" like below:
 *          -----------------------------------------------------
 *          | # | projectname     | style:id | style | date     |
 *          -----------------------------------------------------
 *          | 1 | FATCAXMLBacther | std      | plain | 12/01/16 |
 *          | 2 | HelloWorld      | none     | plain | 13/01/16 |
 *          -----------------------------------------------------
 * 4.   Build the final output with command: 
 *      >java -jar FATCAXMLBatcher.jar -build example-data.xlsx example.xml
 *      and a example-output.xml is built by the command with below content:
 *          |   <xml header>
 *          |   <root>
 *          |       <signature>
 *          |           <author> Myles Ieong </author>
 *          |       </signature>
 *          |       <branch>
 *          |           <projectname> FATCAXMLBacther </projectname>
 *          |           <style id="std"> plain </style>
 *          |           <date> 12/01/16 </date>
 *          |       </branch>
 *          |       <branch>
 *          |           <projectname> HelloWorld </projectname>
 *          |           <style id="none" > plain </style>
 *          |           <date> 13/01/16 </date>
 *          |       </branch>
 *          |   </root>
 * @author Myles
 */
public class FATCAXMLBatcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ArgumentsNotMatchException, FileNotFoundException {
        /**
         * Below block of code is just for debugging FATCAXMLParser, remove after test.
         */
        InputStream xmlFile = new FileInputStream("example.xml");
        Operator operator = new FATCAXMLParser (xmlFile);
        operator.work();
            
        /** Below code are tested: its for checking the input arguments from command line.
        if (FATCAXMLBatcher.validateArguments(args)==1){
            InputStream xmlFile = new FileInputStream(args[1]);
            Operator operator = new FATCAXMLParser (xmlFile);
            operator.work();
        }else if (FATCAXMLBatcher.validateArguments(args)==2){
            InputStream xlsxFile = new FileInputStream(args[1]);
            InputStream xmlFile = new FileInputStream(args[2]);
            Operator operator = new FATCAXMLBuilder (xlsxFile, xmlFile);
            operator.work();
        }else {
            throw new ArgumentsNotMatchException();
        }
        */
    }
    
    /**
     * Method validateArguments validates input arguments.
     * @param args
     * @return 0/1/2: wrong input/parse operation/build operation
     */
    private static int validateArguments(String[] args) {
        if (args.length==2 && args[0].equalsIgnoreCase("-parse") && args[1].matches("^([a-zA-Z]+-?)+[a-zA-Z0-9]+\\.[x|X][m|M][l|L]$")){
            return 1;
        }
        if (args.length==3 && args[0].equalsIgnoreCase("-build") && args[1].matches("^([a-zA-Z]+-?)+[a-zA-Z0-9]+\\.[x|X][l|L][s|S][x|X]$") && args[2].matches("^([a-zA-Z]+-?)+[a-zA-Z0-9]+\\.[x|X][m|M][l|L]$")){
            return 2;
        }
        return 0;
    }

}
