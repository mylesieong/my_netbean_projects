/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytemplatemethodimplementation;
import java.util.*;
/**
 * This is an abstract class implementing the Template Method Desgin Pattern. It contains a
 * public static method "sort(List)" for Clients to call. Inside the sort method
 * there are 3 parts of operation chain that needs to be defined by subclass.
 * @author Myles
 */
public abstract class SortMethodTemplate {
    /**
     * The public static method "sort(List)" for Clients to call and return List.
     */
    public List sort(List l){
        this.fireFirstOperation(l);
        this.fireSecondOperation(l);
        this.fireThirdOperation(l);
        return l;
    }
    /**
     * Three standard operations are needed to finish the sort method. 
     * Subclasss of SortMethodTemplate should define all of these.
     * @param l 
     */
    protected abstract void fireFirstOperation(List l);
    protected abstract void fireSecondOperation(List l);
    protected abstract void fireThirdOperation(List l);
    
    
}
