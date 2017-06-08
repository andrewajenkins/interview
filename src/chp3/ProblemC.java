package chp3;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

/**
 * 3.3: Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in
 * real life, we would likely start a new stack when the previous stack exceeds some threshold.
 * Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of
 * several stacks, and should create a new stack once the previous one exceeds capacity. 
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack (that is,
 * pop() should return the same values as if it were a single stack). FOLLOW UP: Implement a
 * function popAt(int) index which performs a pop-operation on a specific sub-stack.
 */
public class ProblemC {

    @Test
    public void test() {
        SetOfStacks ss = new SetOfStacks();
        for(int i = 0; i < 25; i++) {
            ss.push(i);
        }
        assertTrue(ss.pop() == 25);
        assertTrue(ss.pop() == 24);
        assertTrue(ss.popAt(2) == 10);
    }

    public class SetOfStacks {
        ArrayList<Stack> stacks = new ArrayList<Stack>();
        int MAX_SIZE = 5;
        int currentStack;
        SetOfStacks() {
            stacks.add(new Stack(MAX_SIZE));
            currentStack = 0;
        }
        public void push(int data) {
            if(stacks.get(currentStack).isFull()) {
                stacks.add(new Stack(MAX_SIZE));
                currentStack++;
            }
            stacks.get(currentStack).push(data);
        }
        public int pop() {
            if(stacks.get(currentStack).isEmpty()) {
                stacks.remove(currentStack);
                currentStack--;
            }
            return stacks.get(currentStack).pop();
        }
        public int popAt(int index) {
            return stacks.get(index).pop();
        }
    }

    public class Stack {
        int[] a;
        int top;
        Stack(int size) {
            a = new int[size];
            top = -1;
        }
        void push(int data) {
            top++;
            a[top] = data;
        }
        int pop() {
            int value = a[top];
            top--;
            return value;
        }
        boolean isFull() { return top == a.length - 1; }
        boolean isEmpty() { return top == -1; }
    }
}