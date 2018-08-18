package derekbanasHashTables3;

public class HashFunction3 {
	
	WordList[] theArray;
	int arraySize;
	public String[][] elementsToAdd = {
			{ "ace", "Very good" },
			{ "act", "Take action" },
			{ "add", "Join (something) to something else" },
			{ "age", "Grow old" },
			{ "ago", "Before the present" },
			{ "aid", "Help, assist, or support" },
			{ "aim", "Point or direct" },
			{ "air", "Invisible gaseous substance" },
			{ "all", "Used to refer to the whole quantity" },
			{ "amp", "Unit of measure for the strength of an electrical current" },
			{ "and", "Used to connect words" }, { "ant", "A small insect" },
			{ "any", "Used to refer to one or some of a thing" },
			{ "ape", "A large primate" },
			{ "apt", "Appropriate or suitable in the circumstances" },
			{ "arc", "A part of the circumference of a curve" },
			{ "are", "Unit of measure, equal to 100 square meters" },
			{ "ark", "The ship built by Noah" },
			{ "arm", "Two upper limbs of the human body" },
			{ "art", "Expression or application of human creative skill" },
			{ "ash", "Powdery residue left after the burning" },
			{ "ask", "Say something in order to obtain information" },
			{ "asp", "Small southern European viper" },
			{ "ass", "Hoofed mammal" },
			{ "ate", "To put (food) into the mouth and swallow it" },
			{ "atm", "Unit of pressure" },
			{ "awe", "A feeling of reverential respect" },
			{ "axe", "Edge tool with a heavy bladed head" },
			{ "aye", "An affirmative answer" } };
	
	HashFunction3(int size){
		arraySize = size;
		theArray = new WordList[size];
		for(int i=0; i< arraySize; i++){
			theArray[i] = new WordList();
		}
		addTheArray(elementsToAdd);
	}
	
	public void addTheArray(String[][] elementsToAdd){
		for(int i=0;i<elementsToAdd.length; i++){
			String word = elementsToAdd[i][0];
			String definition = elementsToAdd[i][1];
			
			Word newWord = new Word(word, definition);
			insert(newWord);
		}
	}
	
	public Word find(String wordToFind){
		int hashKey = stringHashFunction(wordToFind);
		Word theWord = theArray[hashKey].find(hashKey, wordToFind);
		return theWord;
	}
	
	public void insert(Word newWord){
		String wordToHash = newWord.theWord;
		int hashKey = stringHashFunction(wordToHash);
		
		theArray[hashKey].insert(newWord, hashKey);
	}
	
	public void displayTheArray(){
		for(int i=0; i<arraySize; i++){
			System.out.println("theArray Index "+i);
			theArray[i].displayWordList();
		}
	}
	
	public int stringHashFunction(String wordToHash){
		int hashKeyValue = 0;
		for(int i=0; i<wordToHash.length(); i++){
			int charCode = wordToHash.charAt(i)-96;
			int hKVTemp = hashKeyValue;
			hashKeyValue = (hashKeyValue *27 + charCode)%arraySize;
			System.out.println("Hash Key value "+ hKVTemp + 
					" * 27 + Character Code "+ charCode +
					" % arraySize "+ arraySize + " = "+hashKeyValue);
		}
		System.out.println();
		return hashKeyValue;
	}

}
