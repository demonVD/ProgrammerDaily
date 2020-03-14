// Sum Root to Leaf
// https://www.interviewbit.com/problems/sum-root-to-leaf-numbers/?fbclid=IwAR1dzo9JwvGyj4CrBU_5B6B_HRo35YfOrvACXUlhsfX4vQevK8KeP24Ne3g
class Node{
  int data;
  Node left, right;
  Node(int data){
    this.data = data;
    this.left = this.right = null;
  }
}
class Solution{
  int sum =0;
  public int getSumRootToLeaf(Node root){
    getSumHelper(root, 0);
    return sum%1003;
  }
  private void getSumHelper(Node root, int digit){
    if(root == null){
      return;
    }
    if(root.left == null && root.right == null) {
      digit = digit * 10 + root.data;
      sum = sum + digit;
      sum = sum % 1003
      return;
    }
    digit = digit * 10 + root.data;
    getSumHelper(root.left, digit);
    getSumHelper(root.right, digit);
  }
}
class Practice26{
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(0);
    root.right.left = new Node(4);
    root.right.left.right = new Node(5);
    // root.left.right = new Node(5);
    // root.left.left = new Node(4);
    // root.right.left = new Node(6);
    // root.right.right = new Node(7);
    System.out.println(new Solution().getSumRootToLeaf(root));
  }
}
