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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];

        dfs(root, res);

        return res[0];
    }

    private int dfs(TreeNode node, int[] res) {
        if (node == null) {
            return 0;
        }

        int leftHeight = dfs(node.left, res);
        int rightHeight = dfs(node.right, res);

        int sum = leftHeight + rightHeight;

        res[0] = Math.max(res[0], sum);

        return 1 + Math.max(leftHeight, rightHeight);
    }
}
