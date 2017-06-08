package chp3;

import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

/**
 * 3.5: Implement a MyQueue class which implements a queue using two stacks.
 */
public class ProblemE {

    @Test
    public void test() {
        MyQueue q = new MyQueue();
        q.push(0);
        q.push(1);
        assertTrue(q.pop() == 0);
        q.push(2);
        assertTrue(q.pop() == 1);
        assertTrue(q.pop() == 2);
    }

    class MyQueue {
        Stack<Integer> s1, s2;
        MyQueue() {
            s1 = new Stack<Integer>();
            s2 = new Stack<Integer>();
        }
        void push(int data) {
            s1.push(data);
        }
        int pop() {
            if(s2.isEmpty()) {
                while(!s1.isEmpty()) s2.push(s1.pop());
            }
            return s2.pop();
        }
    }
}