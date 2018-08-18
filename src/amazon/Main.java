package amazon;

import java.util.ArrayList;
import java.util.List;

import amazon.SolutionClass.ListNode;
import amazon.SolutionClass.TreeNode;

public class Main {
	public static void main(String[] args) {
		SolutionClass sc = new SolutionClass();
		/*sc.twoSum(new int[] {2,7,9,11,15},9);*/
		//sc.subsets(new int[] {1,2,3});
/*		TreeNode tn = new TreeNode(10);
		TreeNode tn1 = new TreeNode(5);
		TreeNode tn2 = new TreeNode(8);
		tn.left = tn1;
		tn.right = tn2;
		List<Integer> list = sc.rightSideView(tn);
		for(int l: list)
			System.out.println(l);*/
/*		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		ListNode l4 = new ListNode(1);
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(4);
		l4.next = l5;
		l5.next = l6;
		ListNode l7 = new ListNode(2);
		ListNode l8 = new ListNode(6);
		l7.next = l8;
		ListNode res = sc.mergeKLists(new ListNode[] {l1,l4,l7});
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}*/
		//System.out.println(sc.numIslands(new char[][] {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
		/*List<List<String>> anagrams = sc.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
		for(List<String> l: anagrams) {
			for(String s: l)
				System.out.print(s+" ");
			System.out.println("--");
		}*/
		TreeNode tn1 = new TreeNode(1);
		TreeNode tn2 = new TreeNode(2);
		TreeNode tn3 = new TreeNode(3);
		TreeNode tn4 = new TreeNode(4);
		TreeNode tn5 = new TreeNode(5);
		TreeNode tn6 = new TreeNode(6);
		TreeNode tn7 = new TreeNode(7);
		TreeNode tn8 = new TreeNode(8);
		TreeNode tn9 = new TreeNode(9);
		tn5.left = tn3;
		tn3.right = tn4;
		tn3.left = tn2;
		tn4.left = tn6;
		tn2.left = tn1;
		tn2.right = tn8;
		tn4.right = tn7;
		tn5.right = tn9;
		/*sc.inOrder(tn1);*/
		//sc.kthElement(tn1, 1);
		//System.out.println(sc.isValidBST(tn5));
		//System.out.println(sc.isValidBSTRecursion(tn5));
		//sc.levelOrder(tn5);
		//System.out.println(sc.searchMatrix(new int[][] {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}}, 5));
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		/*int[] res = sc.productExceptSelf(new int[] {1,2,3,4});
		for(int i: res) {
			System.out.println(i);
		}*/
		//System.out.println(sc.countPrimes2(10));
		//System.out.println(sc.serialize(tn5));
		//System.out.println(sc.deserialize("5,3,2,1,X,X,8,X,X,4,6,X,X,7,X,X,9,X,X,"));
		//sc.cellCompete(new int[] {1,1,1,0,1,1,1,1},2);
		/*ListNode res = sc.reverseList(l1);
		while(res!=null) {
			System.out.println(res.val);
			res = res.next;
		}*/
/*		List<String> a = new ArrayList<String>();
		a.add("and");
		a.add("he");
		a.add("the");
		a.add("to");
		a.add("is");
		//List<String> b = sc.retrieveMostFrequentlyUsedWords("Rose is a flower red rose are flower", a);
		List<String> b = sc.retrieveMostFrequentlyUsedWords("Jack and Jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food.", a);
		for(String x: b)
			System.out.println(x);*/
		
		TreeNode tn11 = new TreeNode(3);
		TreeNode tn21 = new TreeNode(5);
		TreeNode tn31 = new TreeNode(1);
		TreeNode tn41 = new TreeNode(6);
		TreeNode tn51 = new TreeNode(2);
		tn11.left = tn21;
		tn11.right = tn31;
		tn21.left = tn41;
		tn21.right = tn51;
		TreeNode tn12 = new TreeNode(3);
		TreeNode tn22 = new TreeNode(5);
		TreeNode tn32 = new TreeNode(3);
		TreeNode tn42 = new TreeNode(6);
		TreeNode tn52 = new TreeNode(2);
		tn12.left = tn22;
		tn12.right = tn32;
		tn22.left = tn42;
		tn22.right = tn52;
		System.out.println(sc.leafSimilar(tn11,tn12));
	}
}
