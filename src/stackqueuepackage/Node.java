package stackqueuepackage;

public class Node {
	public int value;
	public Node next;
	
	public Node(int data){
		this.value = data;
	}
	
	public void displayNode(){
		System.out.println(this.value);
	}
}
