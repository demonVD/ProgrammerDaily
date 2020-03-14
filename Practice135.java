// PostOrder to BST
class Node
{
	int data;
	Node left, right;
	Node(int data)
	{
		this.data = data;
		this.right = this.left = null;
	}
}
class Solution 
{
	static int i;

	public Node constructTree(int post[], int n)
	{
		i = n-1;
		Node root = constructTreeHelper(Integer.MIN_VALUE, post, Integer.MAX_VALUE);
		return root;
	}
	private Node constructTreeHelper(int min, int[] post, int max)
	{
		Node root = null;

		if(post[i] < max && post[i] > min)
		{
			root = new Node(post[i]);
			--i;
		}
		else{
			return root;
		}
		if(i >= 0)
		{
			root.right = constructTreeHelper(root.data, post, max);
		}
		if(i >= 0)
		{
			root.left = constructTreeHelper(min, post, root.data);
		}		
		return root;
	}
	public void inorder(Node root)
	{
		if(root == null)
		{
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
}
class Practice135
{
	public static void main(String[] args) 
	{
		String[] arr = args[0].trim().split(" ");
		int n = arr.length;
		int[] post = new int[n];
		for(int i=0; i<n; i++)
		{
			post[i] = Integer.parseInt(arr[i]);
		}
		Solution solution = new Solution();
		Util.inorder(solution.constructTree(post, n));
	}
}