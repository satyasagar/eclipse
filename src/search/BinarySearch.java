package search;

public class BinarySearch {
	public void Search(int[] array, int key){
		int i = SearchRec(array, key, 0, array.length-1);
		if(i == 0)
			System.out.println("Element doesn't exist in the array");
		else
			System.out.printf("Element exists at %d position", i+1);
	}
	
	private int SearchRec(int[] array, int key, int minIndex, int maxIndex){
		if(key<array[minIndex] || key>array[maxIndex]){
			return 0 ;
		}
		int cue = (minIndex+maxIndex)/2;
		if(key == array[cue]){
			return cue;
		}
		else if(key < array[cue]){
			return SearchRec(array, key, minIndex, cue-1);
		}
		else if(key > array[cue]){
			return SearchRec(array, key, cue+1, maxIndex);
		}
		return 0;
	}
}
