package linkedlistpackage;

public class LinkedList {
	Node head;
	
	public void append(int value){
		if(head == null){
			Node newNode = new Node();
			newNode.value = value;
			head = newNode;
			System.out.println("First element Inserted");
			return;
		}
		Node current = head;
		while(current.next != null){
			current = current.next;
		}
		Node newNode = new Node();
		current.next = newNode;
		newNode.value = value;	
		System.out.println("Appended");
	}
	
	public void prepend(int value){
		Node newNode = new Node();
		newNode.value = value;
		newNode.next = head;
		head = newNode;		
	}
	
	public void displayList(){
		Node current = head;
		while(current.next != null){
			current.displayNode();
			current = current.next;			
		}
		current.displayNode();
	}
	
	public void deleteValue(int value){
		if(head == null)return;
		Node current = head;
		if(current.value == value){
			head = current.next;
			return;
		}
		while(current.next!= null){
			if(current.next.value == value){
				current.next = current.next.next;
				return;
			}
			current =current.next;
		}
		System.out.printf("Linked List doesn't have element: %d\n", value);
	}
	
	public void find(int value){
		Node current = head;
		while(current.next != null){
			if(current.value == value){
				System.out.printf("Element %d exists in linked list\n",value);
				return;
			}
			current = current.next;
		}
		System.out.printf("Element %d does not exist in linked list\n",value);
		return;
	}
	
	public void insertAt(int index, int value){
		int i = 0;
		Node current = head;
		if(index == 0){
			Node newNode = new Node();
			newNode.next = head;
			newNode.value = value;
			head = newNode;
			return;
		}
		
		while(current.next != null && i+1 < index){
			current = current.next;
			i++;
		}
		Node newNode = new Node();
		newNode.next = current.next;
		current.next = newNode;
		newNode.value = value;		
	}
}
