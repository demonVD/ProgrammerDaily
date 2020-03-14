// reverse a linked List using recursion
class Node{
  int data;
  Node next;
  Node(int data){
    this.data = data;
    this.next = null;
  }
}
class Solution{
  public Node reverse(Node head){
    reverseHelper(head).next = null;
    return head;
  }
  public void display(Node head){
    while(head != null){
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println();
  }
  private Node reverseHelper(Node head){
    if(head.next == null){
      // head.next = parent;
      return head;
    }
    reverseHelper(head.next).next = head;
    // head.next = parent;
    return head;
  }
}
class Practice173{
  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    Solution solution = new Solution();
    solution.display(head);
    solution.display(solution.reverse(head));
  }
}
