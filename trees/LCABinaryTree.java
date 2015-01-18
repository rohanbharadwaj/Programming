package trees;

/*
 * Ref : http://www.fusu.us/2013/06/p2-lowest-common-ancestor-in-binary-tree.html
 */
class Node {
    public int data;
    public Node right;
    public Node left;
	
    public Node(int data) {
        this.data = data;
    }
}
public class LCABinaryTree {

	private Node lca(Node root,Node a,Node b) {
		if(root==null) return null;
		if(root.equals(a)||root.equals(b)) return root;
		Node l = lca(root.left, a, b);
		Node r = lca(root.right, a,b);
		
		if(l!=null && r!=null) return root;//Both in seperate branches.
		
		return l!=null ? l:r; //Either one is in one branch or none was found in any other branches.
	}
	public static void main(String[] args) {
		LCABinaryTree obj = new LCABinaryTree();
		Node n1 = new Node(2);//root
		Node n2 = new Node(7);
		Node n3 = new Node(5);
		Node n4 = new Node(9);
		Node n5 = new Node(6);
		n1.left = n2;
		n1.right = n3;
		n2.left = new Node(2);
		n3.right = n4;
		n4.left = new Node(4);
		n2.right = n5;
		n5.left = new Node(5);
		n5.right = new Node(11);
		Node root = n1;
		Node res = obj.lca(root, n2, n5.right);
		System.out.println(res.data);
	}
}
