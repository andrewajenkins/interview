package chp2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 2.2: Implement an algorithm to find the nth to last element of a singly linked list.
 */
public class ProblemB {

    @Test
    public void test() {
        int[] a = {0,1,2,3,4,5};
        Node head = new Node(a);

        assertTrue(nthToLast(head, 3).data == 3);
    }

    Node nthToLast(Node head, int n) {
        Node current = head;
        Node lag = head;
        
        for(int i = 0; i < n - 1; i++) {
            current = current.next;
        }

        while(current.next != null) {
            lag = lag.next;
            current = current.next;
        }

        return lag;
    }
}