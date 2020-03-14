// Add two numbers represented by linked lists 
class Node{
	int data;
	Node next;
	Node(int data){
		this.data = data;
		this.next = null;
	}
}
class Solution{
	public Node add2Lists(Node first, Node second){
		int sum = 0;
		int carry = 0;
		Node result = new Node(0);
		Node temp = result;
		while(first != null && second != null) {
			sum = first.data + second.data + carry;
			if(sum > 9){
				carry = 1;
				sum = sum % 10;
			}else{
				carry = 0;
			}
			first = first.next;
			second = second.next;
			temp.next = new Node(sum);
			temp = temp.next;
		}
		while(first != null){
			// if(carry = 1)
			temp.next = new Node(first.data + carry);
			temp = temp.next;
			first = first.next;
		}
		while(second != null){
			temp.next = new Node(second.data + carry);
			temp = temp.next;
			second = second.next;
		}
		return result.next;
	}
	public void displayList(Node head){
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}
}
class Practice49{
	public static void main(String[] args) {
		Node first = new Node(0);
		// first.next = new Node(4);
		Node second = new Node(5);
		second.next = new Node(4);
		second.next.next = new Node(3);
		Solution solution = new Solution();
		solution.displayList(solution.add2Lists(first, second));
	}
}