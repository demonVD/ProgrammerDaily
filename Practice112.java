// TRIE Data Structure
// Longest Common Prefix

import java.util.List;
import java.util.ArrayList;
class TRIE{
	private static final int ALPHABET_SIZE = 26;
	class TRIENode{
		TRIENode[] children = new TRIENode[ALPHABET_SIZE];
		boolean isEndOfWord;
		TRIENode(){
			isEndOfWord = false;
			for(int i=0;i<ALPHABET_SIZE;i++){
				children[i] = null;
			}
		}
	}
	static TRIENode root;

	TRIE(){
		root = new TRIENode();
	}
	public void insert(String s){
		TRIENode temp = root;
		for(int i=0;i<s.length();i++){
			if(temp.children[Character.toLowerCase(s.charAt(i)) - 'a'] == null){
				temp.children[Character.toLowerCase(s.charAt(i)) - 'a'] = new TRIENode();
			}
			temp = temp.children[s.charAt(i) - 'a'];
		}
		temp.isEndOfWord = true;
	}
	/*public void display(TRIENode root){
		if(root.isEndOfWord) return;
		for(int i=0;i<ALPHABET_SIZE;i++){
			if(root.children[i] != null){
				System.out.print((char)(i+97));
				display(root.children[i]);	
			}
		}
		System.out.println();
	}*/
	public boolean search(String str){
		int index = 0;
		TRIENode temp = root;
		boolean status = false;
		while(index < str.length() && temp.children[str.charAt(index) - 'a'] != null){
			status = status | true;
			temp = temp.children[str.charAt(index) - 'a'];
			if(index == str.length()-1 && !temp.isEndOfWord) return false;
			index++;
		}
		return status;
	}
	public String longestCommonPrefix(List<String> list){
		
		for(String s : list){
			insert(s);
		}

		TRIENode temp = root;
		StringBuilder result = new StringBuilder();
		int index = 0;
		boolean iterator = true;

		while(iterator && !temp.isEndOfWord){
			int count = 0;
			for(int i=0;i<ALPHABET_SIZE;i++){
				if(temp.children[i] != null){
					index = i;
					count += 1;
				}
			}
			if(count != 1){
				iterator = false;	
			} 
			else{
				temp = temp.children[index]; result.append((char)(index + 97));	
			}
		}
			
		return result.toString();
		// return "";
	}
}

class Practice112{
	public static void main(String[] args) {
		TRIE trie = new TRIE();
		/*trie.insert("abc");
		trie.insert("vishant");
		trie.insert("geeks");
		trie.insert("geeksforgeeks");*/
		// trie.display(trie.root);
		/*System.out.println(trie.search("vishant"));
		System.out.println(trie.search("geeksforgeeks"));*/
		List<String> list = new ArrayList<String>();
		list.add("geeks");
		list.add("geeksforgeeks");
		list.add("gee");
		list.add("visha");
		System.out.println(trie.longestCommonPrefix(list));
	}
}