class Node {
	int data;
	Node left;
	Node right;
	
	public Node (int data){
		this.data = data;
		left = null;
		right = null;
	}
	
}

class BinaryTree {

	Node root;
	
	BinaryTree(){
		root = null;
	}
	
	void postOrder(Node root){
		if(root == null){
			return;
		}
		
		postOrder(root.left);
		
		postOrder(root.right);
		
		System.out.print(root.data + "-> ");
				
	}
	
	void inOrder(Node root){
		if(root == null){
			return;
		}
		
		postOrder(root.left);

		System.out.print(root.data + "-> ");
		
		postOrder(root.right);
		
	}
	
	void preOrder(Node root){
		if(root == null){
			return;
		}
		
		System.out.print(root.data + "-> ");
		
	
		postOrder(root.left);

		
		postOrder(root.right);
		
	}
	
	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(12);
		tree.root.right = new Node(4);
		
		System.out.println("Post-Order Tree Traversal");
		tree.postOrder(tree.root);
		System.out.println();
		
		System.out.println("Pre-Order Tree Traversal");
		tree.preOrder(tree.root);
		System.out.println();
		
		System.out.println("In-Order Tree Traversal");
		tree.inOrder(tree.root);
	}
	
}
	
