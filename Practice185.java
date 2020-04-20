// LCA of 2 nodes in a Binary Tree
import java.util.List;
import java.util.ArrayList;
class Solution{
	public Node lca(Node n1, Node n2, Node root){
		List<Node> path1 = new ArrayList<Node>();
		boolean foundNode1 = findPath(root, n1, path1);
		System.out.println("foundNode1 :: " + foundNode1);
		System.out.println("Path1 :: " + path1.size());
		List<Node> path2 = new ArrayList<Node>();
		boolean foundNode2 = findPath(root, n2, path2);
		System.out.println("Path2 :: " + path2.size());
		System.out.println("foundNode2 :: " + foundNode2);
		if(foundNode1 && foundNode2){
			return findCommon(path1, path2);
		}else{
			return null;
		}
	}
	private Node findCommon(List<Node> path1, List<Node> path2){
		System.out.println("Inside FindCommon");
		int i = (path1.size() <= path2.size()) ? path1.size() - 1 : path2.size() - 1;
		Node lca = null;
		System.out.println("i :: " + i);
		// while(i < path1.size() && i < path2.size()){
		while(i >= 0){
			System.out.println("Inside while loop :: " + path1.get(i) + " " + path2.get(i));
			if(path1.get(i) == path2.get(i)){
				System.out.println("path1 :: " + path1.get(i));
				lca = path1.get(i);
			}
			i--;
		}
		return lca;
	}
	private boolean findPath(Node root, Node n, List<Node> path1){
		if(n == null || root == null) return false;
		path1.add(root);
		System.out.println("Node :: " + n.data + " Root :: " + root.data);
		boolean left = findPath(root.left, n, path1);
		boolean right = false;
		if(!left) right = findPath(root.right, n, path1);
		
		if(root == n){
			// path1.add(root);
			return true;
		}
		if(left || right){
			return true;
		}
		if(!left && !right){
			path1.remove(root);
			return false;
		}
		return false;
	}
}
class Practice185{
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);
		Solution solution = new Solution();
		System.out.println("First Case :: " + solution.lca(root.left.left, root.right.right, root).data);		
		System.out.println("Second Case :: " + solution.lca(root.left.left, new Node(7), root));
		System.out.println("Thrid Case :: " + solution.lca(root.left.left, root, root));		
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