/* Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.*/

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
    int res=0;
    public void issame(TreeNode p, TreeNode q){
        if(p== null && q==null){
            return ;
        }
        if(p!=null && q== null){
            this.res =res+1;
            return;
        }
        if(p==null && q!=null){
            this.res =res+1;
            return ;
        } 
        issame(p.left,q.left);
        issame(p.right,q.right);
        if(p.val== q.val){
            this.res +=0;
        }
        else{
        this.res=res+1;
        }
            
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        issame(p,q);
        System.out.println(this.res);
             if(this.res==0)
                 return true;
             return false;
         }
    }
