// right view 
class Node{
	int data;
	Node left, right;
	Node(int data){
		this.data = data;
		this.left = this.right = null;
	}
}
class Solution{
	int max;
	public void rightView(Node root){
		max = Integer.MIN_VALUE;
		rightViewHelper(root, 0);
	}
	private void rightViewHelper(Node root, int level){
		if(root == null) {return;};
		if(level > max){
			max = level;
			System.out.println(root.data);
		}
		
		rightViewHelper(root.right, level+1);
		rightViewHelper(root.left, level+1);
	}
}
class Practice92{
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		// root.left.left.left = new Node(5);
		new Solution().rightView(root);
	}
}