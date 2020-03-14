// Smallest window in a string containing all the characters of another string
class Solution{
	public String smallestWindow(String str, String text){
		if( text.length() > str.length()) return "-1";
		int[] textAl = countAlphabet(text);
		int[] strAl = new int[26];
		int minLength = Integer.MAX_VALUE;
		int sIndex = 0, eIndex = -1, startIndex = 0, count = 0;
		String result = "";

		for(eIndex = 0; eIndex < str.length(); eIndex++){
			strAl[str.charAt(eIndex) - 'a']++;
			/*if(count == 0){
				sIndex = eIndex;
			}*/
			// (textAl[str.charAt(eIndex) - 'a'] != 0)
			if((textAl[str.charAt(eIndex) - 'a'] >= strAl[str.charAt(eIndex) - 'a'])){
				count++;
			}
			
			if(count == text.length()){
				while(textAl[str.charAt(sIndex) - 'a'] == 0 || strAl[str.charAt(sIndex) - 'a'] > textAl[str.charAt(sIndex) - 'a']){
					if(strAl[str.charAt(sIndex) - 'a'] > textAl[str.charAt(sIndex) - 'a']){
						strAl[str.charAt(sIndex) - 'a']--;
						sIndex++;
					}
				}
				if( ( eIndex - sIndex + 1 ) < minLength ){
					result = str.substring(sIndex, eIndex+1);
					minLength = eIndex - sIndex + 1;
					// startIndex = sIndex;
				}
			}
		}
		if(count != text.length()) return "-1";
		return result;
	}
	private int[] countAlphabet(String text){
		int[] arr = new int[26];
		for(int i=0;i<text.length();i++){
			arr[text.charAt(i) - 'a']++;
		}
		return arr;
	}
}
class Practice129{
	public static void main(String[] args) {
		String str = args[0];
		String text = args[1];
		System.out.println(new Solution().smallestWindow(str, text));
	}
}	