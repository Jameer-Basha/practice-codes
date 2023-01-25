/*Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them. */
class Solution {
    int dia =0;
    public int height(TreeNode t){
        if(t==null){
            return 0;
        }
        int l_c=height(t.left);
        int r_c = height(t.right);
        
        dia = Math.max(dia,l_c+r_c);
        System.out.println("hello"+dia);
        return Math.max(l_c,r_c)+1;
            
    }
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return dia;
        
    }
}
