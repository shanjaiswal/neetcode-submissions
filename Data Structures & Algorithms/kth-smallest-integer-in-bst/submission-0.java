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
    int k = -1;
    int val = -1;
    public int kthSmallest(TreeNode root, int K) {
        k = K;
        dfs(root);
        return val;
    }
    public void dfs(TreeNode root) {
        if (root != null && val == -1) {
            dfs(root.left);
            k = k - 1;
            if (k == 0) {
                val = root.val;
                return;
            }
            dfs(root.right);
        }
    }
}
