package chp9;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * 9.1: You are given two sorted arrays, A and B, and A has a large enough buffer at the end to hold B.
 * Write a method to merge B into A in sorted order
 */
public class ProblemA {

    @Test
    public void test() {
        int[] a = {0,1,3,5,8,9,10,-1,-1,-1,-1,-1,-1};
        int[] b = {2,4,6,7,11,12};
        int[] golden = {0,1,2,3,4,5,6,7,8,9,10,11,12};
        assertTrue(Arrays.equals(mergeSorted(a,b,6), golden));
    }

    private int[] mergeSorted(int[] a, int[] b, int n) {
        int m = b.length -1;
        for(int i = a.length - 1; i > 0; i--) {
            if(m >= 0) {
                if(a[n] > b[m]) {
                    a[i] = a[n];
                    n--;
                } else {
                    a[i] = b[m];
                    m--;
                }
            }
        }
        return a;
    }
}