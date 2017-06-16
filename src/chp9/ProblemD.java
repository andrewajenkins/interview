package chp9;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 9.4: If you have a 2 GB file with one string per line, which sorting algorithm would you use
 * to sort the file and why?
 * 
 * I would use a compbination of quicksort and merge sort. I would read in as much data as
 * was practical, then quicksort that data. After each "section" of the data had been 
 * quicksorted I would then use a merge-sort style algorithm to merge all the chunks together
 * until the data had been sorted completely.
 */
public class ProblemD {

    @Test
    public void test() {
        fail("Not yet implemented");
    }
}