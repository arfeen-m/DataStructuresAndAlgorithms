
//Single source shortest path algorithm.
//This algo will be used to detect negative cycles 
//Time complexity of O(EV)

import java.util.*;

public class BellmanFordShortestPath {

	public static class Edge{
		double cost;
		int from;
		int to;
		
		public Edge(int from, int to, int cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
		
		public String toString(){
			return "[From: " + String.valueOf(this.from) + " To: " + String.valueOf(this.to) + " Cost: " + String.valueOf(this.cost) + "]";
		}
	}
	
	public static double[] bellmanFord(Edge[] edges, int v, int start){
		
		double[] dist = new double[v];
		Arrays.fill(dist, Double.POSITIVE_INFINITY);
		
		dist[start] = 0;
		
		boolean relaxedEdge = true;
		
		for(int vertice = 0; vertice < v - 1 && relaxedEdge; vertice++){
			relaxedEdge = false;
			for(Edge edge: edges){
				if(dist[edge.from] + edge.cost < dist[edge.to]) {
					dist[edge.to] = dist[edge.from] + edge.cost;
					relaxedEdge = true;
				}
			}
		}
		
		
		relaxedEdge = true;
		for(int vertice = 0; vertice < v - 1 && relaxedEdge;vertice++){
			relaxedEdge = false;
			for(Edge edge: edges){
				if(dist[edge.from] + edge.cost < dist[edge.to]) {
					dist[edge.to] = Double.NEGATIVE_INFINITY;
					relaxedEdge = true;
				}
			}
		}
		
		return dist;
	}
	
	public static void main(String[] args) {
		
		Edge[] edges = new Edge[10];
		
		edges[0] = new Edge(0, 1, 1);
		edges[1] = new Edge(1, 2, 1);
	    edges[2] = new Edge(2, 4, 1);
	    edges[3] = new Edge(4, 3, -3);
	    edges[4] = new Edge(3, 2, 1);
	    edges[5] = new Edge(1, 5, 4);
	    edges[6] = new Edge(1, 6, 4);
	    edges[7] = new Edge(5, 6, 5);
	    edges[8] = new Edge(6, 7, 4);
	    edges[9] = new Edge(5, 7, 3);
	    
	    double[] dist = bellmanFord(edges,9,0);
	    
	    
	    for (int i = 0; i < 9; i++){
	    	System.out.printf("The cost to get from node %d to %d is %.2f\n", 0, i, dist[i]);
	    }
	        


	}

}
