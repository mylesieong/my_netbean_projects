/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demofileinputstream;

import java.io.*;
import java.util.ArrayList;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * This is a demo application of FileInputStream. The client has 4 method present following 
 * feature:
 * 1. countFileSize: count the file size using InputStream
 * 2. copyFile: copy file to a new created file using OutputStream
 * 3. encryptFile: use the BASE64Encoder as an encryptor to encrypt a file(change the content).
 * 4. decryptFile: use the BASE64Decoder as an decryptor to decrypt a file(change the content).
 * @author Myles
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileAddress = "task.txt";
        System.out.println("The file size is: "+ Client.countFileSize(fileAddress));
        Client.copyFile(fileAddress, "output.txt");
        Client.encryptFile(fileAddress, "encryted.txt");
        Client.decryptFile( "encryted.txt","decrypted.txt");
        
    }
    
    /**
     * Iterate a gven file using FileInputStream instance and count the bytes.
     * @param fileAddress 
     * @return int bytes size of file
     */
    private static int countFileSize(String fileAddress) throws FileNotFoundException, IOException {
        InputStream in=new FileInputStream(fileAddress);
        int result=0;
        while(true){
            int i=in.read();
            if(i!=-1){
                result++;
            }else{
                break;
            }
        }
        in.close();
        return result;
    }    
    
    /**
     * Use input/output stream to copy an txt file to a new txt file in the same direcotry
     * @param inputAddress
     * @param outputAddress
     * @throws FileNotFoundException, IOException 
     */
    private static void copyFile(String inputAddress, String outputAddress) throws FileNotFoundException, IOException {
        //Sudden challenge: use input/output stream to copy an txt file to a new txt file in the same direcotry
        InputStream in=new FileInputStream(inputAddress);
        OutputStream out= new FileOutputStream(outputAddress);
        while(true){
            int i=in.read();
            out.write(i);
            if (i==-1){
                break;
            }
        }
        in.close();
        out.close();
    }

    private static void encryptFile(String inputAddress, String outputAddress) throws FileNotFoundException, IOException {
        BASE64Encoder encoder= new BASE64Encoder();
        InputStream in=new FileInputStream(inputAddress);
        OutputStream out=new FileOutputStream(outputAddress);
        while(true){
            int i=in.read();
            if (i!=-1){
                byte[] bs={(byte)i};
                out.write(encoder.encode(bs).getBytes());
            }else{
                break;
            }
        }
        in.close();
        out.close();
    }
    
    /**
     * 
     * @param inputAddress
     * @param outputAddress
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private static void decryptFile(String inputAddress, String outputAddress) throws FileNotFoundException, IOException { 
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
