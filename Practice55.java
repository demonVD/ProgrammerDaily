// Smallest window in a string containing all the characters of another string
class Solution{
	public void getSmallestWindow(String s, String t){
		int[] strChar = new int[26];
		int[] textChar = new int[26];
		int count =0, sp = 0; // ep = -1;
		int minLength = Integer.MAX_VALUE;
		int spForMin = -1; // epForMin = -1;
		countTextChar(t, textChar);
		for(int i=0;i<s.length();i++){
			char character = s.charAt(i);
			if(textChar[character - 'a'] > 0){
				strChar[character - 'a']++;
				if(strChar[character - 'a'] <= textChar[character - 'a']){
					count++;
				}
				// if(count == 1) sp = i;
				if(count == t.length()){
					// ep = i;

					while(textChar[s.charAt(sp) - 'a'] == 0 || 
						strChar[s.charAt(sp) - 'a'] > textChar[s.charAt(sp) - 'a']) {
						if(strChar[s.charAt(sp) - 'a'] > textChar[s.charAt(sp) - 'a']) strChar[s.charAt(sp) - 'a']--;
						// strChar[s.charAt(sp) - 'a']--;
						sp++;
					}
						
					// int currLength = ep - sp + 1;
					int currLength = i - sp + 1;
					if(minLength > currLength){
						minLength = currLength;
						spForMin = sp;
						// epForMin = ep;	
					} 
					// count = 0;
					// reduceStrChar(strChar);
					// i = sp;
				} 
			}
		}
		if(spForMin == -1) {
			System.out.println("-1");
			return;
		}
		// for(int i =spForMin ;i<=epForMin;i++) System.out.print(s.charAt(i));
		// System.out.println(s);
		System.out.println(s.substring(sp, sp + minLength));
	}
	private void reduceStrChar(int[] arr){
		for(int i =0;i<26;i++){
			arr[i] = 0;
		}
	}
	private void countTextChar(String t, int[] textChar){
		for(int i=0;i<t.length();i++){
			textChar[t.charAt(i) - 'a']++;
		}
	}
}
class Practice55{
	public static void main(String[] args) {
		// String s = "mynameisvishant";
		// String t = "eis";
		new Solution().getSmallestWindow("mynameisvishant", "vis");
	}
}