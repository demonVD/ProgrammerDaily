// delete Node without header pointer
class Node{
  int data;
  Node next;
  Node(int data){
    this.data = data;
    this.next = null;
  }
}
class Solution{
  public void deleteNode(Node node){
    // if(node == null) return;
    // Node next = node.next;
    // Node prev = null;
    // while(next != null){
    //   node.data = next.data;
    //   prev = node;
    //   node = next;
    //   next = next.next;
    // }
    // prev.next = null;

      if(node == null) return;
      node.data = node.next.data;
      node.next = node.next.next;
  }
  public void display(Node head){
    Node temp = head;
    while(temp != null){
      System.out.print(temp.data + " ");
      temp = temp.next;
    }
  }
}
class Practice24{
  public static void main(String[] args) {
    Node head = new Node(1);
    head.next = new Node(2);
    head.next.next = new Node(3);
    head.next.next.next = new Node(4);
    head.next.next.next.next = new Node(5);
    Solution solution = new Solution();
    solution.deleteNode(head.next.next.next);
    solution.display(head);
  }
}
