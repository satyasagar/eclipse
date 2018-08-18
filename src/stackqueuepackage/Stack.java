package stackqueuepackage;



public class Stack {
	Node top;
	
	public void push(int data){
		if(top == null){
			top = new Node(data);
			top.value = data;
			return;
		}
		Node newNode = new Node(data);
		newNode.next = top;
		top = newNode;
	}
	
	public int pop(){
		int popped = top.value;
		top = top.next;
		return popped;
	}
	
	public void displayStack(){
		System.out.println("--Recently pushed first--");
		Node current = top;
		while(current.next != null){
			current.displayNode();
			current = current.next;
		}
		current.displayNode();
	}
}
