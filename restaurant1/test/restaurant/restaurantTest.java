/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import junit.framework.TestCase;

/**
 *
 * @author mehmoona
 */
public class restaurantTest extends TestCase {
    
    /**
     * Test of serving_time method, of class restaurant.
     */
    public void testServing_time() {
        System.out.println("serving_time");
        int items = 5;
        restaurant instance = new restaurant();
        float expResult = 60F;
        float result = instance.serving_time(items);
        assertEquals(expResult, result, 0.0);
       
    }

    /**
     * Test of allocate_table method, of class restaurant.
     */
    public void testAllocate_table() {
        System.out.println("allocate_table");
        int persons = 8;
        restaurant instance = new restaurant();
        int expResult = 0;
        int result = instance.allocate_table(persons);
        assertEquals(expResult, result);
        
    }

    
}
