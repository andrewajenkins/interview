package chp9;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 9.3: Given a sorted array of n integers that has been rotated an unknown number of times,
 * give an O(log n) algorithm that finds an element in the array. You may assume that the
 * array was originally sorted in increasing order. EXAMPLE: Input find 5 in array (15 16 19
 * 20 25 1 3 4 5 7 10 14), Output: 8 (the index of 5 in the array)
 */
public class ProblemC {

    @Test
    public void test() {
        int[] a = {15,16,19,20,25,1,3,4,5,7,10,14};
        int[] ab = {1,3,4,5,7,10,14,15,16,19,20,25};
        System.out.println(rotatedBinarySearch(a,16));
        assertTrue(rotatedBinarySearch(a, 5) == 1);
    }

    private int rotatedBinarySearch(int[] a, int find) {
        int l = 0; 
        int r = a.length - 1;
        while(l <= r) {
            int m = (l+r)/2;
            if(a[l] <= a[m]) {
                if(a[m] == find) return m;
                else if(a[m] < find) l = m + 1;
                else if(a[m] > find) r = m - 1;
            } else if(find < a[m]) r = m - 1;
            else if(find > a[m]) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    private int binarySearch(int[] a, int find) {
        int l = 0; 
        int r = a.length - 1;
        while(l <= r) {
            int m = (l+r)/2;
            if(a[m] < find) l = m + 1;
            if(a[m] > find) r = m - 1;
            if(a[m] == find) return m;
        }
        return -1;
    }
}