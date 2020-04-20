// check for balanced Tree
class Solution{
	public boolean isBalanced(Node root){
		if(root == null) return true;
		boolean left = isBalanced(root.left);
		boolean right = isBalanced(root.right);
		int leftHeight = height(root.left, 0);
		int rightHeight = height(root.right, 0);
		return (left && right && (Math.abs(leftHeight - rightHeight) <= 1));
		// if(Math.abs(leftHeight - rightHeight) > 1){
		// 	return false;
		// }
		// return true;
	}
	private int height(Node root, int level){
		if(root == null) return 0;
		return Math.max(height(root.left, level+1), height(root.right, level+1)) + 1;
	}
}
class Practice186{
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		Solution solution = new Solution();
		System.out.println(solution.isBalanced(root));
		Solution2 solutionComplexityOn = new Solution2();
		System.out.println(solutionComplexityOn.isBalanced(root));
	}
}
class Node{
	int data;
	Node left, right;
	Node(int data){
		this.left = null;
		this.right = null;
	}
}
class Height{
	int height;
}
class Solution2{
	public boolean isBalanced(Node root){
		Height height = new Height();
		return isBalancedHelper(root, height);
	}
	private boolean isBalancedHelper(Node root, Height height){
		if(root == null){
			height.height = 0;
			return true;
		}
		Height leftH = new Height();
		Height rightH = new Height();
		boolean left = isBalancedHelper(root.left, leftH);
		boolean right = isBalancedHelper(root.right, rightH);
		height.height = Math.max(leftH.height, rightH.height) + 1;
		return (left && right && (Math.abs(leftH.height - rightH.height) <= 1));

	}
}