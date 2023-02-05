/**

Given two binary search trees root1 and root2, return a list containing all the integers from both trees sorted in ascending order.


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
    
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result= new ArrayList<>();
        inorder(root1, result);
        inorder(root2, result);
        Collections.sort(result);
        return result;
    }
    public void inorder(TreeNode root, List<Integer> result){
        if(root == null)
            return;
        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }
}
