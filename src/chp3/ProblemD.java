package chp3;

import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

/**
 * 3.4: In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of different sizes which can
 * slide onto any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom
 * (e.g., each disk sits on top of an even larger one). You have the following constraints: (A) Only one
 * disk can be moved at a time. (B) A disk is slid off the top of one rod onto the next rod. (C) A disk can
 * only be placed on top of a larger disk. Write a program to move the disks from the first rod to the last
 * using only Stacks.
 */
public class ProblemD {

    @Test
    public void test() {
        int n = 5;
        Stack<Integer> tower1 = new Stack<Integer>();
        for(int i = n; i > 0; i--) { tower1.push(i); }
        Stack<Integer> end = TowersOfHanoi(n, tower1, new Stack<Integer>(), new Stack<Integer>());
        assertTrue(end.pop() == 1);
        assertTrue(end.pop() == 2);
        assertTrue(end.pop() == 3);
        assertTrue(end.pop() == 4);
        assertTrue(end.pop() == 5);
    }

    private Stack<Integer> TowersOfHanoi(int n, Stack<Integer> tower1, Stack<Integer> tower2, Stack<Integer> tower3) {
        if(n == 1) {
            tower3.push(tower1.pop());
        } else {
            TowersOfHanoi(n-1, tower1, tower3, tower2);
            TowersOfHanoi(1, tower1, tower2, tower3);
            TowersOfHanoi(n-1, tower2, tower1, tower3);
        }
        return tower3;
    }
}