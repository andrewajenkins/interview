package chp4;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 * 4.5: Write an algorithm to find the 'next' node (i.e., in-order successor) of a given node
 * in a binary search tree where each node has a link to its parent
 */
public class ProblemE {

    @Test
    public void test() {
        int[] a = {0,1,2,3,4,5,6,7,8,9,10};
        Node root = makeBalancedTree(a, null);
        assertTrue(inorderSucc(root, 2) == 3);
        assertTrue(inorderSucc(root, 1) == 2);
        assertTrue(inorderSucc(root, 4) == 5);
        
    }

    private int inorderSucc(Node root, int data) {
        Node current = inorderGet(root, data);
        if(current.right != null) {
            Node temp = current.right;
            while(temp.left != null) temp = temp.left;
            return temp.data;
        } else {
            if(current.parent.left != null && current.parent.left.data == current.data) 
                return current.parent.data;
            if(current.parent.right != null && current.parent.right.data == current.data) 
                return current.parent.parent.data;
        }
        return -1;
    }

    private Node inorderGet(Node current, int data) {
        Node left = null;
        Node right = null;
        if(current.left != null) {
            left = inorderGet(current.left, data);
        }
        if(current.data == data) return current;
        if(current.right != null) {
            right = inorderGet(current.right, data);
        }
        if(left != null) return left;
        if(right != null) return right;
        return null;
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