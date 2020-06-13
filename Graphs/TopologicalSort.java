import java.util.*;


//This sorting is used for the following: prerequisites classes, program dependencies, etc 
//Time Complexity: O(V + E)

public class TopologicalSort {

	
	static class Edge {
		int from;
		int to;
		int weight;

		public Edge(int f, int t, int w){
			this.from = f;
			this.to = t;
			this.weight = w;
		}
	}
	
	public static int[] topologicalSort(Map<Integer,List<Edge>> graph, int numNodes){
		
		int[] ordering = new int[numNodes];
		boolean[] visited = new boolean[numNodes];
		
		int i = numNodes - 1;
		
		for(int at = 0; at < numNodes; at++){
			if(!visited[at]) {
				i = dfs(i,at,visited,ordering,graph);
			}
		}
		
		return ordering;
	}
	
	private static int dfs(int i, int at, boolean[] visited, int[] ordering,
			Map<Integer, List<Edge>> graph) {
		
		visited[at] = true;
		
		List<Edge> edges = graph.get(at);
		
		if(edges != null){
			for(Edge edge: edges){
				if(!visited[edge.to]){
					i = dfs(i, edge.to, visited,ordering,graph);
				}
			}
		}
		

		ordering[i] = at;
		return i - 1;
		
	}
	
	public static Integer[] dagShortestPath(Map<Integer, List<Edge>> graph, int start, int numNodes){
		
		int[] topSort = topologicalSort(graph,numNodes);
		
		Integer[] dist = new Integer[numNodes];
		
		dist[start] = 0;
		
		for(int i = 0; i < numNodes; i++){
			
			int nodeIndex = topSort[i];
			
			if(dist[nodeIndex] != null){
				List<Edge> edges = graph.get(nodeIndex);
				if(edges != null){
					for(Edge edge: edges){
						int newDist = dist[nodeIndex] + edge.weight;
						if(dist[edge.to] == null){
							dist[edge.to] = newDist;
						} else {
							dist[edge.to] = Math.min(newDist, dist[edge.to]);
						}
					}
				}
			}
		}
		
		return dist;
		
	}

	public static void main(String[] args) {
		
		int size = 6;
		Map<Integer, List<Edge>> graph = new HashMap<>();
		
		for(int i = 0; i < size; i++){
			graph.put(i, new ArrayList<>());
		}
		
		graph.get(0).add(new Edge(0, 1, 3));
	    graph.get(0).add(new Edge(0, 2, 2));
	    //graph.get(0).add(new Edge(0, 5, 3)); 
	    graph.get(0).add(new Edge(0, 4, 3));
	    graph.get(1).add(new Edge(1, 2, 6));
	    graph.get(1).add(new Edge(1, 3, 1));
	    graph.get(2).add(new Edge(2, 3, 1));
	    graph.get(2).add(new Edge(2, 5, 10));
	    graph.get(3).add(new Edge(3, 5, 5));
	    //graph.get(5).add(new Edge(5, 4, 7));
	    graph.get(4).add(new Edge(4, 5, 7));
	    
	    int[] ordering = topologicalSort(graph,size);
	    
	    System.out.println(java.util.Arrays.toString(ordering));
	    
	    Integer[] dists = dagShortestPath(graph, 0, size);
	    
	    System.out.println(Arrays.toString(dists));
	}

}
