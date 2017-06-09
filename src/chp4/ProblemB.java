package chp4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;

/**
 * 4.2: Given a directed graph, design an algorithm to find out whether there is a route
 * between two nodes.
 */
public class ProblemB {

    @Test
    public void test() {
        Graph g1 = makeConnectedGraph();
        assertTrue(searchBFS(g1,g1.nodes.get(0),new Node(3)));
        Graph g2 = makeSparseGraph();
        assertFalse(searchBFS(g2,g1.nodes.get(0),new Node(3)));
    }

    public enum State {
        Unvisited, Visited, Visiting;
    }

    public static boolean searchBFS(Graph g, Node start, Node end) {
        LinkedList<Node> list = new LinkedList<Node>();
        for(Node n : g.getNodes()) {
            n.state = State.Unvisited;
        }
        start.state = State.Visiting;
        list.push(start);
        while(!list.isEmpty()) {
            Node current = list.pop();
            if(current.equals(end)) return true;
            for(Node n : current.getAdjacent()) {
                if(State.Unvisited.equals(n.state)) {
                    n.state = State.Visiting;
                    list.add(n);
                }
            }
            current.state = State.Visited;
        }
        return false;
    }

    class Node {
        ArrayList<Node> adjacent = new ArrayList<Node>();
        State state;
        int data;
        Node(int data) {
            this.data = data;
        }
        ArrayList<Node> getAdjacent() {
            return adjacent;
        }
        public boolean equals(Object o) {
            if(this == o) return true;
            if(!(o instanceof Node)) return false;
            Node n = (Node) o;
            if(this.data == n.data) return true;
            return false;
        }
        public String toString() { return data + " "; }
    }

    class Graph {
        ArrayList<Node> nodes = new ArrayList<Node>();
        ArrayList<Node> getNodes() {
            return nodes;
        }
    }

    private Graph makeConnectedGraph() {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n0.adjacent.add(n1);
        n0.adjacent.add(n2);
        n1.adjacent.add(n0);
        n1.adjacent.add(n3);
        n2.adjacent.add(n0);
        n2.adjacent.add(n3);
        n2.adjacent.add(n4);
        n3.adjacent.add(n1);
        n3.adjacent.add(n2);
        n4.adjacent.add(n2);
        Graph g = new Graph();
        g.nodes.add(n0);
        g.nodes.add(n1);
        g.nodes.add(n2);
        g.nodes.add(n3);
        g.nodes.add(n4);
        return g;
    }

    private Graph makeSparseGraph() {
        Node n0 = new Node(0);
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n0.adjacent.add(n1);
        n0.adjacent.add(n2);
        n1.adjacent.add(n0);
        n2.adjacent.add(n0);
        n2.adjacent.add(n4);
        n4.adjacent.add(n2);
        Graph g = new Graph();
        g.nodes.add(n0);
        g.nodes.add(n1);
        g.nodes.add(n2);
        g.nodes.add(n3);
        g.nodes.add(n4);
        return g;
    }
}