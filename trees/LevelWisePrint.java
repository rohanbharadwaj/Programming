package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelWisePrint {

	public static void BFSNonRecursive(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty()){
			Node node = queue.poll();
			System.out.println(node.data);
			if(node.left!=null) queue.add(node.left);
			if(node.right!=null) queue.add(node.right);
		}
	}
}
