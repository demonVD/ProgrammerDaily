// Maximum depth or height of a tree
class Node{
	int data;
	Node left, right;
	Node(int data){
		this.data = data;
		this.left = this.right = null;
	}
}
class Solution{
	public int getMaxHeight(Node root){
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;
		return Math.max(getMaxHeight(root.left), getMaxHeight(root.right)) + 1;	
	}
}
class Practice91{
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		System.out.println(new Solution().getMaxHeight(root));
	}
}