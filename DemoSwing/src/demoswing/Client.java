/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoswing;
import java.awt.*;
import javax.swing.*;

/**
 * This demo of swing build a simple frame and put some common-used component into the frame.
 * @Date 2015-12-11
 * @author Myles
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JCheckBox checkbox =new JCheckBox("Component");
        JButton button = new JButton("Component");
        JRadioButton radiobutton = new JRadioButton("Component");
        JLabel label = new JLabel("Component");
        JTextArea textarea = new JTextArea("Component");
        
        frame.getContentPane().add(BorderLayout.EAST, checkbox);
        frame.getContentPane().add(BorderLayout.WEST, button);
        frame.getContentPane().add(BorderLayout.CENTER, radiobutton);
        frame.getContentPane().add(BorderLayout.SOUTH, label);
        frame.getContentPane().add(BorderLayout.WEST, textarea);
        
        frame.setVisible(true);
    }
    
}
