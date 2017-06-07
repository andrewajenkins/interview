package chp1;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * 1.2: Write code to reverse a C-Style String. (C-String means that "abcd" is represented
 * as five characters, including the null character.
 */
public class ProblemB {

    @Test
    public void test() {
        char[] str = {'a','b','c','d','e','\0'};
        char[] golden = {'e','d','c','b','a','\0'};
        int i = 0;
        int j = str.length - 2;
        while(i <= j) {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
        assertTrue(Arrays.equals(str, golden));
    }
}