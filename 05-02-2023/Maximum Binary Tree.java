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
    public int findMax(int[] array, int ps, int pe){
        int maxInd = ps;
        for (int i = ps; i <= pe; i++)
            maxInd = array[i] > array[maxInd] ? i : maxInd;
        return maxInd;
    }
    public TreeNode MaxBinaryTree(int[] nums, int ps, int pe){
        if(pe<ps)
            return null;
        int max = findMax(nums,ps,pe);
        TreeNode res= new TreeNode(nums[max]);
        res.left = MaxBinaryTree(nums,ps,max-1);
        res.right = MaxBinaryTree(nums,max+1,pe);
        return res;
    }
        
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return MaxBinaryTree(nums,0,nums.length-1);
    }
}
