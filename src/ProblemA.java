import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 3.1: Describe how you could use a single array to implement three stacks.
 * 
 * Answer: One method to implement three stacks using a single array would be to create an object
 * that held both the data value and an int index reference to the previous object. Then the class
 * would have the array of composite objects and 3 pointers, one to point to the top of each
 * individual stack. Then we would use the stack pointers to reference the tops of the stacks for
 * push and pop operations and the individual objects could be used for traversing backwards down
 * the stack in pop operations. 
 */
public class ProblemA {

    @Test
    public void test() {
        assertTrue(true);
    }
}