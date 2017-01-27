package Medium;

import java.util.Stack;

/**
 * Created by Aakash on 1/26/2017.
 */

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Problem173_BSTIterator {

    Stack<TreeNode> stack = new Stack<>();
    public Problem173_BSTIterator(TreeNode root) {
        TreeNode temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode temp = stack.pop();
        TreeNode right = temp.right;
        while (right != null) {
            stack.push(right);
            right = right.left;
        }
        return temp.val;
    }
}
