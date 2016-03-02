/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myles.fatcaxmlbatcher;

import java.io.*;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.poi.hssf.model.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * FATCAXMLParser parse the XML file and generate an Excel File contains element name in the 
 * first row of the sheet as these element involved with "$".
 * @log 2016-01-14 To be finish at:
 *      1. Iterate the xml document 
 *      2. import the latest POI package
 *      3. change from hashmap to linear map
 * @author Myles
 */
public class FATCAXMLParser implements Operator{
    InputStream xmlFile;
    public FATCAXMLParser(InputStream xmlFile) {
        this.xmlFile=xmlFile;
    }

    @Override
    public void work(){
        try {
            /**
             * Create Document & parse XML with DOM
             */
            DocumentBuilderFactory documentBuilderFactory=DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder=documentBuilderFactory.newDocumentBuilder();
            Document document=documentBuilder.parse(xmlFile);
            
            /**
             * Get Nodes into HashMap in format of <"node", Node> which stands for Nodes with $ as Value
             * and <"attr", Node> which stands for Nodes with $$ in its attribute.
             */
            HashMap<String,Element> map=new HashMap<String, Element>();
            Element rootElement=document.getDocumentElement();
            for (int i=0;i<5;i++){
                map.put("node", rootElement);
            }
            
            /**
             * Output a excel file according to map, wrong version of POI
             */
            Workbook workbook=new XSSFWorkbook();
            Sheet sheet=workbook.createSheet("data");
            Row row=sheet.createRow((short)1);
            for (int i=0;i<5;i++){
                row.createCell(i).setCellValue(map.get("node"));
            }
            FileOutputStream outputFile=new FileOutputStream("output.xls");
            workbook.write(outputFile);
            outputFile.close();
            
            
        } catch (Exception ex) {
            Logger.getLogger(FATCAXMLParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
