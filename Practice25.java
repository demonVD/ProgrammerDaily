// Mirror a binary Tree
class Node{
  int data;
  Node left, right;
  Node(int data){
    this.data = data;
    this.left = this.right = null;
  }
}
class Solution{
  public Node mirrorTree(Node head){
    if(head == null) return null;
    if(head.left == null && head.right == null) return head;
    Node left = mirrorTree(head.right);
    Node right = mirrorTree(head.left);
    head.left = left;
    head.right = right;
    return head;
  }
  public void inorderTraversal(Node head){
    if(head == null) return;
    inorderTraversal(head.left);
    System.out.print(head.data + " ");
    inorderTraversal(head.right);
  }
}
class Practice25{
  public static void main(String[] args) {
    Node head = new Node(1);
    head.left = new Node(2);
    // head.right = new Node(3);
    // head.left.left = new Node(4);
    // head.left.right = new Node(5);
    Solution solution = new Solution();
    solution.inorderTraversal(solution.mirrorTree(head));
  }
}
