/* 
Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
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
    int res =0, mode =1;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        rangeSumBST(root.left,low,high);
        if(root.val == low){
            mode =0;
            
        }
        if(mode==0)
            res +=root.val;
        if(root.val == high)
            mode =1;
        
       // System.out.println(root.val +" "+mode+ " "+res);
        rangeSumBST(root.right,low,high);
        return res;
    }
}
