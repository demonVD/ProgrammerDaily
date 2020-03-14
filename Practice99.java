// intersection of 2 sorted arrays
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
class Solution{
	public void intersection(List<Integer> a, List<Integer> b){
		int i=0,j=0;
		ArrayList<Integer> c = new ArrayList<>();
		System.out.println("a size" + a.size() + " b size : " + b.size());
		while( i < a.size() && j < b.size() ){
			System.out.println("arr[i] : " + a.get(i) + " arr[j] : " + b.get(j));
			
			if(a.get(i) < b.get(j)){
				System.out.println("Inside if");
				System.out.println("arr[i] : " + a.get(i) + " arr[j] : " + b.get(j));
				i++;	
			} 
			else if(a.get(i) > b.get(j)){
				System.out.println("Inside else if");
				System.out.println("arr[i] : " + a.get(i) + " arr[j] : " + b.get(j));	
				j++;
			} 
			else if(a.get(i) == b.get(j)) {
				System.out.println("Inside else if equals");
				System.out.println("arr[i] : " + a.get(i) + " arr[j] : " + b.get(j));	
				c.add(a.get(i));
				i++;
				j++;
			}
			System.out.println(i<a.size());
			System.out.println(j<b.size());
		}
		if(c.size() == 0){
			System.out.println("-1");
		}
		else{
			for(int s : c){
				System.out.print(s+" ");
			}	
		}
		
	}

}
class Practice99{
	public static void main(String[] args) {
		String[] str1 = args[0].split(", ");
		String[] str2 = args[1].split(", ");		
		Integer[] arr1 = new Integer[str1.length];
		Integer[] arr2 = new Integer[str2.length];
		for(int i=0;i<arr1.length;i++) arr1[i] = Integer.parseInt(str1[i]);
		for(int i=0;i<arr2.length;i++) arr2[i] = Integer.parseInt(str2[i]);
		List<Integer> a = Arrays.asList(arr1);
		List<Integer> b = Arrays.asList(arr2);
		new Solution().intersection(a, b);
	}
}