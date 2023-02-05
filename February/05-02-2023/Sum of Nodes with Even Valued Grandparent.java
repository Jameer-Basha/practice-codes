/**
Given the root of a binary tree, return the sum of values of nodes with an even-valued grandparent. If there are no nodes with an even-valued grandparent, return 0.

A grandparent of a node is the parent of its parent if it exists.



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
    int ans =0;
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null)
            return 0;
        if(root.val%2==0){
            if(root.left !=null){
                if(root.left.left!=null)
                    ans +=root.left.left.val;
                if(root.left.right!=null)
                    ans +=root.left.right.val;
            }
            if(root.right !=null){
                if(root.right.left!=null)
                    ans +=root.right.left.val;
                if(root.right.right!=null)
                    ans +=root.right.right.val;
            }
        }
        sumEvenGrandparent(root.left);
        sumEvenGrandparent(root.right);
        return ans;
    }
}
