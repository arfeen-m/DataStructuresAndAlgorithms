import java.util.*;

//Time complexity : O (E lg(V))
//Constraint: Does not work with negative weights
//Lazy implementation -> uses PriorityQueue instead of IndexedPriorityQueue

public class DijkstraShortestPath {
	
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
	
	static class Node {
		int id;
		int value;
		
		public Node(int id, int value){
			this.id = id;
			this.value = value;
		}
	}
	
	private int n;
	private int[] dist;
	Integer[] prev;
	List<List<Edge>> graph;
	
	Comparator<Node> comparator = new Comparator<Node>(){
		@Override
		public int compare(Node node1, Node node2){
			return (node1.value - node2.value) > 0 ? 1:-1;
		}
	};
	
	public DijkstraShortestPath(int n){
		this.n = n;
		createEmptyGraph();
	}
	
	public DijkstraShortestPath(int n, Comparator<Node> comparator){
		this(n);
		this.compatator = comparator;
	}
	
	public void addEdge(int from, int to, int cost){
		graph.get(from).add(new Edge(from,to,cost));
	}
	
	private void createEmptyGraph() {
		graph = new ArrayList<>(n);
		for(int i = 0; i<n; i++){
			graph.add(new ArrayList<>());
		}
	}
	
	public List<List<Edge>> getGraph() {

		return graph;
	}

	
	//public static Integer[] dijkstraShortestPath(Map<Integer, List<Edge>> graph, int numNodes, int startIndex){
	public int dijkstra(int start, int end){	
	
		dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		
		PriorityQueue<Node> pq = new PriorityQueue(2*n, comparator);
		pq.add(new Node(start,0));
		
		boolean[] visited = new boolean[n];
		prev = new Integer[n];
		
		while(!pq.isEmpty()){
			Node node = pq.poll();
			visited[node.id] = true;
			
			//Check to see if we already have a better path
			//If so, ignore
			
			if(dist[node.id] < node.value) {
				continue;
			}
			
			List<Edge> edges = graph.get(node.id);
			for(int i = 0; i < edges.size(); i++){
				
				Edge edge = edges.get(i);
				
				//No need to visit already visited nodes
				if(visited[edge.to]) {
					continue;
				}
				
				//Relax edge by updating min cost if possible
				int newDist = dist[edge.from] + edge.weight;
				if(newDist < dist[edge.to]) {
					prev[edge.to] = edge.from;
					dist[edge.to] = newDist;
					pq.add(new Node(edge.to, dist[edge.to]));
				}
			}
			
			if(node.id == end) {
				return dist[end];
			}
		}
		
		//unreachable
		return -1;
		
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
	    
	}
	
}
