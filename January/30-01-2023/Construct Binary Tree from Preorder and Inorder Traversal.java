/* Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.*/
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> InMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            InMap.put(inorder[i],i);
        }
        return CreateTree(preorder,inorder,InMap, 0,preorder.length-1,0,inorder.length-1, new int[] {0});
            
    }
    TreeNode CreateTree(int[] pre , int[] in , HashMap InMap , int ps,int pe, int Is, int Ie, int[] curr){
        if( pe<ps || Ie <Is)
            return null;
        TreeNode node = new TreeNode(pre[curr[0]]);
        int Ip = (int)InMap.get(pre[curr[0]]);
        int count = Ip-Is;
        curr[0] = curr[0]+1;
        node.left =CreateTree(pre,in,InMap, ps+1,ps+count,Is,Ip-1,curr);
        node.right =CreateTree(pre,in,InMap, ps+count+1,pe,Ip+1,Ie,curr);
        return node;
    }
}
