package derekHashTables;

import java.util.ArrayList;
import java.util.Arrays;

public class HashFunction {
	String[] theArray;
	int arraySize;
	
	HashFunction(int size){
		this.arraySize = size;
		theArray = new String[arraySize];
		fillArray();
	}
	public void fillArray(){
		Arrays.fill(theArray, "-1");	
	}
	
	public void hashFunction1(String[] inputArray, String[] hashArray){
		for(int n = 0; n< inputArray.length; n++){
			int hashIndex = Integer.parseInt(inputArray[n]);
			hashArray[hashIndex] = inputArray[n];
		}
	}
	
	public void hashFunction2(String[] inputArray, String[] hashArray){
		for(int n=0; n< inputArray.length; n++){
			int hashIndex = Integer.parseInt(inputArray[n])%arraySize;
			while(hashArray[hashIndex]!="-1"){
				System.out.println("Collision Occured at "+hashIndex);
				++hashIndex;
				hashIndex %= arraySize;
			}
			System.out.println("Inserting "+inputArray[n]+" at index: "+ hashIndex);
			hashArray[hashIndex] = inputArray[n];
		}
	}
	
	public void doubleHashFunc(String[] inputArray, String[] hashArray){
		for(int n=0; n< inputArray.length; n++){
			int hashIndex = Integer.parseInt(inputArray[n])%arraySize;
			int stepDistance = 5-(Integer.parseInt(inputArray[n])%5);
			while(hashArray[hashIndex]!="-1"){
				System.out.println("Collision Occured at "+hashIndex);
				hashIndex+=stepDistance;
				hashIndex %= arraySize;
			}
			System.out.println("Inserting "+inputArray[n]+" at index: "+ hashIndex);
			hashArray[hashIndex] = inputArray[n];
		}
	}
	
	public String findKey(String key){
		int hashIndex = Integer.parseInt(key)%arraySize;
		while(theArray[hashIndex]!= "-1"){
			if(theArray[hashIndex]==key){
				System.out.println("Key "+key+" found at: "+hashIndex);
				return theArray[hashIndex];
			}
			hashIndex++;
			hashIndex %= arraySize;
		}
		return null;
	}

	public String findKeyDblHashed(String key){
		int hashIndex = Integer.parseInt(key)%arraySize;
		int stepDistance = 5 - (Integer.parseInt(key)%5);
		while(theArray[hashIndex]!= "-1"){
			if(theArray[hashIndex]==key){
				System.out.println("Key "+key+" found at: "+hashIndex);
				return theArray[hashIndex];
			}
			hashIndex += stepDistance;
			hashIndex %= arraySize;
		}
		return null;
	}
	
	public void increaseHashTableSize(int minvalue){
		int newArraySize = getNextPrime(minvalue);
		System.out.println("New Size : "+newArraySize);
		moveToNewTable(newArraySize);
	}
	
	private void moveToNewTable(int newSize){
		String[] cleanArray = cleanArray(theArray);
		arraySize = newSize;		
		theArray = new String[arraySize];
		fillArray();
		hashFunction2(cleanArray, theArray);
	}
	
	private String[] cleanArray(String[] arrayToClean){
		ArrayList<String> cleanList = new ArrayList<String>();
		for(String theValue: arrayToClean)
			if(theValue != "-1" && !theValue.equalsIgnoreCase(""))
				cleanList.add(theValue);
		return cleanList.toArray(new String[cleanList.size()]);		
	}
	
	private int getNextPrime(int minvalue){
		for(int i=minvalue; true; i++)
			if(isPrime(i))
				return i;
	}
	
	private boolean isPrime(int value){
		if(value%2 == 0)
			return false;
		for(int i = 3; i*i < value; i+=2){
			if(i%value == 0)
				return false;
		}
		return true;
	}
	
	public void displayHashTable() {
		int increment = 0;
		int numberOfRows = (arraySize/10)+1;
		for (int m = 0; m < numberOfRows; m++) {
			increment += 10;
			for (int n = 0; n < 71; n++)
				System.out.print("-");

			System.out.println();

			for (int n = increment - 10; n < increment; n++) {
				System.out.format("| %3s " + " ", n);
			}
			System.out.println("|");

			for (int n = 0; n < 71; n++)
				System.out.print("-");
			System.out.println();

			for (int n = increment - 10; n < increment; n++) {
				if(n>=arraySize)
					System.out.print("|      ");
				else if (theArray[n].equals("-1"))
					System.out.print("|      ");
				else
					System.out.print(String.format("| %3s " + " ", theArray[n]));
			}
			System.out.println("|");

			for (int n = 0; n < 71; n++)
				System.out.print("-");
			System.out.println();
		}
	}
}
