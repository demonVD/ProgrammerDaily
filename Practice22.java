// Reverse a linkedList recursively
class Node {
  int data;
  Node next;
  Node(int data){
    this.data = data;
    this.next = null;
  }
}
class Solution{
  Node newHead;
  public Node reverseList(Node head){
    reverseListHelper(head, null);
    return newHead;
  }

  private void reverseListHelper(Node head, Node prev){
    if(head.next == null) newHead = head;
    else reverseListHelper(head.next,head);
    head.next = prev;
  }

  public void display(Node head){
    Node temp = head;
    while(temp!=null){
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
  }
}
class Practice22{
  public static void main(String[] args){
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    Solution solution = new Solution();
    solution.display(solution.reverseList(head));
    // new Solution().reverseList(head);
  }
}
