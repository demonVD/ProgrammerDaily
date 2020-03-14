// Leaders in an array
import java.util.ArrayList;
class Solution{
	public void leaders(int[] arr){
		display(leadersHelper(arr));
	}
	private Integer[] leadersHelper(int[] arr){
        ArrayList<Integer> resultList = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		for(int i=arr.length-1;i>=0;i--){
			if(arr[i]>=max){
				// str.append(arr[i] + " ");
				resultList.add(arr[i]);
				max = arr[i];
			}
		}

		Integer[] result = new Integer[resultList.size()];
		result = resultList.toArray(result);
		return result;
	}
	private void display(Integer[] result){
		StringBuilder str = new StringBuilder();
        for(int i=result.length-1;i>=0;i--) str.append(result[i]+" ");
        System.out.println(str.toString());
	}
}
class Practice84{
	public static void main(String[] args) {
		String[] chars = args[0].split(" ");
		int[] arr = new int[chars.length];
		for(int i=0;i<arr.length;i++) arr[i] = Integer.parseInt(chars[i]);
		new Solution().leaders(arr);
	}
}