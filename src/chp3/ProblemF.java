package chp3;

import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

/**
 * 3.6: Write a program to sort a stack in ascending order. You should not make any assumptions
 * about how the stack is implemented. The following are the only functions that should
 * be used to write this program: push|pop|peek|isEmpty.
 */
public class ProblemF {

    @Test
    public void test() {
        Stack<Integer> s = new Stack<Integer>();
        Stack<Integer> t = new Stack<Integer>();
        s.push(5);
        s.push(1);
        s.push(4);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()) {
            int value = s.pop();
            while(!t.isEmpty() && t.peek() < value) {
                s.push(t.pop());
            }
            t.push(value);
        }
        assertTrue(t.pop() == 1);
        assertTrue(t.pop() == 2);
        assertTrue(t.pop() == 3);
        assertTrue(t.pop() == 4);
        assertTrue(t.pop() == 5);
    }
}