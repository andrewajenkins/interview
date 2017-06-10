package chp8;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 8.1: Write a method to generate the nth Fibonacci number.
 */
public class ProblemA {

    @Test
    public void test() {
        int n = 10;
        System.out.println(fib(n));
        assertTrue(fib(n) == 55);
    }

    int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        else return fib(n-1) + fib(n-2);
    }
}