// validate a binary tree is BST or not
class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
		this.left = this.right = null;
	}
}
class Solution{
	boolean validateBST(Node root, int min, int max){
		if(root == null) return true;
		boolean ls = validateBST(root.left, min, root.data);
		boolean rs = validateBST(root.right, root.data, max);
		return ls & rs & (min < root.data) & (max > root.data);
	}
}
class Practice71{
	public static void main(String[] args) {
		Node root = new Node(100);
		root.left = new Node(90);
		root.right = new Node(110);
		root.left.left = new Node(80);
		root.left.right = new Node(95);
		System.out.println(new Solution().validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
}