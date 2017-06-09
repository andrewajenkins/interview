package chp4;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

import chp4.ProblemA.Node;

/**
 * 4.4: Given a binary search tree, design an algorithm which creates a linked list of all the
 * nodes at each depth (i.e., if you have a tree with depth D, you'll have D linked lists).
 */
public class ProblemD {

    static ArrayList<LinkedList<Integer>> lists = new ArrayList<LinkedList<Integer>>();

    @Test
    public void test() {
        int[] a = {0,1,2,3,4,5,6,7,8,9,10};
        Node root = ProblemC.makeBalancedTree(a);
        getLists(root, 0);
        assertTrue(lists.get(0).contains(5));
        assertTrue(lists.get(1).contains(2));
        assertTrue(lists.get(1).contains(8));
        assertTrue(lists.get(2).contains(1));
        assertTrue(lists.get(2).contains(4));
        assertTrue(lists.get(2).contains(7));
        assertTrue(lists.get(2).contains(10));
        assertTrue(lists.get(3).contains(0));
        assertTrue(lists.get(3).contains(3));
        assertTrue(lists.get(3).contains(6));
        assertTrue(lists.get(3).contains(9));
        
    }

    private static void getLists(Node current, int depth) {
        if(lists.size() <= depth) { lists.add(new LinkedList<Integer>()); }
        lists.get(depth).push(current.data);
        depth++;
        if(current.left != null) getLists(current.left, depth);
        if(current.right != null) getLists(current.right, depth);
    }
}