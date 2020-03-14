// push pop and min in O(1) time 
import java.util.Stack;
class StackWrapper{
	Stack<Integer> realStack;
	Stack<Integer> minStack;
	
	public StackWrapper(){
		realStack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int item){
		realStack.push(item);
		if(minStack.empty()){
			minStack.push(item);
		}else{
			if(minStack.peek() < item){
				minStack.push(minStack.peek());
			}
			else{
				minStack.push(item);
			}
		}
	}

	public void pop(){
		if(realStack.empty()){
			System.out.println("Stack Is Empty");
			return;
		}
		int item = realStack.pop();
		System.out.println("Popped element is : " + item);
		minStack.pop();
	}

	public void peek(){
		if(realStack.empty()){
			System.out.println("Stack is Empty");
			return;
		}
		int item = realStack.peek();
		System.out.println("Element at top of Stack is : " + item);
	}

	public void min(){
		if(realStack.empty()){
			System.out.println("Stack is Empty");
			return;
		}
		int item = minStack.peek();
		System.out.println("Min Element is : " + item);
	}
}
class Practice68{
	public static void main(String[] args) {
		StackWrapper stack = new StackWrapper();
		stack.push(4);stack.push(3);stack.push(2);stack.push(1);
		stack.peek();stack.min();
		stack.pop();stack.min();stack.pop();stack.min();stack.pop();stack.min();stack.pop();stack.min();stack.pop();
	}
}