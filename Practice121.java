// K largest elements
class Solution{
	public void kLargestElement(int[] arr, int k){
		quickSelect(arr, k-1, 0, arr.length-1);
		displayKElements(arr, k);
	}
	private void displayKElements(int[] arr, int k){
		for(int i=0;i<k;i++){
			System.out.print(arr[arr.length-i-1] + " ");
		}
		System.out.println();
	}
	private void display(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	private void quickSelect(int[] arr, int k, int low, int high){
		if(low < high){
			int pi = partition(arr, low, high);
			// displayKElements(arr, arr.length);
			if(pi == k) return;
			else if(pi > k){
				System.out.println("Low : " + low + "pi : " + pi);
				quickSelect(arr, k, low, pi-1);
			} 
			else{
				System.out.println("pi : " + pi + "high : " + high);
				quickSelect(arr, k, pi+1, high);
			} 
		}
	}
	private int partition(int[] arr, int low, int high){
		int mid = (low + high)/2;
		System.out.println("Mid : " + mid);
		int pivot = arr[mid];
		int i = low-1;
		for(int j=low;j<=high;j++){
			if(arr[j] < pivot){
				i++;
				if(i == mid) mid = j;
				swap(arr, i, j);
			}
		}
		System.out.println("Mid : " + mid);
		if(i!=mid){
			swap(arr, i+1, mid);
			mid = i+1;
		} 
		display(arr);
		return mid;
	}
	private void swap(int[] arr, int i, int j){
		int temp = arr[i];	
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
class Practice121{
	public static void main(String[] args) {
		String[] str = args[0].trim().split(" ");
		int[] arr = new int[str.length];
		for(int i=0;i<str.length;i++){
			arr[i] = Integer.parseInt(str[i]); 
		}
		int k = Integer.parseInt(args[1]);
		Solution solution = new Solution();
		solution.kLargestElement(arr, k);
	}
}