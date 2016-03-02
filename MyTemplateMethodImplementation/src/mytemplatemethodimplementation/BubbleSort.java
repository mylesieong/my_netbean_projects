/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytemplatemethodimplementation;
import java.util.List;

/**
 * This is a subclass of SortMethodTemplate. It defines three standard operations from mother Class.
 * @author Myles
 */
class BubbleSort extends SortMethodTemplate{
    
     @Override
    public void fireFirstOperation(List l) {
        System.out.println("BubbleSort operation1");
    }

    @Override
    public void fireSecondOperation(List l) {
        System.out.println("BubbleSort operation2");        
    }

    @Override
    public void fireThirdOperation(List l) {
        System.out.println("BubbleSort operation3");        
    }   
}
