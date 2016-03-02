/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package image3dconvertor;

import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;
import java.util.ArrayList;

/**
 * This is an application that reads "source.jpg" and convert it into a 3D graphic.
 * The implementation follows:
 * 1. Read a jpg format image by javax.imageio.ImageIO;
 * 2. Create a 3 dimension data structure List<List<Color>> to capture pixels in 
 *    java.awt.image.Color format;
 * 3. Define and config a 3D component with mentioned data structure;
 * 4. Setup 3D universe, groups and deploy camera.
 * @author Myles
 * [log 2015-11-18] Finish step one and capable of finish step two and four in 10 mins.
 *                  but for how to deploy such a 3D graphic, expect 2 hours work.
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Read a jpg format image by javax.imageio.ImageIO
        BufferedImage image= ImageIO.read(new File("source.jpg"));

        
        for (int x=0;x<image.getHeight();x++){
            for (int y=0;y<image.getWidth();y++){
                Color c = new Color(image.getRGB(y, x));//If we use (x,y), it will rotate the image and might cause OutOfBoundException
                Color c_modified;//Class Color does provide setter method.
                int red=c.getRed();
                int green=c.getGreen();
                int blue=c.getBlue();
                c_modified=new Color(red,green,blue);
                image.setRGB(y,x,c_modified.getRGB());
            }
        }
        
        //Create a 3 dimension data structure List<List<Color>> to capture pixels
        //Define and config a 3D component with mentioned data structure;
        //Setup 3D universe, groups and deploy camera.
    }
    
}
