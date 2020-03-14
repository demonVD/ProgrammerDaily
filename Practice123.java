// Reverse a linkedList
class Solution{
	/*public Node reverse(Node head){
		System.out.println(head);
		reverseHelper(head, null, head);
		System.out.println("Head : " + head);
		return head;
	}
	private void reverseHelper(Node node, Node prev, Node head){
		System.out.println(node + " " + head);
		// if(prev == null) System.out.println("Node : " + node.data + " Head : " + head.data);
		// else System.out.println("Node : " + node.data + " Prev : " + prev.data + " Head : " + head.data);
		if(node.next == null){
			System.out.println("Node : " + node.data);
			head = node;
			head.next = prev;
			System.out.println("head : " + head.data + " prev : " + prev.data);
			return;
		}
		reverseHelper(node.next, node, head);
		node.next = prev;
	}*/
	public Node reverse(Node head){
		Node curr = head;
		Node prev = null;
		Node next = null;
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}
	public void display(Node head){
		while(head != null){
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}
// 1 null 1
// 2 1 1
// 3 2 1
// 4 3 1

class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
class Practice123{
	public static void main(String[] args){
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		Solution solution = new Solution();
		solution.display(solution.reverse(head));
	}
}