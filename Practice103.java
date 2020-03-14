// reverse words in string 
class Solution{
	public void reverseString(String s){
		// System.out.println(s);
		String[] str = s.trim().split("\\.");
		for(int i=str.length-1;i>=0;i--){
			System.out.print(str[i]+".");
		}
		System.out.println();
	}
}
public class Practice103{
	public static void main(String[] args) {
		// String[] str = args[0].split(".");
		new Solution().reverseString(args[0]);
	}
}