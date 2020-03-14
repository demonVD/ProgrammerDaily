// Stock buy sell
class Solution{
	public void maxProfit(int[] arr){
		Stack<Integer> stack = new Stack<Integer>();
		int i=0;
		int buyIndex = -1, sellIndex = -1;
		while(i < arr.length){
			while(arr[i] < arr[i+1]){
				i++;
			}
			while(stack.empty() || arr[stack.peek()] < arr[i]){
				stack.push(i++);
			}
			while(arr[stack.peek()] > arr[i]){
				stack.pop();
			}
		}
	}
}
class Practice132{
	public static void main(String[] args) {
		
	}
}