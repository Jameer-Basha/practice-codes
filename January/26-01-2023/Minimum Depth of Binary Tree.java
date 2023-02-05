/* Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children. */
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
    int min;
    public int height(TreeNode t){
        if(t==null){
            return 0;
            
        }
        
        int l_h= height(t.left);
        int r_h = height(t.right);
       
        if(l_h==0){
            
            return r_h+1;
        }
        else if (r_h==0){
            
            return l_h+1;
        }
        return Math.min(l_h,r_h)+1;
    }
    public int minDepth(TreeNode root) {
       return height(root);
        
    }
}
