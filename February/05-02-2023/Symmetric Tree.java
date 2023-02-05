/* 

You are given an integer array nums with no duplicates. A maximum binary tree can be built recursively from nums using the following algorithm:

Create a root node whose value is the maximum value in nums.
Recursively build the left subtree on the subarray prefix to the left of the maximum value.
Recursively build the right subtree on the subarray suffix to the right of the maximum value.
Return the maximum binary tree built from nums.

*/

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
    public boolean isSame(TreeNode root1, TreeNode root2){
        if(root1== null && root2== null)
            return true;
        if(root1== null || root2==null)
            return false;
        if(root1.val!= root2.val)
            return false;
        boolean left =isSame(root1.left,root2.right);
        boolean right =isSame(root1.right,root2.left);
        return left &&right;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSame(root.left,root.right);
            
        
    }
}
