package derekbanas2;

public class ArrayStructures {
	private int[] theArray = new int[50];
	private int arraySize = 10;
	
	public void createRandomArray(){
		for(int i=0;i<arraySize; i++){
			theArray[i] = (int)(Math.random()*10)+10;
		}
	}
	
	public void printArrayHorizontally(){
		System.out.println("---------------------------------------");
		for(int i=0;i<arraySize;i++){
			System.out.print("| "+i+" ");
		}
		System.out.println();
		for(int i=0;i<arraySize;i++){
			System.out.print("| "+theArray[i]);
		}
		System.out.println("\n---------------------------------------");
	}
	
	public void linearSearch(int value){
		String printStatement = "Element exists the position: ";
		boolean elementExists = false;
		for(int i=0; i<arraySize; i++){
			System.out.println(i);
			printArrayHorizontally();
			if(value == theArray[i]){
				printStatement += i+" ";
				elementExists = true;
			}
		}
		if(!elementExists)
			printStatement += "None";
		System.out.println(printStatement);
	}
	
	public void bubbleSort(){
		for(int i=arraySize-1; i>1; i--){
			for(int j=0; j<i; j++){
				if(theArray[j] > theArray[j+1]){
					swapValues(j, j+1);
				}
				//printArrayHorizontally();
			}			
		}
		printArrayHorizontally();
	}
	
	private void swapValues(int i, int j){
		int temp = theArray[i];
		theArray[i] = theArray[j];
		theArray[j] = temp;
	}
	
	public void binarySearcForValue(int value){
		int lowIndex = 0;
		int highIndex = arraySize;
		
		while(lowIndex<=highIndex){
			int middleIndex = (lowIndex+highIndex)/2;
			if(theArray[middleIndex] < value) lowIndex = middleIndex+1;
			else if(theArray[middleIndex] > value) highIndex = middleIndex-1;
			else{
				System.out.printf("\nFound a match for "+value+" at Index "+middleIndex);
				lowIndex = highIndex+1;
			}
			//printArrayHorizontally();
		}
	}
	
	public void selectionSort(){
		for(int i=0; i<arraySize; i++){
			int minimum = i;
			for(int j = i; j<arraySize; j++){
				if(theArray[j]<theArray[minimum])
					minimum = j;
			}
			swapValues(i, minimum);
		}
		printArrayHorizontally();
	}
	
	public void insertionSort(){
		for(int i=1; i<arraySize; i++){
			int j=i;
			int key = theArray[i]; 
			while((j>0)&&(theArray[j-1]>key)){
				theArray[j] = theArray[j-1];
				j--;
			}
			theArray[j]=key;
			printArrayHorizontally();
		}
	}
}
