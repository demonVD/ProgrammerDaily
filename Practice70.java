// Algo for tree is balanced
class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
class Solution{
	boolean isBalanced(Node root){
		if(root == null) return false;
		if(root.left == null && root.right == null) return true;
		return (isBalanced(root.left) && isBalanced(root.right));
	}
}
class Practice70{
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		System.out.println(new Solution().isBalanced(root));
	}
}