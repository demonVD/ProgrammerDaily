// Special Stack 
// getMin in O(1) time and O(n) extra space
import java.util.Stack;
class Solution{
	Stack<Integer> auxStack;
	Solution(){
		auxStack = new Stack<>();
	}
	public void insert(int key, Stack<Integer> stack){
		stack.push(key);
		if(!auxStack.empty()){
			if(key < auxStack.peek()){
				auxStack.push(key);
			}
			else{
				auxStack.push(auxStack.peek());
			}
		}
		else{
			auxStack.push(key);
		}
	}
	public int pop(Stack<Integer> stack){
		if(stack.empty()) return -1;
		int element = stack.pop();
		auxStack.pop();
		// System.out.println("Element deleted is " + element);
		return element;
	}
	public int min(Stack<Integer> stack){
		if(stack.empty()) return -1;
		int element = auxStack.peek();
		// System.out.println("Min Element is "+ element);
		return element;
	}
	public boolean isEmpty(Stack<Integer> stack){
		if(stack.empty()){
			return true;
		}
		return false;
	}
	public boolean isFull(Stack<Integer> stack, int n){
		Stack<Integer> s = new Stack<>();
		int count = 0;
		while(!stack.empty() && count<n){
			s.push(stack.pop());
			count++;
		}
		while(!s.empty()){
			stack.push(s.pop());
		}
		if(count == n) return true;
		return false;
	}


}
class Practice48{
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		Solution solution = new Solution();
		solution.insert(1, stack);
		solution.insert(2, stack);
		solution.insert(3, stack);
		System.out.println(solution.min(stack));
		System.out.println(solution.isFull(stack, 6));
		System.out.println(solution.isEmpty(stack));
		solution.pop(stack);
		System.out.println(solution.min(stack));
		solution.pop(stack);
		System.out.println(solution.min(stack));
		solution.pop(stack);
		System.out.println(solution.min(stack));
	}
}