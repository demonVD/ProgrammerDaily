// stack span problem
import java.util.Stack;
class Solution{
	Stack<Integer> stack = new Stack<>();
	public int[] getSpan(int[] arr){
		int[] result = new int[arr.length];
		result[0] = 1;
		stack.push(0);
		for(int i=1;i<arr.length;i++){
			// System.out.println("element : " + arr[i] + "peek : " + arr[stack.peek()]);
			while(!stack.empty() && arr[stack.peek()] <= arr[i]){
				stack.pop();
			}
			// System.out.println("element : " + arr[i] + "peek : " + arr[stack.peek()]);
			result[i] = (stack.empty()) ? i+1 : i - stack.peek(); 
			stack.push(i);
		}
		return result;
	}
	public void displaySpan(int[] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
class Practice52{
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.displaySpan(solution.getSpan(new int[]{100, 80, 60, 70, 60, 75, 85}));
	}
}