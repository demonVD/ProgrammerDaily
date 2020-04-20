// Connect Nodes at same level in a Binary Tree
import java.util.Queue;
import java.util.LinkedList;
class Node{
	int data;
	Node left, right, nextRight;
	Node(int data){
		this.data = data;
		this.left = this.right = this.nextRight = null;
	}
}
class Solution{
	public Node connectNodesAtSameLevel(Node root){
		if(root == null) return null;
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()){
			Node temp = queue.poll();
			if(temp != null){
				temp.nextRight = queue.peek();
				if(temp.left != null) queue.add(temp.left);
				if(temp.right != null) queue.add(temp.right);
			}
			else if(!queue.isEmpty()){
				queue.add(null);
			}
		}
		return root;
	}
}
class Practice184{
	public static void main(String[] args){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);
		Solution solution = new Solution();
		solution.display(solution.connectNodesAtSameLevel(root));
	}
}