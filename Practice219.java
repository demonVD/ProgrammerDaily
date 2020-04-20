// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3305/
  // Construct Binary Search Tree from Preorder Traversal
  class Solution {
    public TreeNode bstFromPreorder(int[] arr) {
        if( arr.length == 0) return null;
		Index i = new Index();
		i.i = 0;
		TreeNode head = new TreeNode(arr[(i.i)++]);
		head.left = constructBSTHelper(arr, i, Integer.MIN_VALUE, head.val);
		head.right = constructBSTHelper(arr, i, head.val, Integer.MAX_VALUE);
		return head;
    }
    private TreeNode constructBSTHelper(int[] arr, Index index, int min, int max){
        // System.out.println("index :: " + index.i + " :: min :: " + min + " :: max :: " + max);
		if(index.i >= arr.length) return null;
        if(arr[index.i] <= min || arr[index.i] >= max) return null;
		TreeNode temp = new TreeNode(arr[(index.i)++]);
		temp.left = constructBSTHelper(arr, index, min, temp.val);
		temp.right = constructBSTHelper(arr, index, temp.val, max);
		return temp;
	}
}
class Index{
    int i;
}
class TreeNode {
 	int val;
 	TreeNode left;
 	TreeNode right;
 	TreeNode(int x) { val = x; }
}
class Practice219{
	public static void main(String[] args) {
		
	}
}