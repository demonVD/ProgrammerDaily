// Given an integer k and a string s, 
// find the length of the longest substring that contains at most k distinct characters.
import java.util.HashSet;
class Solution{
	public String getMaxLengthSubstringKdistinctCharacters(String str, int k){
		HashSet<Character> set = new HashSet<>();
		int[] ch = new int[26];
		int sp = 0, startIndex = -1, maxLength = Integer.MIN_VALUE;
		for(int i=0;i<str.length();i++){
			System.out.println("Current Char : " + str.charAt(i));
			ch[str.charAt(i) - 'a']++;
			if(!set.contains(str.charAt(i))) set.add(str.charAt(i));
			// System.out.println(set.size());
			if(set.size() > k){
				for(Character c : set){
					System.out.print(c+" ");
				}
				System.out.println();
				System.out.println("Starting Character : " + str.charAt(sp));
				if(--ch[str.charAt(sp) - 'a'] == 0) set.remove(str.charAt(sp));
				sp++;
			}
			if(set.size() == k){
				int tempLength = i - sp + 1;
				if(maxLength < tempLength){
					maxLength = tempLength;
					startIndex = sp;
				}
			}
		}	
		return str.substring(startIndex, startIndex + maxLength);
	}
}
class Practice56{
	public static void main(String[] args) {
		System.out.println(new Solution().getMaxLengthSubstringKdistinctCharacters("wlrbbmqbhcdarzowkkyhiddqsc"+
			"dxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco", 5));
	}	
}