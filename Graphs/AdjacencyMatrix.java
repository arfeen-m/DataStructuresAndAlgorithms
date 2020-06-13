
public class AdjacencyMatrix {

	private boolean[][] adjMatrix;
	private int numVertices;
	
	public static void main(String[] args) {
		AdjacencyMatrix matrix = new AdjacencyMatrix(4);
		
		matrix.addEdge(0, 1);
		matrix.addEdge(0, 2);
		matrix.addEdge(1, 2);
		matrix.addEdge(2, 0);
		matrix.addEdge(2, 3);

		System.out.print(matrix.toString());
	}
	
	public AdjacencyMatrix(int numVertices){
		this.numVertices = numVertices;
		adjMatrix = new boolean[numVertices][numVertices];
	}
	
	public void addEdge(int row,int col){
		adjMatrix[row][col] = true;
		adjMatrix[col][row] = true;
	}
	
	public void removeEdge(int row,int col){
		adjMatrix[row][col] = false;
		adjMatrix[col][row] = false;
	}
	
	public String toString(){
		
		StringBuilder s = new StringBuilder();
		
		for(int row = 0;row<numVertices;row++){
			s.append(row + ": ");
			
			for(boolean col : adjMatrix[row]){
				s.append((col == true ? 1: 0) + " ");
			}
			s.append("\n");
		}
		
		
		return s.toString();
	}

}
