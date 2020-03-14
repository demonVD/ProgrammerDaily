// given inorder and preorder traversal, build a tree.
class Node{
	char data;
	Node left, right;
	Node(char data){
		this.data = data;
		this.right = this.left = null;
	}
}
class Solution{
	
	int preStart;
	int preEnd;
	// int[] inorder;
	// int[] preorder;

	public Node buildTree(char[] inOrder, char[] preOrder){
		preStart = 0;
		preEnd = preOrder.length-1;
		return buildTreeHelper(0, inOrder.length-1, inOrder, preOrder);
	}

	private Node buildTreeHelper(int inStart, int inEnd, char[] inOrder, char[] preOrder){
		if(inStart > inEnd) return null;
		Node node = new Node(preOrder[preStart++]);
		int index = findIndex(inOrder, inStart, inEnd, node.data);
		node.left = buildTreeHelper(inStart, index-1, inOrder, preOrder);
		node.right = buildTreeHelper(index +1, inEnd, inOrder, preOrder);
		return node;
	}

	private int findIndex(char[] inOrder, int start, int end, char data){
		for(int i=start;i<=end;i++){
			if(inOrder[i] == data) return i;
		}
		return -1;
	}

	public void displayTree(Node root){
		if(root == null) return;
		displayTree(root.left);
		System.out.println(root.data + " ");
		displayTree(root.right);
	}

}
class Practice80{
	public static void main(String[] args) {
		char[] inOrder = {'b', 'a', 'd', 'e', 'c'};
		// {'a', 'b', 'c', 'd'};
		// {'d', 'b', 'e', 'a', 'f', 'c', 'g'};
		char[] preOrder = {'a', 'b', 'c', 'd', 'e'};
		// {'a', 'b', 'c', 'd'};
		// {'a', 'b', 'd', 'e', 'c', 'f', 'g'};
		Solution solution = new Solution();
		solution.displayTree(solution.buildTree(inOrder, preOrder));
	}
}