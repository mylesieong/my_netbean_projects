/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mydynamiccreation;

/**
 *
 * @author Myles
 */
public class NewCreature implements Speakable{

    @Override
    public void speak() {
        System.out.println(this.getClass().getName()+" speaks.");
   }

    
}
