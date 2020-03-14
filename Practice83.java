// Rotating an Array 
class Solution{
	public int[] rotateArray(int[] arr, int n){
		if(n == 0 || n == arr.length) return arr;
		int[] temp = new int[n];
		int i=0, j=0;
		for(;i<n;i++) temp[i] = arr[i];
		while(i<arr.length){
			arr[j] = arr[i];
			i++;
			j++;  
		}
		i=0;
		for(;j<arr.length;j++){
			arr[j] = temp[i++];
		}
		return arr;
	}
	public void display(int[] arr){
		for(int i=0;i<arr.length;i++) System.out.print(arr[i]+" ");
	}
}
class Practice83{
	public static void main(String[] args) {
		String[] chars = args[0].split(" ");
		int[] arr = new int[chars.length];
		for(int i=0;i<chars.length;i++){
			arr[i] = Integer.parseInt(chars[i]);
		}
		Solution solution = new Solution();
		int[] rotatedArray = solution.rotateArray(arr, Integer.parseInt(args[1]));
		solution.display(rotatedArray);
	}
}