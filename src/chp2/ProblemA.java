package chp2;

import org.junit.Assert;
import org.junit.Test;

/**
 * Write code to remove duplicates from an unsorted linked list
 */
public class ProblemA {

    @Test
    public void test() {
        int[] a = {0,1,2,3,0,1,1};
        Node head = new Node(a);
        Node slow = head;
        while(slow.next != null) {
            Node fast = slow;
            while(fast != null && fast.next != null) {
                while(fast.next != null && fast.next.data == slow.data) {
                    fast.next = fast.next.next;
                }
                fast = fast.next;
            }
            slow = slow.next;
        }
        Assert.assertTrue("0 1 2 3 ".equals(head.toString()));
    }
}