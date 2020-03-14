// Minimum Character Required to make a string palindrome
class Solution{
	public int charRequired(String str){
		int[] arr = new int[26];
		for(int i=0;i<str.length();i++){
			arr[str.charAt(i) - 'a']++;
		}
		int charRequired = 0;
		boolean singleChar = false;
		if( str.length()%2 != 0 ){
			singleChar = true;
		}
		for(int i=0;i<str.length();i++){
			char c = str.charAt(i);
			int count = arr[c - 'a'];
			if(count == 1 && !singleChar){
				charRequired++;
				singleChar = !singleChar;
			}
			else if(count%2 != 0){
				if(!singleChar)
			}
		}
	}
}