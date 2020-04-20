//   First Unique Character in a String
import java.util.Arrays;
class Solution {
    public int firstUniqChar(String s) {
 		Pair[] occurence = new Pair[26];
 		Arrays.fill(occurence, null);  
 		for(int i=0;i<s.length();i++){
 			char c = s.charAt(i);
 			if(occurence[c - 'a'] == null){
 				occurence[c - 'a'] = new Pair(1,i);
 			}else{
 				occurence[c - 'a'].count++;
 			}
 		}
 		int minIndex = Integer.MAX_VALUE;
 		for(int i=0;i<s.length();i++){
 			char c = s.charAt(i);
 			if(occurence[c - 'a'] != null && occurence[c - 'a'].count < 2 && occurence[c - 'a'].firstOccIndex < minIndex){
 				minIndex = occurence[c - 'a'].firstOccIndex;
 			}
 		}
 		return minIndex;
    }
}
class Pair{
	int count;
	int firstOccIndex;
	Pair(int count, int firstOccIndex){
		this.count = count;
		this.firstOccIndex = firstOccIndex;
	}
}
class Practice211{
	public static void main(String[] args) {
		String s = "loveleetcode		";
		Solution solution = new Solution();
		System.out.println(solution.firstUniqChar(s));
	}
}