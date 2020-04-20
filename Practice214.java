// https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/530/week-3/3301/
import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Solution {
    public boolean checkValidString(String s) {
    	Stack<Integer> stack1 = new Stack<>();
    	Stack<Integer> stack2 = new Stack<>();
    	// Stack<Character> stack3 = new Stack<>();
    	char c = '!';
    	for(int i=0;i<s.length();i++){
    		c = s.charAt(i);
    		if(c == '*') stack1.push(i);
    		else if(c == '(') stack2.push(i);
    		else{
    			if(!stack2.empty()){
    				stack2.pop();
    			}
    			else if(!stack1.empty()){
    				stack1.pop();
    			}
    			else{
    				return false;
    			}
    		}
    	}
    	int stack2Index = -1;
    	int stack1Index = -1;
    	while(!stack2.empty() && !stack1.empty()){
    		stack2Index = stack2.peek();
    		stack1Index = stack1.peek();
    		if(stack1Index < stack2Index){
    			return false;
    		}
    		stack1.pop();
    		stack2.pop();
    	}
    	if(!stack2.empty()) return false;
        return true;	
    }
}
class Practice214{
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		Solution solution = new Solution();
		System.out.println(solution.checkValidString(s));
	}
}