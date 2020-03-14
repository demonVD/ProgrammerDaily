// Immediate Smaller Element 
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
class Solution{
	public void immediateSmallerElement(int[] arr){
		for(int i=1;i<arr.length;i++){
			if(arr[i-1] > arr[i]){
				System.out.print(arr[i] + " ");
			}else{
				System.out.print("-1 ");
			}
		}
		System.out.print("-1");
	}
}
class Practice82{
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] chars = args[0].split(" ");
		int[] arr = new int[chars.length];
		for(int i=0;i<arr.length;i++) arr[i] = Integer.parseInt(chars[i]);
		new Solution().immediateSmallerElement(arr);
	}
}