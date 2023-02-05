/*   
Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.

Note:

The average of n elements is the sum of the n elements divided by n and rounded down to the nearest integer.
A subtree of root is a tree consisting of root and all of its descendants.
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
    int count= 0;
    public int[] avgSubtree(TreeNode root){
        if(root == null)
            return new int[] {0,0};
        int[] left = avgSubtree(root.left);
        int[] right = avgSubtree(root.right);
        int sum = left[0] +right[0]+root.val;
        int num = left[1] + right[1] +1;
        if(sum/num == root.val)
            count+=1;
        return new int[]{sum,num};
    }
    public int averageOfSubtree(TreeNode root) {
        avgSubtree(root);
        return count;
    }
}
