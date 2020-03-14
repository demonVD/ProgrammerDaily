// Count and Say
import java.util.HashMap;
class Solution{
	private static HashMap<Integer, String> map;
	Solution(){
		map = new HashMap<Integer, String>();
		map.put(1, "1");
	}
	public void countAndSay(int n){
		System.out.println(countAndSayHelper(n).toString());
	}
	private StringBuilder countAndSayHelper(int n){
		StringBuilder str = new StringBuilder();
		StringBuilder result = new StringBuilder();
		if(map.containsKey(n)){
			return new StringBuilder(map.get(n)); 	
		} 
		result.append(countAndSayHelper(n-1));
		int count = 1;
		int i=0;
		for(i=0;i<result.length()-1;i++){
			if(result.charAt(i) == result.charAt(i+1)){
				count++;
			}
			else{
				str.append(count+""+result.charAt(i));
				count = 1;
			}
		}
		str.append(count+""+result.charAt(i));
		map.put(n, str.toString());
		return str;
	}
}
class Practice114{
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		new Solution().countAndSay(n);
	}
}