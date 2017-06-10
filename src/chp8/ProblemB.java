package chp8;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 8.2: Imagine a robot sitting on the upper left hand corner of an NxN grid. The robot can
 * only move in two directions: right and down. How many possible paths are there for the robot?
 */
public class ProblemB {

    @Test
    public void test() {
        assertTrue(numPaths(2,2,0) == 2);
        assertTrue(numPaths(3,3,0) == 6);
    }
    int numPaths(int x, int y, int count) {
        if(x > 1) count = numPaths(x-1, y, count);
        if(y > 1) count = numPaths(x, y-1, count);
        if(x == 1 && y == 1) return ++count;
        return count;
    }
}