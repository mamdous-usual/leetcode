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
    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }

    private int helper(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int lps = Math.max(helper(node.left), 0);
        int rps = Math.max(helper(node.right), 0);
        int cmp = node.val + lps + rps;

        maxSum = Math.max(maxSum, cmp);

        return node.val + Math.max(lps, rps);
    }
}
