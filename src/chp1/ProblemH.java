package chp1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings s1
 * and s2, write code to check if s2 is a rotations of s1 using only one call to isSubstring (ie, "waterbottle"
 * is a rotation of "erbottlewat").
 */
public class ProblemH {

    @Test
    public void test() {
        String a = "waterbottle";
        String b = "erbottlewat";
        String c = b + b;
        assertTrue(c.contains(a));
    }
}