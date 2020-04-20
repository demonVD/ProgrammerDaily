// search an element in a sorted rotated array
class Solution{
	public int search(int[] arr, int element){
		int rotatedIndex = (arr[0] < arr[arr.length-1]) ? arr.length-1 : findRotation(arr, 0, arr.length-1);
		if(element < arr[0]){
			return searchHelper(arr, rotatedIndex + 1, arr.length-1, element);
		}
		else{
			return searchHelper(arr, 0, rotatedIndex, element);
		}
	}
	private int findRotation(int[] arr, int low, int high){
		if(low > high) return -1;
		else{
			int mid = low + (high - low)/2;
			if((mid == 0 || arr[mid - 1] < arr[mid]) && (mid == arr.length-1 || arr[mid + 1] < arr[mid])){
				return mid;
			}
			else if(arr[mid] > arr[high]){
				return findRotation(arr, mid+1, high);
			}
			else{
				return findRotation(arr, low, mid-1);
			}
		}
	}
	private int searchHelper(int[] arr, int low, int high, int element){
		if(low > high) return -1;
		else{
			int mid = low + (high - low)/2;
			if (arr[mid] == element) {
				return mid;
			}
			else if(element < arr[mid]){
				return searchHelper(arr, low, mid - 1, element);
			}
			else{
				return searchHelper(arr, mid + 1, high, element);
			}
		}
	}
}
class Practice182{
	public static void main(String[] args){
		int[] arr = {1, 2, 3, 4, 5, 7};
		// {5, 6, 7, 8, 9, 10, 1, 2, 3};
		Solution solution = new Solution();
		System.out.println(solution.search(arr, 3));
	}
}