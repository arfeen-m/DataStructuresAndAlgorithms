import java.util.*;

//Need to fix bugs
public class RootingTree {

		public static class TreeNode{
			private int val;
			private TreeNode parent;
			private List<TreeNode> children;		
		
			public TreeNode(int val){
				this.val = val;
			}
			
			public TreeNode(int val, TreeNode parent){
				this.val = val;
 				this.parent = parent;
 				children = new LinkedList<>();
			}
			
			public void addChildren(TreeNode... root){
				for(TreeNode node: root){
					children.add(node);
				}
			}
			
			@Override
			public String toString(){
				return String.valueOf(val);
			}
		}
			public static TreeNode rootTree(List<List<Integer>> graph, int val){
				
				TreeNode root = new TreeNode(val);
				return buildTree(graph,root);
			}

			private static TreeNode buildTree(List<List<Integer>> graph, TreeNode root) {
				for(int val: graph.get(root.val)) {
					if(root.parent != null && val == root.parent.val){
						continue;
					}
					
					TreeNode node = new TreeNode(val, root);
					root.addChildren(node);
					
					buildTree(graph,node);
				}
				return root;
			}
			
			 // Create a graph as a adjacency list
			  private static List<List<Integer>> createGraph(int n) {
			    List<List<Integer>> graph = new ArrayList<>(n);
			    for (int i = 0; i < n; i++) graph.add(new LinkedList<>());
			    return graph;
			  }

			  private static void addUndirectedEdge(List<List<Integer>> graph, int from, int to) {
			    graph.get(from).add(to);
			    graph.get(to).add(from);
			  }
		
		public static void main(String[] args) {
			
			List<List<Integer>> graph = createGraph(9);
		    addUndirectedEdge(graph, 0, 1);
		    addUndirectedEdge(graph, 2, 1);
		    addUndirectedEdge(graph, 2, 3);
		    addUndirectedEdge(graph, 3, 4);
		    addUndirectedEdge(graph, 5, 3);
		    addUndirectedEdge(graph, 2, 6);
		    addUndirectedEdge(graph, 6, 7);
		    addUndirectedEdge(graph, 6, 8);
		
		    TreeNode root = rootTree(graph, 6);

		    // Layer 0: [6]
		    System.out.println(root);

		    // Layer 1: [2, 7, 8]
		    System.out.println(root.children);

		    // Layer 2: [1, 3]
		    System.out.println(root.children.get(0).children);

		    // Layer 3: [0], [4, 5]
		    System.out.println(
		        root.children.get(0).children.get(0).children
		            + ", "
		            + root.children.get(0).children.get(1).children);

		    // Rooted at 3 the tree should look like:
		    //               3
		    //     2         4        5
		    //  6     1
		    // 7 8    0

		    // Layer 0: [3]
		    root = rootTree(graph, 3);
		    System.out.println();
		    System.out.println(root);

		    // Layer 1: [2, 4, 5]
		    System.out.println(root.children);

		    // Layer 2: [1, 6]
		    System.out.println(root.children.get(0).children);

		    // Layer 3: [0], [7, 8]
		    System.out.println(
		        root.children.get(0).children.get(0).children
		            + ", "
		            + root.children.get(0).children.get(1).children);
		  }
		


}
