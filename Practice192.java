// Top order Traversal of a binary tree
import java.util.HashMap;
import java.util.ArrayList;
class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode(int data){
		this.data = data;
		this.left = this.right = null;
	}
}
class Pair{
	TreeNode node;
	int height;
	Pair(TreeNode node, int height){
		this.node = node;
		this.height = height;
	}
}
class Solution{
	int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	public void printTopView(TreeNode root){
		if(root == null) return;
		HashMap<Integer, ArrayList<Pair>> map = new HashMap<>();
		populateMap(root, map, 0, 0);
		// System.out.println("MIN :: " + min + " MAX :: " + max);
		printTopViewHelper(map);
	}
	private void printTopViewHelper(HashMap<Integer, ArrayList<Pair>> map){
		for(int i = min; i <= max; i++){
			ArrayList<Pair> list = map.get(i);
			int minHeight = Integer.MAX_VALUE;
			TreeNode node = null;
			for(Pair p : list){
				if(minHeight > p.diameter){
					minHeight = p.diameter;
					node = p.node;
				}
			}
			System.out.print(node.data + " ");
		}
		System.out.println();
	}
	private void populateMap(TreeNode root, HashMap<Integer, ArrayList<Pair>> map, int height, int dia){
		if(root == null) return;
		populateMap(root.left, map, height + 1, dia - 1);
		if(min > dia) min = dia;
		if(max < dia) max = dia;
		if(map.isEmpty() || !map.containsKey(dia)){
			ArrayList<Pair> list = new ArrayList<>();
			list.add(new Pair(root, height));
			map.put(dia, list);
		}
		else{
			map.get(dia).add(new Pair(root, height));
		}
		populateMap(root.right, map, height + 1, dia + 1);
	}
}
class Practice192{
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.right.right = new TreeNode(5);
		root.left.right.right.right = new TreeNode(6);
		// root.left.right.right.right.right = new TreeNode(6);
		root.right = new TreeNode(3);
		Solution solution = new Solution();
		solution.printTopView(root);
	}
}