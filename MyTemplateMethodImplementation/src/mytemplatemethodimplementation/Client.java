/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytemplatemethodimplementation;
import java.util.*;
/**
 * This is a Concept of "Template method design pattern" Implementation Application
 * @author Myles
 * Class Client is the Main Class. It tries to call QuickSort.sort(List) and 
 * BubbleSort.sort(List) (both class heritated class SortMethodTemplate) and 
 * get different sorting method.
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> list= generateTestData();; //Create a list for sorting.
        new QuickSort().sort(list);
        new BubbleSort().sort(list);
    }
    
    /**
     * This is a static method returning a array of 0 to 4.
     */
    private static ArrayList<Integer> generateTestData() {
        ArrayList<Integer> testData= new ArrayList<Integer>();
        for (int i=0;i<5;i++){
            testData.add(i);
        }
        return testData;
    }
    
}
