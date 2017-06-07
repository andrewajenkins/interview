package chp2;

public class Node {

    Node next = null;
    int data;

    public Node(int d) { data = d; }

    public Node(int[] a) {
        this.data = a[0];
        Node current = this;
        for(int i = 1; i < a.length; i++) {
            current.next = new Node(a[i]);
            current = current.next;
        }
    }

    void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while(n.next != null) { n = n.next; }
        n.next = end;
    }

    Node deleteNode(Node head, int d) {
        Node n = head;
        if(n.data == d) {
            return head.next;
        }
        while(n.next != null) {
            if(n.data == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(data + " ");
        Node current = this;
        while(current.next != null) {
            current = current.next;
            sb.append(current.data + " ");
        }
        return sb.toString();
    }
}