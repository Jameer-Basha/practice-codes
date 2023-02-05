
/* Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

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
    public TreeNode sortedArray(int[] nums , int left, int right){
        if(left>=right)
            return null;
        int mid = (right+left)/2;
        TreeNode res = new TreeNode(nums[mid]);
        res.left=sortedArray(nums,left,mid);
        res.right=sortedArray(nums,mid+1,right);
        return res;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArray(nums,0,nums.length);
    }
}
