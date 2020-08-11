package com.ds.graph;

/**
 * A Java program for Dijkstra's single source shortest path algorithm.
 */

public class ShortestPath {
  static final int SIZE = 9;
  
  /**
   * A utility function to find the vertex with minimum distance value,
   * from the set of vertices not yet included in the shortest path tree
   */
  int minDistance(int distance[], boolean shortestPathSet[]) {
    int min = Integer.MAX_VALUE,
        minIndex = -1;
    
    for (int i = 0; i < SIZE; i++) {
      if (shortestPathSet[i] == false && distance[i] <= min) {
        min = distance[i];
        minIndex = i;
      }
    }
    return minIndex;
  }
  
  /**
   * A utility function to print the constructed distance array
   */
  void printSolution(int dist[]) {
    System.out.println("Vertex \t\t Distance from Source");
    for (int i = 0; i < SIZE; i++)
      System.out.println(i + " \t\t " + dist[i]);
  }
  
  /**
   * Function implements Dijkstra's single shortest path algorithm
   * for a graph represented using Adjacency Matrix
   */
  void dijkstra(int graph[][], int source) {
  
    /**
     * The output array
     * dist[i] will hold the shortest distance from source to i
     */
    int distance[] = new int[SIZE];
  
    /**
     * shortestPathSet[i] will be true if vertex i is included in
     * shortest path tree or shortest path distance from source to i is finalized
     */
    boolean[] shortestPathSet = new boolean[SIZE];
  
    /**
     * Initialize all distances as INFINITE
     * and shortestPathSet[] as false
     */
    for (int i = 0; i < SIZE; i++) {
      distance[i] = Integer.MAX_VALUE;
      shortestPathSet[i] = false;
    }
  
    /**
     * Distance of source vertex from itself is always 0
      */
    distance[source] = 0;
  
    /**
     * Find shortest path for all vertices
     */
    for (int count = 0; count < SIZE - 1; count++) {
  
      /**
       * Pick the minimum vertex from the set of vertices not yet processed
       * min is always equal to the source in the first iteration
       */
      int u = minDistance(distance, shortestPathSet);
  
      /**
       * Marked the picked vertices as processed
       */
      shortestPathSet[u] = true;
  
      /**
       * Update distance value of the adjacent vertices of the picked vertex
       */
      for (int v = 0; v < SIZE; v++) {
        /**
         * Update dist[v] only if
         * 1. Iis not in shortestPathSet,
         * 2. there is an edge from u to v, and
         * 3. Total weight of path from source to v through u is smaller than current value of dist[v]
         */
        if (!shortestPathSet[v] &&
            graph[u][v] != 0 &&
            distance[u] != Integer.MAX_VALUE &&
            (graph[u][v] + distance[u]) < distance[v]
        ) distance[v] = distance[u] + graph[u][v];
      }
    }
  
    printSolution(distance);
  }
  
  public static void main(String[] args) {
    int graph[][] = new int[][] {
      { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
      { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
      { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
      { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
      { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
      { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
      { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
      { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
      { 0, 0, 2, 0, 0, 0, 6, 7, 0 }
    };
    
    ShortestPath t = new ShortestPath();
    t.dijkstra(graph, 0);
  }
}
