/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myles.fatcaxmlbatcher;

import java.io.*;

/**
 *
 * @author Myles
 */
public class FATCAXMLBuilder implements Operator {
    InputStream xlsxFile;
    InputStream xmlFile;
    public FATCAXMLBuilder(InputStream xlsxFile, InputStream xmlFile) {
        this.xlsxFile=xlsxFile;
        this.xmlFile=xmlFile;
    }

    @Override
    public void work() {
        System.out.println("work in FATCAXMLBuilder.");
    }
    
}
