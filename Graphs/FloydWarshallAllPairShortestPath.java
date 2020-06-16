//Time complexity: O(v^3)

import java.util.*;

public class FloydWarshallAllPairShortestPath {

	private static final int REACHES_NEGATIVE_CYCLE = -1;
	  
	private int n;
	private boolean solved;
	private double[][] dp;
	private Integer[][] next; //used to reconstruct path
	
	public FloydWarshallAllPairShortestPath(double[][] matrix){
		n = matrix.length;
		dp = new double[n][n];
		next = new Integer[n][n];
		
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(matrix[i][j] != Double.POSITIVE_INFINITY){
					next[i][j] = j;
				}
				dp[i][j] = matrix[i][j];
				
			}
		}
		
		
		
	}
	
	public static double[][] createGraph(int n){
		
		double[][] matrix = new double[n][n];
		for(int i = 0; i < n; i++){
			Arrays.fill(matrix[i], Double.POSITIVE_INFINITY);
			matrix[i][i] = 0;
		}
		
		return matrix;
		
	}
	
	private double[][] getApspMatrix() {
		if(!solved) solve();
		return dp;
	}

	// Actual F-W algo
	private void solve() {
		for(int k = 0; k < n ; k++){
			for(int i = 0; i < n; i ++){
				for (int j = 0; j < n ; j++){
					if(dp[i][k] + dp[k][j] < dp[i][j]) {
						dp[i][j] = dp[i][k] + dp[k][j];
						next[i][j] = next[i][k];
					}
				}
			}
		}
		
		//Detect negative cycle
		
		for(int k = 0; k < n ; k++){
			for(int i = 0; i < n; i ++){
				for (int j = 0; j < n ; j++){
					if(dp[i][k] + dp[k][j] < dp[i][j]) {
						dp[i][j] = Double.NEGATIVE_INFINITY;
						next[i][j] = REACHES_NEGATIVE_CYCLE;
					}
				}
			}
		}
		
		solved = true;		
	}
	
	//TODO implement a func to reconstruct shortest path from next

	public static void main(String[] args) {
		int n = 7;
		double[][] graph = createGraph(n);
		
		//Add some edge weights;
		
		graph[0][1] = 2;
		graph[0][2] = 5;
		graph[0][6] = 10;
		graph[1][2] = 2;
		graph[1][4] = 11;
		graph[2][6] = 2;
		graph[6][5] = 11;
		graph[4][5] = 1;
		graph[5][4] = -2;
		
		FloydWarshallAllPairShortestPath solver = new FloydWarshallAllPairShortestPath(graph);
		
		double[][] dist = solver.getApspMatrix();
		
		for (int i = 0; i < n; i++)
	      for (int j = 0; j < n; j++)
	        System.out.printf("This shortest path from node %d to node %d is %.3f\n", i, j, dist[i][j]);

	}


}
