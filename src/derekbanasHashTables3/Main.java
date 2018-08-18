package derekbanasHashTables3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		HashFunction3 wordHashTable = new HashFunction3(11);
		String wordLookUp = "a";
		while(!wordLookUp.equalsIgnoreCase("x")){
			System.out.println(": ");
			wordLookUp = input.nextLine();
			System.out.println(wordHashTable.find(wordLookUp));
		}
		wordHashTable.displayTheArray();
	}
}
