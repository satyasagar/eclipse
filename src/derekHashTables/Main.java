package derekHashTables;

public class Main {
	public static void main(String[] args){
		//String[] inputArray = {"3","6","21","19","13"};
		String[] inputArray = { "100", "510", "170", "214", "268", "398",
				"235", "802", "900", "723", "699", "1", "16", "999", "890",
				"725", "998", "978", "988", "990", "989", "984", "320", "321",
				"400", "415", "450", "50", "660", "624" };
		
		String[] inputArray2 = { "30", "60", "90", "120", "150", "180",
				"210", "240", "270", "300", "330", "360", "390", "420", "450",
				"480", "510", "540", "570", "600", "989", "984", "320", "321",
				"400", "415", "450", "50", "660", "624" };
		HashFunction hf = new HashFunction(31);
		//hf.hashFunction1(inputArray, hf.theArray);
		hf.hashFunction2(inputArray, hf.theArray);
		hf.findKey("998");
		hf.increaseHashTableSize(60);
		hf.displayHashTable();
		hf.fillArray();
		hf.doubleHashFunc(inputArray2, hf.theArray);		
		hf.displayHashTable();
		hf.findKeyDblHashed("989");
	}
}
