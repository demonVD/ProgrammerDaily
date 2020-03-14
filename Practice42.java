// find missing Smallest positive integer
class Solution{
	public int getMissingSmallestPositiveNumber(int[] arr){
		int lastNegativeElementIndex = segregate(arr);
		int missingSmallestPositiveNumber = getMissingSmallestPositiveNumberHelper(arr, lastNegativeElementIndex);
		return missingSmallestPositiveNumber;
	}
	private int segregate(int[] arr){
		int j=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]<=0){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
		}
		return j;
	}
	private int getMissingSmallestPositiveNumberHelper(int[] arr, int start){
		int size = arr.length;

		for(int i=start;i<size;i++){
			int x = Math.abs(arr[i]);
			if (start+x-1 < size && start+x-1 >=0) {
				arr[start+x-1] = -arr[start+x-1];
			}
		}

		for(int i=start;i<size;i++){
			if(arr[i]>0)
				return i-start+1;
		}
		return size+1;
	}
}
class Practice42{
	public static void main(String[] args) {
		int[] arr = {5, 4, 3, 2, 0};
		// {0, -10, 1, 3, -20};
		System.out.println(new Solution().getMissingSmallestPositiveNumber(arr));
	}
}