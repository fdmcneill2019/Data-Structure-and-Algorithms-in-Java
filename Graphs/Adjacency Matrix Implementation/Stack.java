/* A stack implemented using an int array. */
public class Stack {
	private int size;
	private int[] stackArray;
	private int top;
	
	public Stack(int size) {
		this.size = size;
		stackArray = new int[this.size];
		top = -1;
	}
	
	public void push(int integer) {
		++top; 
		stackArray[top] = integer;
	}
	
	public int pop() {
		top--;
		return stackArray[top];
	}
	
	public int peek() {
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
}
