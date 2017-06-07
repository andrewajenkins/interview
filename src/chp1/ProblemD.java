package chp1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 1.4: Write a method to decide if two strings are anagrams or not.
 */
public class ProblemD {

    @Test
    public void test() {
        String word1 = "abcdefgc";
        String word2 = "defgabcc";
        int[] counts = new int[256];
        for(char c : word1.toCharArray()) {
            counts[c]++;
        }
        for(char c : word2.toCharArray()) {
            counts[c]--;
        }
        for(int i = 0; i < counts.length; i++) {
            if(counts[i] != 0) fail(); 
        }
    }
}