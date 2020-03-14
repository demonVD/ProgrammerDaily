// Cracking the coding interview 
// problem 2.4
// Pg: 105
class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
class Solution{
	Node partition(Node head, int k){
		Node curr = head;
		Node pos = head;
		while(curr != null){
			if(curr.data < k){
				int temp = curr.data;
				curr.data = pos.data;
				pos.data = temp;
				pos = pos.next;
			}
			curr = curr.next;
		}
		return head;
	}
	void display(Node head){
		Node curr = head;
		while(curr!=null){
			System.out.println(curr.data);
			curr = curr.next;
		}
	}
}
class Practice66{
	public static void main(String[] args) {
		Node head = new Node(4);
		head.next = new Node(3);
		head.next.next = new Node(2);
		head.next.next.next = new Node(1);
		Solution solution = new Solution();
		solution.display(solution.partition(head, 3));
	}
}