// Remove Duplicate characters from a string
class Solution{
	public String removeDuplicates(String str){
		char[] arr = str.toCharArray();
		Pair[] count = new Pair[26];
		for(int i=0;i<26;i++){
			count[i] = new Pair(0, -1);
		}
		for(int i=0;i<arr.length;i++){
			int index = arr[i] - 'a';
			// System.out.println("Index :: " + index);
			count[index].x++;
			if(count[index].y == -1){
				count[index].y = i;
			}
		}
		for(int i=0;i<arr.length;i++){
			int index = arr[i] - 'a';
			if(count[index].y != i && count[index].x > 1){
				count[index].x--;
				arr[i] = '@';
			}
		}
		StringBuilder s = new StringBuilder();
		for(int i=0;i<arr.length;i++){
			if(arr[i]!='@')
				s.append(arr[i]);
			// System.out.print(arr[i] + " ");
		}
		// System.out.println();
		return s.toString();
	}
}
class Pair{
	int x;
	int y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}
class Practice181{
	public static void main(String[] args){
		String str = "geeksforgeeks";
		Solution solution = new Solution();
		System.out.println(solution.removeDuplicates(str));	
	}
}