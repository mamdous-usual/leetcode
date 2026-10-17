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
    public int kthSmallest(TreeNode root, int k) {
        int[] count = { 0 }; 
        int[] result = { 0 };

        inorder(root, k, count, result);

        return result[0];
    }

    private void inorder(TreeNode node, int k, int[] count, int[] result) {
        if (node == null)
            return;

        inorder(node.left, k, count, result);

        count[0]++; 
        if (count[0] == k) { 
            result[0] = node.val;
            return; 
        }

        inorder(node.right, k, count, result);
    }

}