package chp2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * 2.4: You have two numbers represented by a linked list, where each node contains a single
 * digit. The digits are stored in reverse order, such that the 1's digit is at the head of
 * the list. Write a function that adds the two numbers and returns the sum as a linked list.
 * Example: Input: (3->1->5) + (5->9->2), Output: 8->0->8
 */
public class ProblemD {

    @Test
    public void test() {
        int[] aa = {3,1,5};
        int[] ab = {5,9,2};
        Node a = new Node(aa);
        Node b = new Node(ab);
        assertTrue("8 0 8 ".equals(addLists(a,b).toString()));
    }

    private Node addLists(Node a, Node b) {
        Node head = new Node(-1);
        Node current = head;
        int carry = 0;

        while(a != null && b != null) {
            int result = a.data + b.data + carry;
            if(result > 9) {
                result %= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            current.next = new Node(result);
            current = current.next;
            a = a.next;
            b = b.next;
        }
        head = head.next;
        return head;
    }
}