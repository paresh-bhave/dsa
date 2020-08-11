package com.ds.graph;

public class GraphMain {
  public static void main(String[] args) {
    Graph graph = new Graph(6);
    graph.add(0, 2);
    graph.add(0, 1);
    graph.add(1, 4);
    graph.add(1, 3);
    graph.add(1, 0);
    graph.add(3, 1);
    graph.add(4, 1);
    graph.add(2, 5);
    graph.add(2, 0);
    graph.add(5, 2);
  
    System.out.println("---BREADTH FIRST SEARCH---");
    graph.breadthFirstSearch(4);
  
    System.out.println("---DEPTH FIRST SEARCH---");
    graph.depthFirstSearch(0);
  }
}
