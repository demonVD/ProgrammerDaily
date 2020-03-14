// Minimum Number of Platforms Required for a Railway/Bus Station
import java.util.Arrays;
class Solution{

	public int getMin(int[] arr, int[] depr){
		Arrays.sort(arr);
		Arrays.sort(depr);
		int i = 0, j = 0;
		int minRailStation = 0, arrival = 0;
		int length = arr.length;
		while(i < length && j < length){
			if(arr[i] <= depr[j]){
				arrival++;
				i++;
				if(minRailStation < arrival){
					minRailStation = arrival;
				}
			}
			else{
				arrival--;
				j++;
			}
			
		}
		return minRailStation;
	}

}
class Practice62{
	public static void main(String[] args){
		int[] arr = {900, 940, 950, 1100, 1500, 1800};
		int[] depr = {910, 1200, 1120, 1130, 1900, 2000};

		System.out.println(new Solution().getMin(arr, depr));
	}
}