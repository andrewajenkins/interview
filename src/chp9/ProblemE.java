package chp9;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 9.5: Given a sorted array of strings which is interspersed with empty strings, write a method
 * to find the location of a given string.
 */
public class ProblemE {

    @Test
    public void test() {
        String[] sa1 = {"at","","","","ball","","","car","","","dad","",""};
        String[] sa2 = {"at","","","","","ball","car","","","dad","",""};
        assertTrue(modifiedBinarySearch(sa1, "ball") == 4);
        assertTrue(modifiedBinarySearch(sa2, "ballcar") == -1);
    }

    private int modifiedBinarySearch(String[] a, String find) {
        int l = 0; 
        int r = a.length - 1;
        while(r >= l && "".equals(a[r])) r--;
        while(l <= r) {
            int m = (l+r)/2;
            while(m < a.length && m < r && "".equals(a[m])) m++;
            if(a[m].compareTo(find) < 0) l = m + 1;
            if(a[m].compareTo(find) > 0) r = m - 1;
            if(a[m].compareTo(find) == 0) return m;
        }
        return -1;
    }
}