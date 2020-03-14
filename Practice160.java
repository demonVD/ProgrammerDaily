// diagonal sum of a BT
import java.util.ArrayList;
import java.util.HashMap;
class Node{
  int data;
  Node left, right;
  Node(int data){
    this.data = data;
    this.left = null;
    this.right = null;
  }
}
class Solution{
  int maxLevel;
  public void diagonalSum(Node root){
    if(root == null) return;
    HashMap<Integer, Integer> map = new HashMap<>();
    // int maxLevel = Integer.MIN_VALUE;
    diagonalSumHelper(map, root, 0);
    // System.out.println(map.size() + " " + map.get(0));
    // System.out.println(map.size() + " " + map.get(1));
    // System.out.println(maxLevel);
    for(int i=0;i<=maxLevel;i++){
      System.out.println(map.get(i));
    }
  }
  private void diagonalSumHelper(HashMap<Integer, Integer> map, Node node, int level){
    if(node ==  null) return;
    if(maxLevel < level){
      maxLevel = level;
      // System.out.println(level + " " + maxLevel);
    }
    if(!map.containsKey(level)){
      map.put(level, node.data);
    }else{
      map.put(level,map.get(level) + node.data);
    }
    diagonalSumHelper(map, node.left, level + 1);
    diagonalSumHelper(map, node.right, level);
  }
}
class Practice160{
  public static void main(String[] args) {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(-2);
    root.left.right = new Node(0);
    root.right.left = new Node(3);
    root.right.right = new Node(3);
    Solution solution = new Solution();
    solution.diagonalSum(root);
  }
}
