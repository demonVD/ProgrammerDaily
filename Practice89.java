// mergeSort
class Solution{
	public void mergeSort(int[] arr){
		mergeSortHelper(arr, 0, arr.length);
		for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
	}
	private void mergeSortHelper(int[] arr, int low, int high){
		if(low < high){
			int mid = (low+high)/2;
			mergeSortHelper(arr, low, mid);
			mergeSortHelper(arr, mid+1, high);
			merge(arr, low, mid, high);
		}
	}
	private void merge(int[] arr, int low, int mid, int high){
		int[] left = new int[mid - low + 1];
		int[] right = new int[high-mid];
		
		int i=0,j=0,k=low;
		
		for(i=0;i<left.length;i++) left[i] = arr[low + i];
		for(j=0;j<right.length;j++) right[j] = arr[j+mid+1];

		i=0;j=0;

		while(i<left.length&&j<right.length){
			if(left[i] <= right[j]){
				arr[k++] = left[i++];
			}
			else{
				arr[k++] = right[j++];
			}
		}
		while(k<left.length){
			arr[k++] = left[i++];
		}

		while(k<right.length){
			arr[k++] = right[j++];
		}
	}
}
class Practice89{
	public static void main(String[] args){
		String[] str = args[0].split(" ");
		int[] arr = new int[str.length];
		for(int i=0;i<arr.length;i++) arr[i] = Integer.parseInt(str[i]);
		new Solution().mergeSort(arr);
	}
}