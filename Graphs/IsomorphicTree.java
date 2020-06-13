import java.util.*;


public class IsomorphicTree {

	public static List<List<Integer>> createGraph(int n){
		List<List<Integer>> graph = new ArrayList<>(n);
		
		for(int i = 0; i < n; i++){
			graph.add(new ArrayList<Integer>());
		}
		
		return graph;
		
	}
	
	public static void addUndirectedEdge(List<List<Integer>> graph, int i, int j){
		graph.get(i).add(j);
		graph.get(j).add(i);
	}
	
	private static List<Integer> findTreeCenters(List<List<Integer>> tree) {
	    int n = tree.size();

	    int[] degree = new int[n];
	    List<Integer> leaves = new ArrayList<>();

	    // Find the first outer layer of leaf nodes.
	    for (int i = 0; i < n; i++) {
	      List<Integer> edges = tree.get(i);
	      degree[i] = edges.size();
	      if (degree[i] <= 1) {
	        leaves.add(i);
	        degree[i] = 0;
	      }
	    }

	    int processedLeafs = leaves.size();

	    // Iteratively remove leaf nodes layer by layer until only the centers remain.
	    while (processedLeafs < n) {
	      List<Integer> newLeaves = new ArrayList<>();
	      for (int node : leaves) {
	        for (int neighbor : tree.get(node)) {
	          if (--degree[neighbor] == 1) {
	            newLeaves.add(neighbor);
	          }
	        }
	        degree[node] = 0;
	      }
	      processedLeafs += newLeaves.size();
	      leaves = newLeaves;
	    }

	    return leaves;
	  }
	
	public static void main(String[] args) {
		
		List<List<Integer>> graph1 = createGraph(5);

	}

}
