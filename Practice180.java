// check if a Binary Tree is BST or not 
class Solution{
	public boolean isBST(Node root){
		return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private boolean isBSTHelper(Node root, int min, int max){
		if(root == null) return true;
		// if(root.left == null && root.right == null) return true;
		return (
			(root.data > min) && 
			(root.data < max) &&
			isBSTHelper(root.left, min, root.data) && 
			isBSTHelper(root.right, root.data, max) 
			);		
	}
}
class Practice180{
	public static void main(String[] args){
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		Solution solution = new Solution();
		System.out.println(solution.isBST(root));
	}
}
class Node{
	int data;
	Node left, right;
	Node(int data){
		this.data = data;
		this.left = this.right = null;
	}
}