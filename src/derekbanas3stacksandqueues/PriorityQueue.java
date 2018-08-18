package derekbanas3stacksandqueues;

import java.util.Arrays;

public class PriorityQueue {
	private int front, rear, numberOfItems=0;
	private int queueSize;
	private String[] queueArray;
	
	PriorityQueue(int size){
		this.queueSize = size;
		queueArray = new String[size];
		Arrays.fill(queueArray, "-1");
	}
	
	public void priorityInsert(String input){
		int i;
		
		if(numberOfItems ==0){
			insert(input);
		}else{
			for(i=numberOfItems-1; i>=0; i--){
				if(Integer.parseInt(input)>Integer.parseInt(queueArray[i])){
					queueArray[i+1] = queueArray[i];
				}else break;
			}
			queueArray[i+1] = input;
			rear++;
			numberOfItems++;
		}
	}
	
	private void insert(String input){
		if(numberOfItems+1 <= queueSize){
			queueArray[rear] = input;
			rear++;
			numberOfItems++;
			System.out.println("INSERT "+input+" Was added to the Queue\n");
		}else{
			System.out.println("Sorry But the Queue is full.");
		}
	}
}
