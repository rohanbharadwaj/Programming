package trees;

/*
 *   3
 / \
 9  20
 /  \
 15   7
 * 
 * 
 * [
 [3],
 [9,20],
 [15,7]
 ]
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class LeveOrderArrayList {

	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return null;
		queue.offer(root);
		while (!queue.isEmpty()) {
			int levlnum = queue.size();
			List<Integer> templist = new ArrayList<Integer>();
			for (int i = 0; i < levlnum; i++) {
				if (queue.peek().left != null)
					queue.offer(queue.peek().left);
				if (queue.peek().right != null)
					queue.offer(queue.peek().right);
				templist.add(queue.poll().val);
			}
			result.add(templist);

		}
		return result;

	}
}
