package trees;


public class Question7 {
		public class TreeNode {
		    int val;
		    TreeNode left;
		    TreeNode right;

		    TreeNode(int x) {
		      val = x;
		    }
		  }
	
		private TreeNode lca(TreeNode root,TreeNode a,TreeNode b) {
			if(root==null) return null;
			if(root.equals(a)||root.equals(b)) return root;
			TreeNode l = lca(root.left, a, b);
			TreeNode r = lca(root.right, a,b);
			
			if(l!=null && r!=null) return root;//Both in seperate branches.
			
			return l!=null ? l:r; //Either one is in one branch or none was found in any other branches.
		}
		
		
}
