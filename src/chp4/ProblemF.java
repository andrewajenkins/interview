package chp4;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import chp4.ProblemE.Node;

/**
 * 4.6: Design an algorithm and write code to find the first common ancestor of two nodes in
 * a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not
 * necessarily a binary search tree.
 */
public class ProblemF {

    @Test
    public void test() {
        int[] a = {0,1,2,3,4,5,6,7,8,9,10};
        Node root = makeBalancedTree(a, null);
        assertTrue(findFirstCommonAncestor(root, 0, 3) == 2);
        assertTrue(findFirstCommonAncestor(root, 6, 9) == 8);
        assertTrue(findFirstCommonAncestor(root, 0, 9) == 5);
    }

    int findFirstCommonAncestor(Node current, int data1, int data2) {
        int left = 0, right = 0;
        if(current.left != null) left = search(current.left, data1, data2);
        if(current.right != null) right = search(current.right, data1, data2);
        if(left == 1 && right == 1) return current.data;
        if(left == 2) return findFirstCommonAncestor(current.left, data1, data2);
        if(right == 2) return findFirstCommonAncestor(current.right, data1, data2);
        return -1;
    }

    int search(Node current, int data1, int data2) {
        int left = 0, right = 0;
        if(current.left != null) left = search(current.left, data1, data2);
        if(current.right != null) right = search(current.right, data1, data2);
        if(current.data == data1 || current.data == data2) return left + right + 1;
        else return left + right;
    }

    class Node {
        Node left;
        Node right;
        Node parent;
        int data;
        Node(int data) {
            this.data = data;
        }
        Node(int data, Node parent) {
            this.parent = parent;
            this.data = data;
        }
        public String toString() {
            return data + " ";
        }
    }

    Node makeBalancedTree(int[] a, Node parent) {
        Node n = null;
        if(a.length > 0) {
            n = new Node(a[a.length/2], parent);
            n.left = makeBalancedTree(Arrays.copyOfRange(a, 0, a.length/2), n);
            n.right = makeBalancedTree(Arrays.copyOfRange(a, (a.length/2)+1, a.length), n);
        }
        return n;
    }
}