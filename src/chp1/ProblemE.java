package chp1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 1.5: Write a method to replace all spaces in a string with %20.
 */
public class ProblemE {

    @Test
    public void test() {
        String str = "This is a test. This is only a test.";
        String golden = "This%20is%20a%20test.%20This%20is%20only%20a%20test.";
        StringBuilder st = new StringBuilder();
        String[] a = str.split(" ");
        st.append(a[0]);
        for(int i = 1; i < a.length; i++) {
            st.append("%20");
            st.append(a[i]);
        }
        assertTrue(st.toString().equals(golden));
    }
}