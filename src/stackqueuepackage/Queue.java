package stackqueuepackage;

public class Queue {
	Node head, tail;
	
	public void push(int data){
		if(head == null){
			head = tail = new Node(data);
			return;
		}
		Node newNode = new Node(data);
		tail.next = newNode;
		tail = newNode;
	}
	
	public int pop(){
		if(head == null){
			System.out.println("No elements to pop");
		}
		int popped = head.value;
		head = head.next;
		return popped;
	}
	
	public void displayQueue(){
		System.out.println("Head to tail");
		Node current = head;
		while(current.next != null){
			current.displayNode();
			current = current.next;
		}
		current.displayNode();
	}
}
