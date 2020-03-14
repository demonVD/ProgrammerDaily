// Given two strings str1 and str2 and below operations that can performed on str1.
 // Find minimum number of edits (operations) required to convert ‘str1′ into ‘str2′.
class Solution{
	int[] charStr1;
	int[] charStr2;
	Solution(){
		charStr1 = new int[26];
		charStr2 = new int[26];
	}
	public int getEdit(String str1, String str2){
		int insert = 0, delete = 0;
		charStr1 = countChar(str1);
		// display(charStr1);
		charStr2 = countChar(str2);
		// display(charStr2);
		for(int i=0;i<charStr1.length;i++){
			if(charStr1[i] > charStr2[i]){
				insert += (charStr1[i] - charStr2[i]);
			}
			else if(charStr1[i] < charStr2[i]){
				delete += (charStr2[i] - charStr1[i]);
			}
		}
		int replace = Math.min(insert, delete);
		int operations = replace + Math.abs(insert - delete);
		// System.out.println("INsert : " + insert + " delete : " + delete);
		return operations;
	}
	private int[] countChar(String str1){
		int[] arr = new int[26];
		for(int i=0;i<str1.length();i++){
			arr[str1.charAt(i) - 'a']++;
		}
		return arr;
	}
	private void display(int[] arr){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
}
class Practice53{
	public static void main(String[] args) {
		String str1 = "gesek";
		String str2 = "geek";
		Solution solution = new Solution();
		System.out.println(solution.getEdit(str1, str2));
	}
}