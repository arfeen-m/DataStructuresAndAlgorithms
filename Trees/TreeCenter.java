
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeCenter {
	
	public static List<Integer> findTreeCenters(List<List<Integer>> tree){
		int n = tree.size();
		
		int[] degree = new int [n];
		
		//find all leaf nodes
		List<Integer> leaves = new ArrayList();
		for(int i = 0; i < n; i++){ 
			List<Integer> edges = tree.get(i);
			degree[i] =  edges.size();
			if(degree[i] <=1){
				leaves.add(i);
				degree[i] = 0;
			}
		}
		 
		//Remove leaf nodes and decrease the degrees of each node a dding new leaf nodes progressively 
		//until only the centers remain
		
		int processedLeaves = leaves.size();
		
		while(processedLeaves < n) {
			List<Integer> newLeaves = new ArrayList<>();
			for(int node: leaves){
				for(int neighbour: tree.get(node)){
					if(--degree[neighbour] == 1){
						newLeaves.add(neighbour);
					}
				}

				degree[node] = 0;
			}

			processedLeaves += newLeaves.size();
			leaves = newLeaves;
		}
		
		return leaves;
	}
	
	// Create an empty tree as a adjacency list.
	public static List<List<Integer>> createEmptyTree(int n) {
	  List<List<Integer>> tree = new ArrayList<>(n);
	  for (int i = 0; i < n; i++) tree.add(new LinkedList<>());
	  	return tree;
	}

	//Add nodes and edges
	public static void addUndirectedEdge(List<List<Integer>> tree, int from, int to) {
	  tree.get(from).add(to);
	  tree.get(to).add(from);
	}

	public static void main(String[] args) {
		
		List<List<Integer>> graph = createEmptyTree(9);
		addUndirectedEdge(graph, 0, 1);
	    addUndirectedEdge(graph, 2, 1);
	    addUndirectedEdge(graph, 2, 3);
	    addUndirectedEdge(graph, 3, 4);
	    addUndirectedEdge(graph, 5, 3);
	    addUndirectedEdge(graph, 2, 6);
	    addUndirectedEdge(graph, 6, 7);
	    addUndirectedEdge(graph, 6, 8);
	    
	    System.out.println(findTreeCenters(graph));
	}

}
