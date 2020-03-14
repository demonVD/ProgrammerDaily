// Median of 2 arrays
class Solution{
	public double median(int[] arr1, int[] arr2){
		int length = arr1.length + arr2.length;
		int index = (length%2==0) ? length/2 : (length-1)/2;
		int i=0,j=0,k=0;
		int[] arr = new int[index+1]; 
		
		while(i < arr1.length && j < arr2.length && k <= index){
			if(arr1[i] < arr2[j]){
				arr[k++] = arr1[i++];
			}
			else{
				arr[k++] = arr2[j++];
			}
		}
		while(i < arr1.length && k <= index){
			arr[k++] = arr1[i++];
		}
		while(j < arr2.length && k <= index){
			arr[k++] = arr2[j++];	
		}
		if(length%2 == 0){
			return (arr[index] + arr[index-1])/2.0;
		}
		else{
			return arr[index]/1.0;
		}
	}
}
class Practice98{
	public static void main(String[] args) {
		String[] str1 = args[0].split(" ");
		String[] str2 = args[1].split(" ");
		int[] arr1 = new int[str1.length];
		int[] arr2 = new int[str2.length];
		for(int i=0;i<arr1.length;i++) arr1[i] = Integer.parseInt(str1[i]);	
		for(int i=0;i<arr2.length;i++) arr2[i] = Integer.parseInt(str2[i]);
		System.out.println(new Solution().median(arr1, arr2));
	}
}