package chp9;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 9.6: Given a matrix in which each row and each column is sorted, write
 * a method to find an element in it.
 */
public class ProblemF {

    @Test
    public void test() {
        int[][] a = {{0,1,2,3},{4,5,6,7},{8,9,10,11},{12,13,14,15},{16,17,18,19}};
        assertTrue(findElement(a, 10));
        assertFalse(findElement(a, 21));
    }

    private boolean findElement(int[][] a, int find) {
        int row = 0;
        int column = a.length - 1;
        while(row < a[0].length && column >= 0) {
            if(a[column][row] == find) return true;
            else if(a[column][row] > find) column--;
            else row ++;
        }
        return false;
    }
}