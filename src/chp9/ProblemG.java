package chp9;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/**
 * 9.7: A circus is designing a tower routine consisting of people standing atop one another's
 * shoulders. For practical and aesthetic reasons, each person must be both shorter and
 * lighter than the person below him or her. Given the heights and weights of each person
 * in the circus, write a method to compute the largest possible number of people in such
 * a tower.
 */
public class ProblemG {

    @Test
    public void test() {
        int[][] input = {{65,100},{70,150},{56,90},{75,190},{60,95},{68,110}};
        int[][] output = {{56,90},{60,95},{65,100},{68,110},{70,150},{75,190}};
        assertTrue(Arrays.equals(maxSequence(input), output));
    }

    public int[][] maxSequence(int[][] a) {
        Arrays.sort(a, new HeightComparator());
        Arrays.sort(a, new WeightComparator());
        return a;
    }

    public class HeightComparator implements Comparator<Integer[]> {
        @Override
        public int compare(Integer[] a, Integer[] b) {
            return a[0].compareTo(b[0]);
        }
    }

    public class WeightComparator implements Comparator<Integer[]> {
        @Override
        public int compare(Integer[] a, Integer[] b) {
            return a[1].compareTo(b[1]);
        }
    }
}