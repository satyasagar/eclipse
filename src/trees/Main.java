package trees;

public class Main {
	public static void main(String[] args){
		BinaryTree bt = new BinaryTree();
		bt.Insert(50);
		bt.Insert(30);
		bt.Insert(20);
		bt.Insert(40);
		bt.Insert(70);
		bt.Insert(60);
		bt.Insert(80);
		bt.inOrder();
	}
}
