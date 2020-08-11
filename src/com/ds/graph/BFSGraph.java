package com.ds.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSGraph {
  
  int size;
  
  /**
   * Array of lists for adjacency list representation
   */
  LinkedList<Integer> adjList[];
  
  public BFSGraph(int size) {
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
  
  /**
   * BFS Search
   */
  void bfs(int vertex) {
    /**
     * Mark all vertices as not visited, by default
     */
    boolean[] visited = new boolean[size];
  
    /**
     * Create queue for bfs
     */
    LinkedList<Integer> queue = new LinkedList<>();
  
    /**
     * Mark the current vertex as visited
     */
    visited[vertex] = true;
    queue.add(vertex);
    
    while (queue.size() != 0) {
      /**
       * Dequeue a vertex from queue and print it
       */
      vertex = queue.poll();
      System.out.println("Visited => " + vertex);
  
      /**
       * Get all adjacent vertices of the dequeued vertex
       * If adjacent has not been visited, then mark it visited and enqueue it
       */
      Iterator<Integer> iterator = adjList[vertex].iterator();
      
      while (iterator.hasNext()) {
        
        int node = iterator.next();
        
        if (!visited[node]) {
          visited[node] = true;
          queue.add(node);
        }
      }
    }
  }
  
  public static void main(String[] args) {
    BFSGraph bfsGraph = new BFSGraph(4);
  
    bfsGraph.addEdge(0, 1);
    bfsGraph.addEdge(0, 2);
    bfsGraph.addEdge(1, 2);
    bfsGraph.addEdge(2, 0);
    bfsGraph.addEdge(2, 3);
    bfsGraph.addEdge(3, 3);
  
    bfsGraph.bfs(2);
  }
}
