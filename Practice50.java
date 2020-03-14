// Convert Binart Tree to DLL
// not inplace
class Node
{
	Node left, right;
	int data;
	
	Node(int d)
	{
		data = d;
		left = right = null;
	}
	
}
class Solution{
	public Node BToDLL(Node root){
		Node head = BToDllHelper(root);
		// System.out.println(head.data + " " + head.right.data);
		// System.out.println(head.left.data);
		// System.out.println(head.left.left.data);
		// System.out.println(head.left.left.left.data);
		while(head.left!=null){ 
			head = head.left;
		}
		// System.out.println(head.data );
		return head;
	}
	private Node BToDllHelper(Node root){
		if(root == null) return null;
		Node node = new Node(root.data);
		node.left = BToDllLeft(root.left, root);
		node.right = BToDllRight(root.right, root);
		return node;
	}
	private Node BToDllLeft(Node root, Node next){
		if(root == null) return null;
		// System.out.println("Root : " + root.data + " Next : " + next.data);
		Node node = new Node(root.data);
		node.left = BToDllLeft(root.left, root);
		// System.out.println("Node left : " + node.left.data);
		node.right = BToDllRight(root.right, root);
		// System.out.println("Node right : " + node.right.data);
		while(node.right!=null) node = node.right;
		node.right = next;
		try{
			System.out.println("Connection : " + node.data + " to " + next.data + " same as " + node.right.data);
		}
		catch(Exception e){
			System.out.println(node.data + "exception");
			e.printStackTrace();
		}

		return node;
	}
	private Node BToDllRight(Node root, Node prev){
		if(root == null) return null;
		// System.out.println("Root : " + root.data + " Prev : " + prev.data);
		Node node = new Node(root.data);
		node.left = BToDllLeft(root.left, root);
		node.right = BToDllRight(root.right, root);
		while(node.left!=null) node = node.left;
		node.left = prev;
		return node;
	}
	public void displayDLLRight(Node head){
		while(head!=null){
			System.out.print(head.data + " ");
			head = head.right;
		}
		System.out.println();
	}
	public void displayDLLLeft(Node head){
	while(head!=null){
		System.out.print(head.data + " ");
		head = head.left;
	}
	System.out.println();
}

	public void printList(Node head){
		Node prev = head;
		while(head!=null){
			System.out.print(head.data + " ");
			prev = head;
			head = head.right;
		}
		System.out.println();
		while(prev!=null){
			System.out.print(prev.data + " ");
			prev = prev.left;
		}
	}
}
class Practice50{
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(12);
		root.right = new Node(15);
		root.left.left = new Node(25);
		root.left.right = new Node(30);
		root.right.left = new Node(36);
		Solution solution = new Solution();
		solution.printList(solution.BToDLL(root));
		System.out.println();
		solution.displayDLLRight(solution.BToDLL(root));
		solution.displayDLLLeft(solution.BToDLL(root));
	}
}