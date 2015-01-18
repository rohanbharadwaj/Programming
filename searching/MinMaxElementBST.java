package searching;


public class MinMaxElementBST {
	public static int findMinIter(Node root) {
		Node current = root;
		if(current!=null) 
		{
			while(current.left!=null) 
				current=current.left;
		}
		return current.data;
		
	}
	public static int findMinRecur(Node node) {
		if(node!=null){
			if(node.left!=null) return findMinRecur(node.left);	
			else return node.data;
		}
		return Integer.MIN_VALUE;
	}
	public static int findMaxIter(Node node) {
		Node current = node;
		if(current!=null) 
		{
			while(current.right!=null) 
				current=current.right;
		}
		return current.data;
		
	}
	public static int findMaxRecur(Node node) {
		if(node!=null){
			if(node.right!=null) return findMaxRecur(node.right);	
			else return node.data;
		}
		return Integer.MAX_VALUE;
	}
	
	public static void main(String[] args) {
		BST b = new BST();
		b.insert(10);
		b.insert(20);
		b.insert(5);
		b.insert(2);
		b.insert(15);
		System.out.println(findMinIter(b.root));
		System.out.println(findMinRecur(b.root));
		System.out.println(findMaxIter(b.root));
		System.out.println(findMaxRecur(b.root));
		
	}
	
}
