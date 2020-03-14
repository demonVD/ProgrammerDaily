// Duplicates in an array in O(n) and by using O(1) extra space
class Solution{
	public void printDuplicates(int[] arr){
		int n = arr.length;
		for(int i=0;i<n;i++){
			int pos = arr[i]%n;
			arr[pos] = arr[pos] + n;
		}
		for(int i=0;i<n;i++)
		{
			if ((arr[i]/n)>1) {
				System.out.print(i+" ");
			}
		}
	}
}	
class Practice86{
	public static void main(String[] args) {
		String[] elements = args[0].split(" ");
		int[] arr = new int[elements.length];
		for(int i=0;i<elements.length;i++){
			arr[i] = Integer.parseInt(elements[i]);
		}
		new Solution().printDuplicates(arr);
	}
}