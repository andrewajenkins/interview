package chp2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Implement an algorithm to delete a node in the middle of a single linked list, given
 * only access to that node. Example: Input: the node 'c' from the linked list 
 * a->b->c->d->e, Result: nothing is returned, but the new linked list looks like
 * a->b->d->e.
 */
public class ProblemC {

    @Test
    public void test() {
        int[] a = {0,1,2,3,4};
        Node head = new Node(a);
        Node current = head.next.next;
        removeFromMiddle(current);
        assertTrue("0 1 3 4 ".equals(head.toString()));
    }

    private void removeFromMiddle(Node current) {
        Node prev = current;
        while(current.next != null) {
            current.data = current.next.data;
            prev = current;
            current = current.next;
        }
        prev.next = null;
    }
}