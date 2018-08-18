package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class SolutionClass {
	
	public static class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {val = x;}
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null || q==null)
			return p==null && q==null;
		
		return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
	

	
/*	public TreeNode buildTree(int[] preorder, int[] inorder) {
	    return helper(0, 0, inorder.length - 1, preorder, inorder);
	}

	public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
	    if (preStart > preorder.length - 1 || inStart > inEnd) {
	        return null;
	    }
	    TreeNode root = new TreeNode(preorder[preStart]);
	    int inIndex = 0; // Index of current root in inorder
	    for (int i = inStart; i <= inEnd; i++) {
	        if (inorder[i] == root.val) {
	            inIndex = i;
	        }
	    }
	    root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
	    root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
	    return root;
	}*/
	
	public int[] twoSum(int[] numbers, int target) {
        int l = 0; int r = numbers.length-1;
        while(l<r) {
        	if(numbers[l]+numbers[r] == target) {
        		System.out.println((l+1)+"--"+(r+1));
        		return new int[]{l+1,r+1};
        	}        		
        	else if(numbers[l]+numbers[r] > target)
        		r--;
        	else
        		l++;
        }
        return null;
    }
	
	private List<List<Integer>> result;
	public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        for(int i=0; i <= nums.length; i++) {
        	System.out.println("CALLING RECURSION: "+i);
        	this.recurse(nums, i, 0, new ArrayList<Integer>());
        }
        return result;
    }
	private void recurse(int[] nums, int length, int s, List<Integer> acc) {
		System.out.println("Called recursion: s: "+s);
		if(acc.size() >= length) {
			result.add(acc);
			System.out.println("====Added====");
			return;
		}
		
		for(int i=s; i< nums.length; i++) {
			List<Integer> temp = new ArrayList<>();
			System.out.println("inner i: "+i+" s: "+s);
			temp.addAll(acc);
			temp.add(nums[i]);
			System.out.println("nums[i] "+nums[i]);
			this.recurse(nums, length, i+1, temp);
		}
	}
		
    public List<Integer> rightSideView(TreeNode root) {
    	List<Integer> result = new ArrayList<>();
    	rightView(root, result, 0);
    	return result;
    }
    private void rightView(TreeNode curr, List<Integer> result, int currDepth) {
    	if(curr == null)
    		return;
    	
    	if(currDepth == result.size())
    		result.add(curr.val);
    	
    	rightView(curr.right, result, currDepth+1);
    	rightView(curr.left, result, currDepth+1);
    }
    
    public static class ListNode{
    	int val;
    	ListNode next;
    	ListNode(int x){val = x;}
    }
    public ListNode mergeKLists(ListNode[] lists) {
    	if(lists == null || lists.length == 0)
    		return null;
    	ListNode result = lists[0];
    	for(int i=0; i<lists.length-1; i++) {
    		result = merge(result, lists[i+1]);
    	}
    	return result;
    }
    private ListNode merge(ListNode l1, ListNode l2) {
    	if(l1==null)
    		return l2;
    	if(l2==null)
    		return l1;
    	if(l2.val > l1.val) {
    		l1.next = merge(l1.next, l2);
    		return l1;
    	}
    	l2.next = merge(l2.next, l1);
    	return l2;
    }
    
    
    
    /*public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null|| lists.length ==0)
        	return null;
        
        return mergeSort(lists, 0, lists.length-1);
    }
    private ListNode mergeSort(ListNode[] lists, int s, int e) {
    	if(s >= e) {
    		return lists[s];
    	}
    	int mid = (e-s)/2+s;
    	ListNode l1 = mergeSort(lists, s, mid);
    	System.out.println("l1: "+l1.val);
    	ListNode l2 = mergeSort(lists, mid+1, e);
    	System.out.println("l2: "+l2.val);
    	
    	return merge(l1, l2);
    }
    private ListNode merge(ListNode l1, ListNode l2) {
    	if(l1 == null)
    		return l2;
    	if(l2 == null)
    		return l1;
    	if(l1.val < l2.val) {
    		l1.next = merge(l1.next, l2);
    		return l1;
    	}
    	l2.next = merge(l2.next, l1);
    	return l2;
    }*/
    
    
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++) {
        	for(int j=0; j<grid[0].length; j++) {
        		if(grid[i][j]=='1') {
        			DFSMarking(grid, i, j);
        			count++;
        		}
        	}
        }
        return count;
    }
    private void DFSMarking(char[][] grid, int i, int j) {
    	if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]!='1') return;
    	grid[i][j] = '0';
    	DFSMarking(grid, i+1, j);
    	DFSMarking(grid, i-1, j);
    	DFSMarking(grid, i, j+1);
    	DFSMarking(grid, i, j-1);
    }
    
    /*public int myAtoi(String str) {
    	int index = 0;
        if(str.isEmpty())
        	return 0;
        while(str.charAt(index)==' ' && index < str.length())
        	index++;
        if(str.charAt(index)=='+'||str.charAt(index)=='-'))
    }*/
    
    public List<List<String>> groupAnagrams(String[] strs) {
    	Map<String, List<String>> map = new HashMap<String, List<String>>();
    	for(String s: strs) {
    		char[] temp = s.toCharArray();
    		Arrays.sort(temp);
    		String keyStr = String.valueOf(temp);
    		if(!map.containsKey(keyStr))
    			map.put(keyStr, new ArrayList<String>());
    		map.get(keyStr).add(s);
    	}
    	return new ArrayList<List<String>>(map.values());
    }    
    
    public void inOrder(TreeNode root) {
    	Stack<TreeNode> stack = new Stack<>();
    	List<Integer> result = new ArrayList<>();
    	while(root !=null || !stack.isEmpty()) {
    		while(root != null) {
    			stack.push(root);
    			root = root.left;
    		}
    		root = stack.pop();
    		result.add(root.val);
    		root = root.right;
    	}
    	for(int i : result)
    		System.out.println(i);
    }    
    
    public void kthElement(TreeNode root, int k) {
    	Stack<TreeNode> stack = new Stack<>();
    	while(root !=null || !stack.isEmpty()) {
    		while(root != null) {
    			stack.push(root);
    			root = root.left;
    		}
    		root = stack.pop();
    		if(--k == 0) break;
    		root = root.right;
    	}
    	System.out.println(root.val);
    }   
    
    public boolean isValidBST(TreeNode root) {
    	Stack<TreeNode> stack = new Stack<>();
    	TreeNode pre = null;
    	while(root !=null || !stack.isEmpty()) {
    		while(root != null) {
    			stack.push(root);
    			root = root.left;
    		}
    		root = stack.pop();
    		if(pre !=null && root.val <= pre.val) return false;
    		pre = root;
    		root = root.right;
    	}
    	return true;
    }
    
    public boolean isValidBSTRecursion(TreeNode root) {
    	return isValidSubTree(root, null, null);    	
    }
    private boolean isValidSubTree(TreeNode root, Integer leftValue, Integer rightValue) {
    	if(root == null) return true;
    	if(leftValue != null && root.val <= leftValue) return false;
    	if(rightValue != null && root.val >= rightValue) return false;
    	
    	return isValidSubTree(root.left, root.val, rightValue) && isValidSubTree(root.right, leftValue, root.val);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helperLO(result, root, 0);
        for(List<Integer> lint: result) {
        	for(int i: lint)
        		System.out.print(i);
        	System.out.println(" ");
        }        	
        return result;
    }
    private void helperLO(List<List<Integer>> result, TreeNode root, int height) {
    	if(root == null) return;
    	if(height >= result.size())
    		result.add(new ArrayList<Integer>());
    	result.get(height).add(root.val);
    	helperLO(result, root.left, height+1);
    	helperLO(result, root.right, height+1);
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == p || root == q || root == null) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null) return root;
        return left != null? left : right;
    }    
    
    public boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix == null || matrix.length ==0 || matrix[0].length ==0)
    		return false;
    	int m = 0;
    	int n = matrix[0].length-1;
    	
    	while(m < matrix.length && n>=0) {
    		if(matrix[m][n]==target)
    			return true;
    		else if(target>matrix[m][n])
    			m++;
    		else
    			n--;
    	}
    	
        return false;
    }   
    
    public boolean isPalindrome(ListNode head) {
    	ListNode pre = head;
    	ListNode tail = head.next;
        while(head != null) {
        	tail = head.next;
        }
        return true;
        
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
    
    public int countPrimes(int n) {
    	int count=0;
        for(int i=2; i<n; i++) {
        	int multiple=0;
        	for(int j=1;j<=(int)Math.sqrt(i); j++) {
        		if(i%j ==0)
        			multiple++;
        		if(multiple > 1)
            		continue;
        	}        	
        	if(multiple ==1)
        		count++;
        }
        return count;
    }
    
    public int countPrimes2(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        
        return count;
    }
    
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {//2     2,4
    	if(root == p || root == q || root==null) return root;
    	TreeNode left = lowestCommonAncestor2(root.left, p, q);
    	TreeNode right = lowestCommonAncestor2(root.right, p, q);
    	if(left != null && right!=null) return root;
    	return left!=null?left:right;
    }
    
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X").append(",");
        } else {
            sb.append(node.val).append(",");
            buildString(node.left, sb);
            buildString(node.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }   
    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(null)) return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
    }
    
    public List<Integer> cellCompete(int[] states, int days)//1,0,0,0,0,1,0,0
    {
    	int n = states.length;
    	int[] result = new int[n];
    	
    	List<Integer> resList = new ArrayList<>();
    	
    	for(int j=1; j<=days; j++) {
    		for(int i=0; i<states.length; i++) {
        		if(i==0) {
        			result[0] = states[1]==0?0:1;
        		}
        		else if(i>0 && i<n-1) {
        			result[i] = states[i-1]==states[i+1]?0:1;
        		}
        		else if(i==n-1) {
        			result[n-1] = states[i-1] == 0?0:1;
        		}
        	}
    		for(int i=0; i<n; i++) {
    			states[i] = result[i];
    		}
    			
    	}    	
    	
    	for(int i: result) {
    		resList.add(i);
    		System.out.println(i);
    	}
    	return resList;
    }
    
    public ListNode reverseList(ListNode head) {
    	Stack<Integer> s = new Stack<>();
    	while(head != null) {
    		s.add(head.val);
    		head = head.next;
    	}
    	ListNode res = null;
    	ListNode out = null;
    	while(!s.isEmpty()) {
    		ListNode l = new ListNode(s.pop());
    		if(res == null) {
    			res = l;
    			out = res;
    		}
    		else {
    			res.next = l;
    			res = l;
    		}    			
    	}
    	
        return out;
    }
    
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        while (head != null) {
        	ListNode temp = head.next;
        	head.next = prev;
        	prev = head;
        	head = temp;
        }
        return prev;
    }
    
    List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude){//Rose is a flower red rose are flower
    	if(literatureText == null || literatureText.length() == 0)
    		return null;
    	String[] words = literatureText.toLowerCase().split("\\P{Alpha}+");
    	HashMap<String, Integer> hm = new HashMap<>();
    	for(String w: words) {
    		if(wordsToExclude.contains(w))
    			continue;
    		if(!hm.containsKey(w))
    			hm.put(w, 1);
    		else
    			hm.put(w, hm.get(w)+1);
    	}
    	if(hm.size() == 0)
    		return null;
    	int max = Collections.max(hm.values());
    	List<String> result = new ArrayList<>();
    	
    	//Map.Entry<String, Integer> entry = hm.entrySet().iterator().next();
    	Iterator it = hm.entrySet().iterator();
    	while(it.hasNext()) {
    		Map.Entry pair = (Map.Entry)it.next();
    		if((int)pair.getValue() == max)
    			result.add(pair.getKey().toString());
    	}
    	
    	return result;
    }
    
    
    public List<String> reorderLines(int logFileSize, List<String> logfile)
    {

        List<String> strAlp = new ArrayList<String>();
        List<String> strNum = new ArrayList<String>();
        List<String> AlpNum = new ArrayList<String>();

        for( String sl :  logfile){
            String[] slPart = sl.split(" ", 2);
            if(Character.isDigit(slPart[1].charAt(0))){
                strNum.add(sl);
            }
            else {
                strAlp.add(slPart[1].concat(" " + slPart[0]));
            }
        }
        Collections.sort(strAlp);
        for(String sl2 : strAlp){
            String[] part = {sl2.substring(0,sl2.lastIndexOf(" ")), sl2.substring(sl2.lastIndexOf(" ") + 1)};
            AlpNum.add(part[1].concat(" " + part[0]));
        }
        AlpNum.addAll(strNum);
        return AlpNum;
    }
    
    private List<Integer> tree1Leafs = new ArrayList<Integer>();
    private List<Integer> tree2Leafs = new ArrayList<Integer>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        getLeafs(root1, tree1Leafs);
        getLeafs(root2, tree2Leafs);
        if(tree1Leafs.toString().equals(tree2Leafs.toString()))
        	return true;
        return false;
    }
    private void getLeafs(TreeNode node, List<Integer> leafList) {
    	if(node == null)
    		return;
    	if(node.left == null && node.right == null) {
    		leafList.add(node.val);
    		return;
    	}
    	getLeafs(node.left, leafList);
    	getLeafs(node.right, leafList);
    }
    
    public int robotSim(int[] commands, int[][] obstacles) {
    	int[] result = new int[]{0,0};
    	int direction = 0; //0 - north, 1 - right, 2 - left
        for(int i =0; i< commands.length; i++) {
        	if(i == -2) {
        		direction = 2;
        		continue;
        	}
        	else if(i == -1) {
        		direction = 1;
        		continue;
        	}
        	else if(i >= 0) {
        		direction = 0;
        		continue;
        	}
        	
        	if(direction == 0)
        		result[1] += commands[i];
        	else if(direction == 1)
        		result[0] += commands[i];
        	else if(direction == 2)
        		result[0] -= commands[i];
        }
        return 1;
    }
}
