/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demojunit;

import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.JUnitCore;

/**
 *
 * @author Myles
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JUnitCore.main("demojunit.Client");
    }

    /**Write a test method (annotated with @Test) that asserts expected 
     *results on the object under test:
     */
    @Test
    public void testEmptyCollection() {
        Collection collection = new ArrayList();
        assertTrue(collection.isEmpty());
    }

    /**If you are running your JUnit 4 tests with a JUnit 3.x runner, write a 
     *suite() method that uses the JUnit4TestAdapter class to create a suite 
     *containing all of your test methods:
    */
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(Client.class);
    }
}
