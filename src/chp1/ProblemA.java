package chp1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 1.1: Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 */
public class ProblemA {

    @Test
    public void test() {
        String unique = "akdsopelmqw";
        String notUnique = "TestTestTest";
        assertTrue(isUnique(unique));
        assertFalse(isUnique(notUnique));
        assertTrue(isUniqueMin(unique));
        assertFalse(isUniqueMin(notUnique));
    }

    private boolean isUnique(String str) {
        int[] charCount = new int[256];
        for(char c : str.toCharArray()) {
            charCount[c]++;
        }
        for(int i = 0; i < charCount.length; i++) {
            if(charCount[i] > 1) return false;
        }
        return true;
    }

    private boolean isUniqueMin(String str) {
        for(int i = 0; i < str.length(); i++) {
            for(int j = 0; j < str.length(); j++) {
                if(i == j) continue;
                if(str.charAt(i) == str.charAt(j)) return false;
            }
        }
        return true;
    }
}