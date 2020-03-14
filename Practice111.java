// LCA using Parent Pointer
class Node{
	Node parent;
	int data;
	Node left;
	Node right;
	Node(int data, Node parent){
		this.data = data;
		this.parent = parent;
	}
}
class Solution{
	public Node getLCA(Node n1, Node n2){
		int depth1 = findDepth(n1);
		int depth2 = findDepth(n2);
		if(depth1 == depth2){
			return getLCAHelper(n1, n2);
		}
		else if(depth1 > depth2){
			int diff = depth1 - depth2;
			while(diff-- > 0){
				n1 = n1.parent;
			}
			return getLCAHelper(n1, n2);
		}
		else{
			int diff = depth2 - depth1;
			while(diff-- > 0){
				n2 = n2.parent;
			}
			return getLCAHelper(n1, n2);
		}
	}

	private Node getLCAHelper(Node n1, Node n2){
		while(n1.parent != n2.parent){
			n1 = n1.parent;
			n2 = n2.parent;
		}
		return n1.parent;
	}

	private int findDepth(Node node){
		int depth = 0;
		if(node == null) return depth;
		while(node.parent!=null){
			depth += 1;
			node = node.parent;
		}
		return depth;
	}
}
class Practice111{
	public static void main(String[] args) {
		Node root = new Node(1, null);
		root.left = new Node(2, root);
		root.right = new Node(3, root);
		root.left.left = new Node(4, root.left);
		root.left.right = new Node(5, root.left);
		root.right.left = new Node(6, root.right);
		root.right.right = new Node(7, root.right);
		System.out.println(new Solution().getLCA(root.left, root.left.right).data);
	}
}