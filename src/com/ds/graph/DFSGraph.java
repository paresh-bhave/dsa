package com.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSGraph {
  
  int size;
  
  /**
   * Array of lists for adjacency list representation
   */
  LinkedList<Integer> adjList[];
  
  public DFSGraph(int size) {
    this.size = size;
    adjList = new LinkedList[size];
  
    for (int i = 0; i < size; i++) {
      adjList[i] = new LinkedList<>();
    }
  }
  
  /**
   * Add edge into graph
   */
  void addEdge(int v, int w) {
    adjList[v].add(w);
  }
  
  void dfs(int vertex, boolean[] visited) {
    /**
     * Mark the current node as visited
     */
    visited[vertex] = true;
    System.out.println("Visited => " + vertex);
  
    /**
     * Recur for all the vertices adjacent to this vertices
      */
    Iterator<Integer> iterator = adjList[vertex].listIterator();
    
    while (iterator.hasNext()) {
      int node = iterator.next();
      if (!visited[node])
        dfs(node, visited);
    }
  }
  
  void dfs(int vertex) {
    /**
     * Mark all vertices as not visited
     * false by default in Java
     */
    boolean visited[] = new boolean[size];
    dfs(vertex, visited);
  }
  
  public static void main(String[] args) {
    DFSGraph dfsGraph = new DFSGraph(4);
  
    dfsGraph.addEdge(0, 1);
    dfsGraph.addEdge(0, 2);
    dfsGraph.addEdge(1, 2);
    dfsGraph.addEdge(2, 0);
    dfsGraph.addEdge(2, 3);
    dfsGraph.addEdge(3, 3);
    
    dfsGraph.dfs(2);
  }
}
