// clone a linkedList with next and random pointer
import java.util.ArrayList;
import java.util.HashMap;
class Solution{
	public Node clone(Node root){
		Node newHead = new Node(-1);
		Node temp = newHead;
		HashMap<Node, Node> map = new HashMap<>();

		while(root != null){
			map.put(root, root.next);
			temp.next = new Node(root.data);
			Node storeAdd = root.next;
			root.next = temp.next;
			root = storeAdd;
			temp = temp.next;
		}

		for(Node node : map.keySet()){
			if(node.arb == null) node.next.arb = null;
			else node.next.arb = node.arb.next;
		}

		for(Node n : map.keySet()){
			n.next = map.get(n);
		}

		return newHead.next;
	}
	public void display(Node root){
		Node temp = root;
		while(root != null){
			System.out.print(root.data + " ");
			root = root.next;
		}
		System.out.println();
		while(temp != null){
			System.out.print(temp.arb.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}
class Practice183{
	public static void main(String[] args) {
		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(3);
		root.next.next.next = new Node(4);
		root.next.next.next.next = new Node(5);
		root.arb = root.next.next;
		root.next.arb = root;
		root.next.next.arb = root.next.next.next.next;
		root.next.next.next.arb = root.next.next;
		root.next.next.next.next.arb = root.next;
		Solution solution = new Solution();
		solution.display(solution.clone(root));
	}
}
class Node{
	int data;
	Node next, arb;
	Node(int data){
		this.data = data;
		this.next = null;
		this.arb = null;
	}
}