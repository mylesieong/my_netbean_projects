/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingchapter1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * This application demo different LayoutManager in Swing Usage, they are: BorderLayout,
 * FlowLayout, GridLayout, CardLayout, GridBagLayout, BoxLayout.
 * @author Myles
 */
public class Client extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Client frame = new Client();
        frame.getContentPane().setLayout(new GridLayout());
        JButton button1 = new JButton();
        JButton button2 = new JButton();
        JButton button3 = new JButton();
        JButton button4 = new JButton();
        JButton button5 = new JButton();
        button1.setText("button1");
        button2.setText("button2");
        button3.setText("button3");
        button4.setText("button4");
        button5.setText("button5");      
        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);
        frame.getContentPane().add(button3);
        frame.getContentPane().add(button4);
        frame.getContentPane().add(button5);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200,200);
        frame.setVisible(true);
    }

    
}
