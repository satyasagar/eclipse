package derekbanasarrays;

public class Main {
	public static void main(String[] args){
		ArrayStructures array = new ArrayStructures();
		array.generateRandomArray();
		array.printArray();		
		System.out.println(array.doesArrayContainThisValue(18));
		array.deleteIndex(3);
		array.printArray();
		array.insertValue(55);
		array.printArray();
		array.linearSearchForValue(15);
	}

}
