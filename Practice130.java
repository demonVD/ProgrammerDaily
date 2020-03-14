// Longest Pallindromic SubString
class Solution{
	public String longestPallindromicSubstring(String str){
		boolean[][] dp = new boolean[str.length()][str.length()];
		int length = str.length();
		int i=0,j=0;
		int maxLength = Integer.MIN_VALUE;
		int start = 0;
		
		// for substring of length 1
		maxLength = 1;
		int startIndex1 = -1;
		while(i<length && j<length){
			// start = i;
			dp[i++][j++] = true;
		}
		startIndex1 = 0;


		// for subString of length 2	
		int startIndex2 = -1;	
		int k = 2;
		for(i=0;i<length-1;i++){
			j = i+1;
			if(str.charAt(i) == str.charAt(j)){
				dp[i][j] = true;
				maxLength = k;
				start = i;
				if(startIndex2 == -1) startIndex2 = start;
			}
		}

		// for substring of length >= 3
		int startIndex3 = -1;
		for(k=3;k<=length;k++){
			for(i=0;i<length-k+1;i++){
				j = i+k-1;
				if(dp[i+1][j-1] && str.charAt(i) == str.charAt(j)){
					dp[i][j] = true;
					if(k > maxLength){
						maxLength = k;
						start = i;
						// if(startIndex3 == -1) startIndex3 = start;
					}
				}
			}
		}

		// finding longest pallindromic substring
		/*for(i=0;i<length;i++){
			for(j=0;j<length;j++){
				if(dp[i][j] && (maxLength < j-i+1)){
					maxLength = j-i+1;
					start = i;
				}
			}
		}*/
		display(dp);
		// System.out.println(start + " " + maxLength);
		// if(startIndex3 != -1) return str.substring(startIndex, start + maxLength);
		if(maxLength == 1) return str.substring(startIndex1, startIndex1 + maxLength); 
		else if(maxLength == 2) return str.substring(startIndex2, startIndex2 + maxLength);
		else return str.substring(start, start + maxLength);
	}
	private void display(boolean[][] dp){
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[0].length;j++){
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
}
class Practice130{
	public static void main(String[] args) {
		String str = "forgeeksskeegfor";
		// "aaaabbaa";

		System.out.println(new Solution().longestPallindromicSubstring(args[0].trim()));
	}	
}