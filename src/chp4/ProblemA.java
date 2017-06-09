package chp4;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 4.1: Implement a function to check if a tree is balanced. For the purposes of this question,
 * a balanced tree is defined to be a tree such that no two leaf nodes differ in distance from
 * the root by more than one node.
 */
public class ProblemA {

    private static final int MAX_DEPTH = 3;

    @Test
    public void test() {
        Node rootBalanced = buildBalancedTree(new Node(0), 1);
        assertTrue(isBalanced(rootBalanced));
        Node rootLinear = buildLinearTree(new Node(0), 1);
        assertFalse(isBalanced(rootLinear));
    }

    static boolean isBalanced(Node root) {
        int max = getMax(root, 0);
        int min = getMin(root, 0);
        return (max - min) <= 1;
    }

    private static int getMin(Node root, int count) {
        count++;
        if(root.left == null || root.right == null) return count;
        return Math.min(getMin(root.left, count), getMin(root.right, count));
    }

    private static int getMax(Node root, int count) {
        count++;
        if(root.left == null && root.right == null) return count;
        int left = -1;
        if(root.left != null) left = getMax(root.left, count);
        int right = -1;
        if(root.right != null) right = getMax(root.right, count);
        return Math.max(left, right);
    }

    class Node {
        Node left;
        Node right;
        int data;
        Node(int data) {
            this.data = data;
        }
        public String toString() {
            return data + " ";
        }
    }

    Node buildBalancedTree(Node current, int i) {
        if(i > MAX_DEPTH) return current;
        current.left = new Node(i++);
        current.right = new Node(i++);
        buildBalancedTree(current.left, i);
        buildBalancedTree(current.right, i);
        return current;
    }

    Node buildLinearTree(Node current, int i) {
        if(i > MAX_DEPTH) return current;
        current.right = new Node(i++);
        buildLinearTree(current.right, i);
        return current;
    }
}