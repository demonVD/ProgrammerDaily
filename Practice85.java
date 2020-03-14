// Search an element in a sorted and rotated array
class Solution{
	public int getIndex(int[] arr, int element){
		return getIndexHelper(arr, element, 0, arr.length-1);
	}
	private int getIndexHelper(int[] arr, int element, int low, int high){
		if(low > high) return -1;
		int mid = (low + high)/2;
		if(element == arr[mid]) return mid;
		else if(element < arr[mid]){
			if(element < arr[low]) return getIndexHelper(arr, element, mid+1, high);
			else return getIndexHelper(arr, element, low, mid-1);
		}
		else{
			if(element > arr[high])	return getIndexHelper(arr, element, low, mid-1);
			else return getIndexHelper(arr, element, mid+1,high);
		}
	}

}
class Practice85{
	public static void main(String[] args) {
		String[] str = args[0].split(" ");
		int[] arr = new int[str.length];
		for(int i=0;i<arr.length;i++){
			arr[i] = Integer.parseInt(str[i]);
		}
		System.out.println(new Solution().getIndex(arr, Integer.parseInt(args[1])));
	}
}