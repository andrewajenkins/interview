package chp1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Design an algorithm and write code to remove the duplicate characters in a string
 * without using any additional buffer. NOTE: One or two additional variables are fine.
 * An extra copy of the array is not. FOLLOW UP: Write the test cases for this method.
 */
public class ProblemC {

    @Test
    public void test() {
        String str = "abcdaabcdbacd";
        String golden = "abcd";
        assertTrue(removeDuplicates(str).equals(golden));
    }

    public String removeDuplicates(String str) {
        for(int i = 0; i < str.length(); i++) {
            for(int j = i+1; j < str.length(); j++) {
                while(j < str.length() && str.charAt(i) == str.charAt(j)) {
                    str = str.substring(0, j) + str.substring(j+1);
                }
            }
        }
        return str;
    }
}