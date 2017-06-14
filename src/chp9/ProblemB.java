package chp9;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/**
 * 9.2: Write a method to sort an array of strings so that all the anagrams are next to each other.
 */
public class ProblemB {

    @Test
    public void test() {
        String[] a = {"abc", "bcd", "cde", "bca"};
        String[] b = {"abc", "bca", "bcd", "cde"};
        Arrays.sort(a, new AnagramComparator());
        assertTrue(Arrays.equals(a, b));
    }

    public class AnagramComparator implements Comparator<String> {
        public String sortChars(String s) {
            char[] content = s.toCharArray();
            Arrays.sort(content);
            return new String(content);
        }

        public int compare(String a, String b) {
            return sortChars(a).compareTo(sortChars(b));
        }
    }
}