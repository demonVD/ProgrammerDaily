// Maximum Depth of a BInary Tree
class Solution{
	public int maxDepth(TreeNode root){
		if(root ==  null) return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
class Practice190{
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);	
		root.right.right = new TreeNode(7);
		Solution solution = new Solution();
		System.out.println(solution.maxDepth(root));
	}
}
class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int val){
		this.val = val;
	}
}