// Return kth node from last
class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
class Solution{
	Node kthNodeFromLast(Node head, int k){
		Node curr = head;
		Node node = head;
		int count = 1;
		while(curr != null){
			if(count++ == k){
				node = head;
			}
			else{
				node = node.next;
			}
			curr = curr.next;
		}
		return node;
	}
}
class Practice65{
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		System.out.println(new Solution().kthNodeFromLast(head, 2).data);
	}
}