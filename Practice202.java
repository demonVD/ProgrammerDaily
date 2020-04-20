// https://leetcode.com/problems/longest-common-prefix/
class Solution{
	public String longestCommonPrefix(String[] strs) {
		int shortestLength = Integer.MAX_VALUE;
		int index = 0;
		for(int i=0;i<strs.length;i++){
			if(shortestLength > strs[i].length()){
				shortestLength = strs[i].length();
				index = i;
			}
		}
		System.out.println("Index :: " + index + " :: " + shortestLength);
		// return "";
		char[] smallest = strs[index].toCharArray();
		// StringBuilder str = new StringBuilder();
		System.out.println("First Stop");
		int matchedIndex = shortestLength;
		for(int i = 0; i < matchedIndex; i++){
			System.out.println("i :: " + i);
			char[] current = strs[i].toCharArray();
			int indexTillMatched = 0;
			for(int j = 0; j < matchedIndex; j++){
				System.out.println("j :: " + j);
				if(current[j] == smallest[j]){
					System.out.println(current[j] + " " + smallest[j]);
				System.out.println("indexTillMatched :: " + indexTillMatched); 
					indexTillMatched++;
				}
			}
			if(indexTillMatched < matchedIndex){
				matchedIndex = indexTillMatched;
			}
		}
		return strs[index].substring(0, matchedIndex);
    }
}
class Practice202{
	public static void main(String[] args) {
		String[] strs = {"flower", "flow", "fl"};
		Solution solution = new Solution();
		System.out.println(solution.longestCommonPrefix(strs));

	}
}