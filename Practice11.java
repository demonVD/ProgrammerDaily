// LeetCode P19 Remove Nth Node From End of List
class Solution{

  public Node removeNthFromEnd(Node head, int n) {
    if(n <= 0) return head;
    Node firstPointer = head;
    Node curr = head;
    Node prev = null;
    Node after = null;
    int count = 0;
    while(firstPointer != null){
      if(count >= n){
        prev  = curr;
        curr = curr.next;
      }
      firstPointer = firstPointer.next;
      count++;
    }
    if(count < n) return head;
    else if(curr.next == null && prev == null) head = null;
    else if(curr.next == null) prev.next = null;
    else if(prev == null) head = curr.next;
    else {
      prev.next = curr.next;
      curr.next = null;
    }
    // System.out.println(curr.data);
    // System.out.println(prev.data);
    return head;
  }
  public void display(Node head){
    while(head != null){
      System.out.print(head.data+" ");
      head = head.next;
    }
  }
}
class Practice11{
  public static void main(String[] args){
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
     Solution solution = new Solution();
    solution.display(solution.removeNthFromEnd(head, 5));
  }
}
class Node{
  int data;
  Node next;
  Node(int data){
    this.data = data;
    this.next = null;
  }
}
