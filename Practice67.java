// 2 Stack implementation using Single array 
class Stacks{
	int capacity;
	int[] arr;
	int top1;
	int top2;
	
	public Stacks(int capacity){
		this.capacity = capacity;
		arr = new int[capacity];
		top1 = -1;
		top2 = capacity;
	}

	public void push(int stackNumber, int data){
		if(stackNumber == 1){
			push1(data);
		}
		else if(stackNumber == 2){
			push2(data);
		}
		else{
			System.out.println(" not 1 or 2 Stack");
		}
	}

	private void push1(int data){
		if(top1 >= top2-1){
			System.out.println("Stack1 full");
			return;
		}
		arr[++top1] = data;
	}

	private void push2(int data){
		if(top2 <= top1+1){
			System.out.println("Stack2 full");
			return;
		}
		arr[--top2] = data;
	}

	public void pop(int stackNumber){
		if(stackNumber == 1){
			pop1();
		}
		else if(stackNumber == 2){
			pop2();
		}
		else{
			System.out.println("Not 1 or 2 Stack");
		}
	}

	private void pop1(){
		if(top1 <= -1){
			System.out.println("Stack 1 is empty");
			return;
		}
		System.out.println(arr[top1--]);
	}

	private void pop2(){
		if(top2 >= capacity){
			System.out.println("Stack 2 is empty");
			return ;
		}
		System.out.println(arr[top2++]);;
	}

	public void peek(int stackNumber){
		if(stackNumber == 1){
			peek1();
		}
		else if(stackNumber == 2){
			peek2();
		}
		else{
			System.out.println("Not 1 or 2");
		}
	}

	private void peek1(){
		if(top1 <= -1){
			System.out.println("Stack 1 is empty");
			return;
		}
		System.out.println(arr[top1]);
	}

	private void peek2(){
		if(top2 >= capacity){
			System.out.println("Stack 2 is empty");
			return;
		}
		System.out.println(arr[top2]);
	}
}
public class Practice67{
	public static void main(String[] args) {
		Stacks stacks = new Stacks(10);
		stacks.push(1, 1);stacks.push(1, 2);stacks.push(1, 3);stacks.push(1, 4);stacks.push(1, 5);stacks.push(1, 6);
		stacks.push(2, 1);stacks.push(2, 2);stacks.push(2, 3);stacks.push(2, 4);stacks.push(2, 5);
		stacks.peek(1);stacks.peek(2);
	}
}