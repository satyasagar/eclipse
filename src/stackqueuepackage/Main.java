package stackqueuepackage;

public class Main {
	public static void main(String[] args){
		Stack stack = new Stack();
		stack.push(45);
		stack.push(78);
		stack.push(98);
		stack.push(23);
		stack.displayStack();
		stack.pop();
		System.out.println("After popping");
		stack.displayStack();
		
		System.out.println("Queue Implementation");
		Queue q = new Queue();
		q.push(45);
		q.push(90);
		q.push(21);
		q.push(34);
		q.push(87);
		q.displayQueue();
		q.pop();
		q.pop();
		System.out.println("After Popping");
		q.displayQueue();
	}
}
