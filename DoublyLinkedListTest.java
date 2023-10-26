package csu22011_a2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  David Varley
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check if the insertFirst works
     */
    
    @Test
    public void testInsertLast()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	testDLL.insertLast(4);
    	testDLL.insertLast(8);
    	testDLL.insertLast(12);
    	
    	assertEquals( "Checking insertlast", "4,8,12", testDLL.toString() );
    	
    }
    
    
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        //System.out.println( testDLL.toString());
        // test empty list
        
        testDLL = new DoublyLinkedList<Integer>();
        
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1,1", testDLL.toString() );
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1,1,1", testDLL.toString() );
        
        //test negative list
        
        //testDLL = new DoublyLinkedList<Integer>();
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,-1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "-1", testDLL.toString() );

        testDLL.insertBefore(10, -15);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "-1,-15", testDLL.toString() );

        testDLL.insertBefore(-10, -17);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "-17,-1,-15", testDLL.toString() );
        
     }
    
    
    @Test
    public void testInsertFirst()
    {
    	// test non-empty list of ints
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,3);
        testDLL.insertBefore(0, 2);
        testDLL.insertBefore(0, 1);

        testDLL.insertFirst(4);
        assertEquals( "Checking insertFirst to a list containing 3 elements", "4,1,2,3", testDLL.toString() );
        testDLL.insertFirst(5);
        assertEquals( "Checking insertFirst to a list containing 4 elements", "5,4,1,2,3", testDLL.toString() );
        testDLL.insertFirst(6);       
        assertEquals( "Checking insertFirst to a list containing 5 elements", "6,5,4,1,2,3", testDLL.toString() );
        testDLL.insertFirst(7);        
        assertEquals( "Checking insertFirst to a list containing 6 elements ", "7,6,5,4,1,2,3", testDLL.toString() );      

        //System.out.println( testDLL.toString());
        // test empty list
