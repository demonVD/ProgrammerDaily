// Vertical Order Traversal of Binary Tree
// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/solution/
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
class Pair{
	int min, max;
	Pair(int min, int max){
		this.min = min;
		this.max = max;
	}
}
class Level implements Comparable<Level>{
	int val;
	int sl;
	int tl;
	Level(int val, int sl, int tl){
		this.val = val;
		this.sl = sl;
		this.tl = tl;
	}

	@Override
	public int compareTo(Level l1){
		if (this.sl != l1.sl)
            return Integer.compare(this.sl, l1.sl);
        else if (this.tl != l1.tl)
            return Integer.compare(this.tl, l1.tl);
        else
            return Integer.compare(this.val, l1.val);
	}
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        /*
        HashMap<Integer, ArrayList<Level>> map = new HashMap<>();
        Pair p = new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE);
        verticalTraversalHelper(root, 0, 0, map, p);
        System.out.println(p.min + " " + p.max);
        return convertMapToList(map, p);
        */

        List<Level> list = new ArrayList<>();
        verticalTraversalHelper(root, list, 0, 0);
        Collections.sort(list);
        List<List<Integer>> result = new ArrayList<>();	
        result.add(new ArrayList<Integer>());
        int sl = list.get(0).sl;

        for(Level level : list){
        	if(level.sl != sl){
        		sl = level.sl;
        		result.add(new ArrayList<Integer>());
        	}
        	result.get(result.size()-1).add(level.val);
        }
        return result;
    }
    private void verticalTraversalHelper(TreeNode root, List<Level> list, int sl, int tl){
    	if(root == null) return;
    	list.add(new Level(root.val, sl, tl));
    	verticalTraversalHelper(root.left, list, sl-1, tl+1);
    	verticalTraversalHelper(root.right, list, sl+1, tl+1);
    }
    
    /*
    private void verticalTraversalHelper(TreeNode root, int sidelevel, int topLevel, HashMap<Integer, ArrayList<Level>> map, Pair p){
    	if(root == null) return;
    	verticalTraversalHelper(root.left, sidelevel-1, topLevel+1, map, p);
    	if(p.min > sidelevel){
    		p.min = sidelevel;
    	}
    	if(p.max < sidelevel){
    		p.max = sidelevel;
    	}
    	if(map.isEmpty() || !map.containsKey(sidelevel)){
    		ArrayList<Level> list = new ArrayList<>();
    		list.add(new Level(root.val, topLevel));
    		map.put(sidelevel, list);
    	}
    	else{
    		ArrayList<Level> list = map.get(sidelevel);
    		list.add(new Level(root.val, topLevel));
    	}
    	verticalTraversalHelper(root.right, sidelevel+1, topLevel+1, map, p);
    }*/
    private List<List<Integer>> convertMapToList(HashMap<Integer, ArrayList<Level>> map, Pair p){
    	if(map.isEmpty()) return null;
    	// List<List<Integer>> list = (List<List<Integer>>)new ArrayList<ArrayList<Integer>>();
    	List<List<Integer>> list = new ArrayList<>();
    	for(int i = p.min; i <= p.max; i++){
    		List<Integer> temp = new ArrayList<>();
    		Collections.sort(map.get(i));
    		for(Level j : map.get(i)){
    			temp.add(j.val);
    		}
    		list.add(temp);
    	}
    	return list;
    }
    public void displayList(List<List<Integer>> list){
    	for(List<Integer> a : list){
    		for(int i : a){
    			System.out.print(i + " ");
    		}
    		System.out.println();
    	}
    }
}
class Practice195{
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		Solution solution = new Solution();
		solution.displayList(solution.verticalTraversal(root));
	}
}