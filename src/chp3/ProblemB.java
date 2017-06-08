package chp3;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 3.2: How would you design a stack which, in addition to push and pop, also has a function
 * min which returns the minimum element? Push, pop and min should all operate in O(1) time.
 */
public class ProblemB {

    @Test
    public void test() {
        Stack s = new Stack();
        s.push(3);
        s.push(2);
        s.push(3);
        s.push(1);
        assertTrue(s.min() == 1);
        s.pop();
        assertTrue(s.min() == 2);
    }

    class Stack {
        int[] a = new int[256];
        int[] mins = new int[256];
        int top = -1;
        void push(int data) {
            top++;
            a[top] = data;
            if(top == 0) {
                mins[top] = data;
            } else {
                mins[top] = Math.min(data, a[top-1]);
            }
        }
        int pop() {
            int value = a[top];
            top--;
            return value;
        }
        int min() {
            return mins[top];
        }
    }
}