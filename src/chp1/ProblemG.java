package chp1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column is set to 0.
 */
public class ProblemG {

    @Test
    public void test() {
        int[][] matrix = {{0,1,0,0},{0,0,0,0},{0,0,1,0},{0,0,0,0},{0,0,1,0}};
        int[][] golden = {{1,1,1,1},{0,1,1,0},{1,1,1,1},{0,1,1,0},{1,1,1,1}};

        int[][] copy = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1) {
                    for(int k = 0; k < matrix[0].length; k++) copy[i][k] = 1;
                    for(int k = 0; k < matrix.length; k++) copy[k][j] = 1;
                }
            }
        }
        assertTrue(Arrays.deepEquals(copy, golden));
    }
}