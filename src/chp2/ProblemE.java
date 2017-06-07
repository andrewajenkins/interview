package chp2;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Given a circular linked list, implement an algorithm which returns node at the
 * beginning of the loop. DEFINITION: Circular linked list: A (corrupt) linked list
 * in which a node's next pointer points to an earlier node, so as to make a loop
 * in the linked list. EXAMPLE: Input: A->B->C->D->E->C [the same C as earlier], 
 * Output: C
 */
public class ProblemE {

    @Test
    public void test() {
        int[] a = {0,1,2,3,4};
        Node head = new Node(a);

        head.next.next.next.next.next = head.next.next;
        assertTrue(findBeginning(head).data == 2);
    }

    private Node findBeginning(Node head) {
        List<Integer> list = new ArrayList<Integer>();
        Node current = head;
        list.add(current.data);
        while(current.next != null) {
            current = current.next;
            if(list.contains(current.data)) {
                return current;
            }
            list.add(current.data);
        }
        return null;
    }
}