/* Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.*/
class Solution {
    public int height(TreeNode t){
        if(t==null){
            return 0;
            
        }
        int l_h= height(t.left);
        int r_h = height(t.right);
        return Math.max(l_h,r_h)+1;
        
    }
    public int maxDepth(TreeNode root) {
       return height(root);
        
    }
}
