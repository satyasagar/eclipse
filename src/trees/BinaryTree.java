package trees;

public class BinaryTree {
	Node root;
	
	public void Insert(int data){
		if(root == null){
			root = new Node(data);
			return;
		}
		InsertRec(data, root);
	}
	
	private void InsertRec(int data, Node node){
		if(data < node.data){
			if(node.left == null)
				node.left = new Node(data);
			else{
				InsertRec(data, node.left);
				return;
			}
		}
		else if (data > node.data){
			if(node.right == null)
				node.right = new Node(data);
			else{
				InsertRec(data, node.right);
				return;
			}
		}		
		//return root;
	}
	
	public void inOrder(){
		inOrderRec(root);
	}
	
	private void inOrderRec(Node node){
		if(node != null){
			inOrderRec(node.left);
			System.out.println(node.data);
			inOrderRec(node.right);
		}
	}
}
