// Maximum of all subarrays of size k 
import java.util.Deque;
import java.util.LinkedList;
class Solution{
	public void maxOfAllSubArray(int[] arr, int k){
		Deque<Integer> deque = new LinkedList<Integer>();
		int i;
		for(i=0;i<k;i++){
			while( !deque.isEmpty() && arr[deque.peekLast()] <= arr[i]){
				deque.removeLast();
			}
			deque.addLast(i);
		}
		for(;i<arr.length;i++){
			System.out.print(arr[deque.peek()] + " ");
			while( !deque.isEmpty() && (deque.peek() < i-k+1 )){
				deque.removeFirst();
			}
			while( !deque.isEmpty() && (arr[deque.peekLast()] <= arr[i])){
				deque.removeLast();
			}
			deque.addLast(i);
		}
		System.out.println(arr[deque.peek()]);
	}
}
class Practice127{
	public static void main(String[] args) {
		String[] elements = args[0].split(" ");
		int[] arr = new int[elements.length];
		for(int i=0;i<arr.length;i++){
			arr[i] = Integer.parseInt(elements[i]);
		}
		int k = Integer.parseInt(args[1]);
		new Solution().maxOfAllSubArray(arr, k);
	}
}