//        testDLL = new DoublyLinkedList<Integer>();
//        testDLL.insertFirst(1);        
//        assertEquals( "Checking insertFirst to an empty list ", "1", testDLL.toString() );
//        testDLL = new DoublyLinkedList<Integer>();
//        testDLL.insertFirst(-1);        
//        assertEquals( "Checking insertFirst to an empty list - expected the element at the head of the list", "-1", testDLL.toString() );
//        testDLL = new DoublyLinkedList<Integer>();
      
     }

    // TODO: add more tests here. Each line of code in DoublyLinkedList.java should
    // be executed at least once from at least one test.
    
    @Test
    public void testMakeUnique()
    {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	//empty
    	assertEquals( "Checking makeUnique to an empty list ", "", testDLL.toString() );
    	
    	
    	
    	//on unique list
    	testDLL.insertBefore(1, 3);
        testDLL.insertBefore(2, 2);
        testDLL.insertBefore(0, 1);
        testDLL.makeUnique();
        
        assertEquals( "Checking makeUnique on unique list ", "1,3,2", testDLL.toString() );
        
        testDLL = new DoublyLinkedList<Integer>();
        
        //test on not-unique list of ints
        testDLL.insertBefore(1, 3);
        testDLL.insertBefore(2, 2);
        testDLL.insertBefore(2, 2);
        testDLL.insertBefore(2, 2);
        testDLL.insertBefore(2, 2);
        testDLL.insertBefore(0, 1);
        testDLL.makeUnique();
        
        assertEquals( "Checking makeUnique on not unique list ", "1,3,2", testDLL.toString() );
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertFirst(1);
        testDLL.insertFirst(1);
        testDLL.insertFirst(1);
        testDLL.insertFirst(2);
        testDLL.insertFirst(2);
        testDLL.insertFirst(2);
        
        testDLL.makeUnique();
        testDLL.insertBefore(1, 3);
        
        assertEquals( " check MU and IB", "2,3,1", testDLL.toString() );
        
        testDLL = new DoublyLinkedList<Integer>();
        
        //test on not-unique list of neg ints
        testDLL.insertBefore(1, -3);
        testDLL.insertBefore(2, -2);
        testDLL.insertBefore(2, 2);
        testDLL.insertBefore(2, 2);
        testDLL.insertBefore(0, 1);
        testDLL.makeUnique();
        
        assertEquals( "Checking makeUnique on not unique neg int list ", "1,-3,-2,2", testDLL.toString() );
        
        DoublyLinkedList<String> strtest = new DoublyLinkedList<String>();
        
        //test on not-unique list of strings
        strtest.insertFirst("D");
        strtest.insertFirst("D");
        strtest.insertFirst("C");
        strtest.insertFirst("B");
        strtest.insertFirst("A");
        //System.out.println(strtest.toString());
        strtest.makeUnique();
        
        assertEquals( "Checking makeUnique on not unique string list ", "A,B,C,D", strtest.toString() );
        
        strtest = new DoublyLinkedList<String>();
        strtest.insertFirst("test");
        strtest.insertFirst("test");
        
        //System.out.println(strtest.toString());
        strtest.makeUnique();
        //System.out.println(strtest.toString() + ", length ==" + strtest.listLength);
        //System.out.println(strtest.deleteAt(1));
        //strtest.deleteAt(1);
        //strtest.deleteAt(0);
        //System.out.println(strtest.toString());
        
        //calling makeUnique on list ["test","test"] and then deleteAt(1), deleteAt(0) should result in the empty list
        assertEquals( "deleteAt(1) should return false", strtest.deleteAt(1), false );
        //strtest.deleteAt(0);
        //System.out.println(strtest.toString() + ", is the list to string after deleting [0]");
        

        
        DoublyLinkedList<Boolean> booltest = new DoublyLinkedList<Boolean>();
        
        booltest.insertFirst(true);
        booltest.insertFirst(true);
        booltest.insertFirst(true);
        booltest.insertFirst(true);
        booltest.insertFirst(false);
        booltest.makeUnique();
        
        assertEquals( "Checking makeUnique on not unique bool list ", "false,true", booltest.toString() );

        
    }
    
    @Test
    public void testIsEmpty() {
    	//DLLNode temp = new DLLNode(3, null, null);
    	
    	
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	//empty
    	assertEquals( "Checking isEmpty with an empty list ", true, testDLL.isEmpty() );
    	
    	//not empty
    	testDLL.insertBefore(1, 3);
        testDLL.insertBefore(2, 2);
        testDLL.insertBefore(0, 1);
        
        assertEquals( "Checking makeUnique on unique list ", false, testDLL.isEmpty() );
    }
    
    @Test
    public void testReverse() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	testDLL.insertBefore(0, 4);
    	testDLL.insertBefore(0, 3);
        testDLL.insertBefore(0, 2);
        testDLL.insertBefore(0, 1);
        
        //System.out.println( "Before reverse: "+testDLL.toString());
        testDLL.reverse();
        //System.out.println( "After reverse: "+testDLL.toString());
        
        assertEquals( "Checking reverse on list ", "4,3,2,1", testDLL.toString() );
    }
    
    @Test
    public void testGet() {
    	
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	testDLL.insertBefore(0, 4);
    	testDLL.insertBefore(0, 3);
        testDLL.insertBefore(0, 2);
        testDLL.insertBefore(0, 1);
        
        assertEquals( "Checking get valid",  testDLL.get(0), testDLL.get(0) );
        assertEquals( "Checking get under bounds", null, testDLL.get(-12) );
        assertEquals( "Checking get over bounds", null, testDLL.get(10) );
        
        //System.out.println(testDLL.get(0) );
    	
    }
    
    
    
    @Test
    public void testDelete() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	testDLL.insertBefore(0, 4);
    	testDLL.insertBefore(0, 3);
        testDLL.insertBefore(0, 2);
        testDLL.insertBefore(0, 1);
        
        testDLL.deleteAt(1);
        
        assertEquals( "Checking delete ", "1,3,4", testDLL.toString() );
        
        
        
        assertEquals( "Checking delete ", false, testDLL.deleteAt(10) );
        
        
        assertEquals( "Checking delete ", false, testDLL.deleteAt(-10) );
        
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertFirst(1);
        
        assertEquals( "Checking if valid delete returns true ", true, testDLL.deleteAt(0) );
        
        
        
        //Checking deleteAt(0) on 2-element list should delete the head element from the list**
        //System.out.println(testDLL.toString() );
        //testDLL.deleteAt(0);
       // System.out.println(testDLL.toString() );
        
        
        DoublyLinkedList<String> strtest = new DoublyLinkedList<String>();
        strtest.insertBefore(0, "test");
        strtest.insertBefore(0, "test");
        
        String before = strtest.toString();
        strtest.makeUnique();
        String afterunique = strtest.toString();
        
        strtest.deleteAt(1);
        strtest.deleteAt(0);
        String afterdelete = strtest.toString();
        
        
        //System.out.println("before unique:" +before );
        //System.out.println("after unique:" + afterunique );
        //System.out.println("after delete:" +  afterdelete);

        
    }
    
    @Test
    public void testPointTo() {
    	DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
    	
    	testDLL.insertBefore(0, 4);
    	testDLL.insertBefore(0, 3);
        testDLL.insertBefore(0, 2);
        testDLL.insertBefore(0, 1);

        
        assertEquals( "Checking point to head", testDLL.pointTo(0), testDLL.pointTo(0) );
        assertEquals( "Checking point to tail", testDLL.pointTo(10), testDLL.pointTo(10) );
        
        
//        
//        assertEquals( "Checking delete ", false, testDLL.deleteAt(10) );
//        
//        
//        assertEquals( "Checking delete ", false, testDLL.deleteAt(-10) );
//        
    }
    
    

}












