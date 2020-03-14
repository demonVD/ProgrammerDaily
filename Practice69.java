// List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
// at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
class NodeTree{
	int data;
	NodeTree left;
	NodeTree right;
	public NodeTree(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
class NodeList{
	int data;
	NodeList next;
	public NodeList(int data){
		this.data = data;
		this.next = null;
	}
}

class Solution{

	public ArrayList<NodeList> listOfDepths(NodeTree root){
		Queue
	}

}
class Practice69{
	public static void main(String[] args) {
		NodeTree root = new NodeTree(1);
		root.left = new NodeTree(2);
		root.right = new NodeTree(3);
		root.left.left = new NodeTree(4);
		root.left.right = new NodeTree(5);
	}
}