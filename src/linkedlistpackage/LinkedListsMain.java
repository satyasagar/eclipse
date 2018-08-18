package linkedlistpackage;

public class LinkedListsMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList myList = new LinkedList();
		myList.append(2);
		myList.append(4);
		myList.append(5);
		myList.append(23);
		myList.displayList();
		myList.prepend(76);
		myList.prepend(75);
		System.out.println("-------After prepending------");
		myList.find(76);
		//myList.displayList();
		//myList.deleteValue(5);
		myList.deleteValue(76);
		//myList.deleteValue(234);
		System.out.println("\n---After Deletion----");
		myList.displayList();
		myList.find(76);
		myList.insertAt(0, 89);
		myList.displayList();
	}

}
