// Lowest Common Ancestor of Deepest Leaves
import java.util.ArrayList;
import java.util.Collections;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
class MaxDepth{
	int maxDepth;
}
class Solution{
	private boolean found;

	public Solution(){
		found = false;
	}

	public boolean getFound(){
		return found;
	}

	public void setFound(boolean found){
		this.found = found;
	}

	public ArrayList<TreeNode> getDeepestNodes(TreeNode root){
		// int maxDepth = Integer.MIN_VALUE;
		MaxDepth maxDepth = new MaxDepth();
		ArrayList<TreeNode> listDeepestNodes = new ArrayList<>();
		if(root == null) return listDeepestNodes;
		getDeepestNodesHelper(root, 0, listDeepestNodes, maxDepth);
		return listDeepestNodes;
	}
	private void getDeepestNodesHelper(TreeNode root, int depth, 
			ArrayList<TreeNode> listDeepestNodes, MaxDepth maxDepth){
		if(root == null) return;
		getDeepestNodesHelper(root.left, depth+1, listDeepestNodes, maxDepth);
		getDeepestNodesHelper(root.right, depth+1, listDeepestNodes, maxDepth);
		if(depth >= maxDepth.maxDepth){
			maxDepth.maxDepth = depth;
			listDeepestNodes.add(root);
		}
		return;
	}

	public void lcaDeepestLeaves(TreeNode root) {
			ArrayList<TreeNode> deepestNodeList = getDeepestNodes(root); 
			TreeNode[] arr = deepestNodeList.toArray(new TreeNode[deepestNodeList.size()]);
			found = false;
			ArrayList<ArrayList<TreeNode>> paths = new ArrayList<>();
			for(int i = 0;i<deepestNodeList.size();i++){
				paths.add(new ArrayList<>());
				 // = new ArrayList<>();
			}
			for(int i = 0;i<deepestNodeList.size();i++){
				found = false;
				findPath(root, deepestNodeList.get(i), paths.get(i));
			}
			for(ArrayList<TreeNode> path : paths){
				Collections.reverse(path);
				for(TreeNode node : path){
					System.out.print(node.val + " ");				
				}
				System.out.println();
			}



    }
    public void findPath(TreeNode root, TreeNode node, ArrayList<TreeNode> path){
    	if(root == null) return;
    	if(root == node) found = true;
    	if(!found) findPath(root.left, node, path);
    	if(!found) findPath(root.right, node, path);
    	if(found) path.add(root);
    }
}
public class Practice74{
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		Solution solution = new Solution();
		solution.lcaDeepestLeaves(root);
		/*ArrayList<TreeNode> deepestNodeList = solution.getDeepestNodes(root);
		
		for(TreeNode node : deepestNodeList){
			System.out.print(node.val+" ");
		}

		TreeNode[] arr = deepestNodeList.toArray(new TreeNode[deepestNodeList.size()]);
		ArrayList<TreeNode> path1 = new ArrayList<>();
		solution.setFound(false);
		solution.findPath(root, arr[0], path1);

		for(TreeNode node : path1){
			System.out.println(node.val+" ");
		}*/
	}
}