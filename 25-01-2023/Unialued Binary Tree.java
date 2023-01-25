/* A binary tree is uni-valued if every node in the tree has the same value.

Given the root of a binary tree, return true if the given tree is uni-valued, or false otherwise.*/
class Solution {
    int res;
    public void preOrd(TreeNode root,int res){
        this.res=res;
        if(root == null){
            return;
        }
        if (root.val != this.res ){
            this.res +=1;
           
        }
        preOrd(root.left,this.res);
        preOrd(root.right,this.res);
    }
    public boolean isUnivalTree(TreeNode root) {
        this.res = root.val;
        int ans = root.val;
        preOrd(root,this.res);
        if(this.res == ans )
            return true;
        return false;
        
    }
}
