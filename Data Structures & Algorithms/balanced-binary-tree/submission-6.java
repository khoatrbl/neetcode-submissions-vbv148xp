/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{1, 0};
        }

        int[] leftHeight = dfs(node.left);
        int[] rightHeight = dfs(node.right);

        boolean isBalance = leftHeight[0] == 1 && rightHeight[0] == 1 && Math.abs(leftHeight[1] - rightHeight[1]) <= 1;
        int height = 1 + Math.max(leftHeight[1], rightHeight[1]);

        return new int[] {isBalance ? 1 : 0, height};
    }
}
