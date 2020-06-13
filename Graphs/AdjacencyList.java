import java.util.*;

public class AdjacencyList {

	
	private int numVertices;
	private ArrayList<ArrayList<Integer>> adjLists;
	
	public static void main(String[] args) {
		
		AdjacencyList adj = new AdjacencyList(4);
		
		adj.addEdge(0, 1);
		adj.addEdge(0, 2);
		adj.addEdge(0, 3);
		adj.addEdge(1, 2);
		
		System.out.print(adj.toString());

	}
	
	public AdjacencyList(int numVertices){
		this.numVertices = numVertices;
		adjLists = new ArrayList<ArrayList<Integer>>(numVertices);
		
		for(int i = 0;i<numVertices;i++){
			adjLists.add(new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int i, int j){
		
		adjLists.get(i).add(j);
		adjLists.get(j).add(i);
	}
	
	public String toString(){
	
		StringBuilder s = new StringBuilder();
		
		for(int i = 0;i<numVertices;i++){
			s.append(i + ": ");
			
			for(int j = 0; j < adjLists.get(i).size();j++){
				s.append("->" + adjLists.get(i).get(j));
			}
			s.append("\n");
		}
		
		
		return s.toString();
	}
}
