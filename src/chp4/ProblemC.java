package chp4;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import chp4.ProblemA.Node;

/**
 * 4.3: Given a sorted (increasing order) array, write an algorithm to create a binary
 * tree with minimal height.
 */
public class ProblemC {

    static ProblemA p = new ProblemA();

    @Test
    public void test() {
        int[] a = {0,1,2,3,4,5,6,7,8,9,10};
        Node n = makeBalancedTree(a);
        assertTrue(ProblemA.isBalanced(n));
    }

    static Node makeBalancedTree(int[] a) {
        Node n = null;
        if(a.length > 0) {
            n = p.new Node(a[a.length/2]);
            n.left = makeBalancedTree(Arrays.copyOfRange(a, 0, a.length/2));
            n.right = makeBalancedTree(Arrays.copyOfRange(a, (a.length/2)+1, a.length));
        }
        return n;
    }
}