// Print a Binary Tree in Vertical Order
import java.util.ArrayList;
import java.util.HashMap;
class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
class Solution{
	HashMap<Integer, ArrayList<Integer>> map;
	int max;
	int min;
	Solution(){
		map = new HashMap<>();
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;		
	}
	public void verticalOrder(Node root){
		if(root == null) return;
		verticalOrderHelper(root, 0);
		display(root);
	}
	private void verticalOrderHelper(Node node, int level){
		if(node == null) return;
		if(level < min) min = level;
		if(level  > max) max = level;
		if(!map.containsKey(level)){
			ArrayList<Integer> list = new ArrayList<>();
			list.add(node.data);
			map.put(level, list);
		} 
		else{
			ArrayList<Integer> list = map.get(level);
			list.add(node.data);
			map.put(level, list);
		} 
		verticalOrderHelper(node.left, level-1);
		verticalOrderHelper(node.right, level+1);
	}
	private void display(Node root){
		for(int i=min;i<=max;i++){
			for(int j : map.get(i)){
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
class Practice128{
	public static void main(String[] args){
		
		/*Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(5);*/

		/*Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(60);*/

		Node root = new Node(1);
		root.left = new Node(2);
		root.left.left = new Node(3);
		
		new Solution().verticalOrder(root);
	}
}