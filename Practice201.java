// Group Anagram Together
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution{
	public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap<Integer, List<Pair>> map = new hashMap<>();
        HashMap<Integer, HashMap<Integer, List<String>>> map = new HashMap<>();
        int minLength = strs[0].length();
        int maxLength = strs[0].length();
        for(String str : strs){
        	System.out.println("Str :: " + str);
			char[] arr = str.toCharArray();
			int sum = 0;
			if(minLength > str.length()){
				minLength = str.length();
			}
			if(maxLength < str.length()){
				maxLength = str.length();
			}
			for(int i = 0; i < arr.length; i++){
				sum += (arr[i] - 'a');
			}        	
			System.out.println("Sum :: " + sum);
			if(map.isEmpty() || !map.containsKey(str.length())){
				System.out.println("Map doesnt contain key");
				HashMap<Integer, List<String>> m = new HashMap<>();
				List<String> list = new ArrayList<>();
				list.add(str);
				m.put(sum, list);
				map.put(str.length(), m);
			}
			else{
				System.out.println("Contains key");
				HashMap<Integer, List<String>> m = map.get(str.length());
				if(m.containsKey(sum)){
					System.out.println("contain sum");
					List<String> l = m.get(sum);
					l.add(str);

					m.put(sum, l);
					map.put(str.length(), m);
				}
				else{
					System.out.println("Doesnt contain sum");
					List<String> l = new ArrayList<>();
					l.add(str);
					HashMap<Integer, List<String>> m2 = map.get(str.length());	
					m2.put(sum, l);
					map.put(str.length(), m2);
				}
				// map.get(str.length()).add(new Pair(sum, str));
			}
        }
        System.out.println("Min Length :: " + minLength + " maxLength :: " + maxLength);
        System.out.println("Map size :: " + map.size());
        return createListFromMap(map, minLength, maxLength);
    }
    private List<List<String>> createListFromMap(HashMap<Integer, HashMap<Integer, List<String>>> map, int minLength, int maxLength){
    	List<List<String>> list = new ArrayList<>();
    	for(int i=minLength;i<=maxLength;i++){
    		if(map.containsKey(i)){
    			HashMap<Integer, List<String>> m = map.get(i);
	    		for(int j : m.keySet()){
	    			// List<String> l = m.get()
	    			// if(m.)
	    			list.add(m.get(j));
	    		}
    		}
    	}
    	return list;
    }
    public void displayList(List<List<String>> list){
    	for(List<String> l : list){
    		for(String s : l){
    			System.out.print(s + " ");
    		}
    		System.out.println();
    	}
    }
}
class Pair{
	int hash;
	String str;
	Pair(int hash, String str){
		this.hash = hash;
		this.str = str;
	}
}
class Solution2{
	public List<List<String>> groupAnagrams(String[] strs) {
		HashMap<String, List<String>> map = new HashMap<>();
		for(int i=0;i<strs.length;i++){
			char[] c = strs[i].toCharArray();
			Arrays.sort(c);
			String s = String.valueOf(c);
			if(map.isEmpty() || !map.containsKey(s)){
				List<String> slist = new ArrayList<>();
				slist.add(strs[i]);
				map.put(s, slist);
			}
			else{
				List<String> l = map.get(s);
				l.add(strs[i]);
				map.put(s, l);
			}
		}
		List<List<String>> list = new ArrayList<>();
		for(String str : map.keySet()){
			System.out.print(str + " ");
			List<String> tempList = new ArrayList<>();
			for(String s : map.get(str)){
				tempList.add(s);
				System.out.print(s + " ");
			}
			list.add(tempList);
			System.out.println();
		}
		System.out.println();
		return list;
	}
	public void displayList(List<List<String>> list){
    	for(List<String> l : list){
    		for(String s : l){
    			System.out.print(s + " ");
    		}
    		System.out.println();
    	}
    }
}
class Practice201{
	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "nat", "tan", "ahah", "haha"};
		Solution2 solution = new Solution2();
		solution.displayList(solution.groupAnagrams(strs));
	}
}