package chp3;
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
        ProblemA a = new ProblemA();
        Stack s = a.new Stack();
        s.push(0, 0);
        s.push(1, 1);
        s.push(0, 0);
        s.push(2, 2);
        s.push(0, 0);
        s.pop(2);
        s.push(0, 0);
        s.pop(1);
        s.push(0, 0);
        s.pop(0);
        s.pop(0);
        s.pop(0);
        s.pop(0);
        s.pop(0);
        assertTrue("".equals(s.toString()));
    }

    class Stack {
        Element[] a = new Element[256];
        int[] pointers = {-1, -1, -1};

        int pop(int stackIndex) {
            Element popped = a[pointers[stackIndex]];
            a[pointers[stackIndex]] = null;
            pointers[stackIndex] = popped.prev;
            return popped.data;
        }

        void push(int stackIndex, int data) {
            int nextPosition = getNextPosition(pointers);
            a[nextPosition] = new Element(pointers[stackIndex], data);
            pointers[stackIndex] = nextPosition;
        }

        int getNextPosition(int[] pointers) {
            for(int i = 0; i < a.length; i++) {
                if(a[i] == null) {
                    return i;
                }
            }
            return -1;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < a.length; i++) {
                if(a[i] != null) {
                    sb.append(i+"["+a[i].prev+","+a[i].data+"] ");
                }
            }
            return sb.toString();
        }
    }

    class Element {
        int prev;
        int data;
        Element(int prev, int data) {
            this.prev = prev;
            this.data = data;
        }
    }
}