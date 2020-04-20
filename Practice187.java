// Create a BST from Preorder tranversal
class Solution{
	public Node constructBST(int[] arr){
		// Node head = new Node(arr[0]);
		if( arr.length == 0) return null;
		Index i = new Index();
		i.i = 0;
		Node head = new Node(arr[i.i]);
		head.left = constructBSTHelper(arr, i, Integer.MIN_VALUE, head.data);
		head.right = constructBSTHelper(arr, i, head.data, Integer.MAX_VALUE);
		return head;
	}
	private Node constructBSTHelper(int[] arr, Index index, int min, int max){
		// ++index.i;
		if(index.i == arr.length-1 || arr[index.i +1] < min || arr[index.i + 1] > max){
			// index.i--;
			return null;
		}
		Node temp = new Node(arr[++index.i]);
		temp.left = constructBSTHelper(arr, index, min, temp.data);
		temp.right = constructBSTHelper(arr, index, temp.data, max);
		return temp;
	}
	public void inOrder(Node root){
		if(root == null) return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
}
class Index{
	int i;
}
class Practice187{
	public static void main(String[] args) {
		int[] arr = {10, 5, 1, 7, 40, 50};
		Solution solution = new Solution();
		solution.inOrder(solution.constructBST(arr));
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