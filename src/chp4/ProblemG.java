package chp4;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import chp4.ProblemF.Node;

/**
 * 4.7: You have two very large binary trees: T1, with millions of nodes, and T2, with hundreds of nodes.
 * Create an algorithm to decide if T2 is a subtree of T1.
 */
public class ProblemG {

    String inOrderA = new String();
    String preOrderA = new String();
    String inOrderB = new String();
    String preOrderB = new String();

    @Test
    public void test() {
        int[] a = {0,1,2,3,4,5,6,7,8,9,10};
        Node rootA = makeBalancedTree(a, null);
        inOrderStringA(rootA);
        preOrderStringA(rootA);
        int[] b = {0,1,2,3,4};
        Node rootB = makeBalancedTree(b, null);
        inOrderStringB(rootB);
        preOrderStringB(rootB);
        assertTrue(preOrderA.contains(preOrderB));
        assertTrue(inOrderA.contains(inOrderB));
    }

    private void preOrderStringA(Node current) {
        preOrderA += current.data + " ";
        if(current.left != null) preOrderStringA(current.left);
        if(current.right != null) preOrderStringA(current.right);
    }

    private void preOrderStringB(Node current) {
        preOrderB += current.data + " ";
        if(current.left != null) preOrderStringB(current.left);
        if(current.right != null) preOrderStringB(current.right);
    }

    private void inOrderStringA(Node current) {
        if(current.left != null) inOrderStringA(current.left);
        inOrderA += current.data + " ";
        if(current.right != null) inOrderStringA(current.right);
    }

    private void inOrderStringB(Node current) {
        if(current.left != null) inOrderStringB(current.left);
        inOrderB += current.data + " ";
        if(current.right != null) inOrderStringB(current.right);
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