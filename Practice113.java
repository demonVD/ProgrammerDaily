// next greater element with same digits
class Solution{
	public void nextGreaterElement(int[] arr){
		int element = -1;
		int i=0, j = 0;
		for(i=arr.length-1;i>0;i--){
			if(arr[i] > arr[i-1]){
				element = arr[i-1];
				break;
			}			
		}
		// System.out.println(element);
		if(element == -1) {
			System.out.println("-1");
			return;
		}
		int nextGreater = Integer.MAX_VALUE;
		for(j=arr.length-1;j>=0;j--){
			if(arr[j] > element && arr[j] < nextGreater){
				nextGreater = arr[j];
				break;
			}
		}
		// System.out.println(nextGreater);
		swap(arr, i-1, j);
		// System.out.println(arr[i]+" "+arr[j]);
		// display(arr);
		reverse(arr, i, arr.length-1);
		display(arr);
	}
	private void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	private void reverse(int[] arr, int start, int end){
		while(start < end){
			swap(arr, start, end);
			start++;
			end--;
		}
	}
	private void display(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
class Practice113{
	public static void main(String[] args) {
		String[] str = args[0].trim().split(" ");
		int[] arr = new int[str.length];
		for(int i=0;i<str.length;i++){
			arr[i] = Integer.parseInt(str[i]);
		}
		new Solution().nextGreaterElement(arr);
	}
}