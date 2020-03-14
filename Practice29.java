// Reverse a Linked List in groups of given size
class Node{
  int data;
  Node next;
  Node(int data){
    this.data = data;
    this.next = null;
  }
}
class Solution{
  // public Node reverseInGroups(Node head, int k){
  //   // Node ptr = getPointerToK(Node head);
  //   reverse(head, head + k)
  // }
}
class Practice29{
  public static void main(String[] args) {
    Node head = new Node(0);
    head.next = new Node(1);
    head.next.next = new Node(2);
    head.next.next.next = new Node(3);
    System.out.println(head +" " + head + 2 + " " + head.next.next);
  }
}
