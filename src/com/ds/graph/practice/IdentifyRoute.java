package com.ds.graph.practice;

import com.ds.graph.Graph;

import java.util.LinkedList;

/**
 * [Need Right Implementation of Graph]
 *
 * Given a directed graph, design an algorithm to find out whether there is a route be- tween two nodes
 *
 * Solution:
 * This problem can be solved by just simple graph traversal, such as depth first search or breadth first search We start with one of the
 * two nodes and, during traversal, check if the other node is found We should mark any node found in the course of the algorithm as
 * ‘already visited’ to avoid cycles and repetition of the nodes
 */
public class IdentifyRoute   {
  public enum State {
    Unvisited,
    Visited,
    Visiting
  }
  
  public class Node {
    int value;
    State state;
    Node next;
  
    public Node(int value, Node next) {
      this.value = value;
      this.next = next;
      this.state = State.Unvisited;
    }
  
    public Node[] getAdjacent() {
      return null;
    }
  }
  
  static boolean DepthFirstSearch(Graph g, Node start, Node end) {
    LinkedList<Node> q = new LinkedList<>();
    
    for (int i = 0; i < g.size; i++) {
      q.get(i).state = State.Unvisited;
    }
    
    start.state = State.Visiting;
    
    q.add(start);
    
    Node u;
    
    while (!q.isEmpty()) {
      u = q.removeFirst(); // i.e., pop() if (u != null) {
      
      for (Node v : u.getAdjacent()) {
        
        if (v.state == State.Unvisited) {
          
          if (v == end) {
            return true;
          } else {
            v.state = State.Visiting;
            q.add(v);
          }
        }
        
      }
      u.state = State.Visited;
    }
    return false;
  }
}
