// Convert Binart Tree to DLL
// inplace
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
		// Node head = 
		BToDllHelper(root);
		// System.out.println(head.data + " " + head.right.data);
		// System.out.println(head.left.data);
		// System.out.println(head.left.left.data);
		// System.out.println(head.left.left.left.data);
		while(root.left!=null){ 
			root = root.left;
		}
		// System.out.println(head.data );
		return root;
	}
	private void BToDllHelper(Node root){
		if(root == null) return;
		// Node node = new Node(root.data);
		// root.left = 
		BToDllLeft(root.left, root);
		// root.right = 
		BToDllRight(root.right, root);
		// return root;
	}
	private void BToDllLeft(Node root, Node next){
		if(root == null) return;
		// System.out.println("Root : " + root.data + " Next : " + next.data);
		// Node node = new Node(root.data);
		// root.left = 
		BToDllLeft(root.left, root);
		// System.out.println("Node left : " + node.left.data);
		// root.right = 
		BToDllRight(root.right, root);
		// System.out.println("Node right : " + node.right.data);
		while(root.right!=null) root = root.right;
		root.right = next;
		// return node;
	}
	private void BToDllRight(Node root, Node prev){
		if(root == null) return;
		// System.out.println("Root : " + root.data + " Prev : " + prev.data);
		// Node node = new Node(root.data);
		// root.left = 
		BToDllLeft(root.left, root);
		// root.right = 
		BToDllRight(root.right, root);
		while(root.left!=null) root = root.left;
		root.left = prev;
		// return node;
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
class Practice51{
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(12);
		root.right = new Node(15);
		root.left.left = new Node(25);
		root.left.right = new Node(30);
		root.right.left = new Node(36);
		Solution solution = new Solution();
		// solution.printList(solution.BToDLL(root));
		System.out.println();
		solution.displayDLLRight(solution.BToDLL(root));
		// solution.displayDLLLeft(solution.BToDLL(root));
	}
}