/* 
Given the root of a binary tree, return the sum of values of its deepest leaves.

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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        List<Integer> lst = new ArrayList<>();
        if(root == null)
            return 0;
        int count=0;
        lst.add(root.val);
        que.add(root);
        while(!que.isEmpty()){
            int size = que.size();
            count =0;
            for(int i=0;i<size;i++){
                TreeNode curr = que.poll();
                if(curr.left!=null){
                    que.add(curr.left);
                    count +=  curr.left.val; 
                }
                if(curr.right!= null){
                    count +=curr.right.val;
                    que.add(curr.right);
                }
            }
            lst.add(count);
        }
        int s =lst.size();
        if(s==1)
            return lst.get(0);
        else 
            return lst.get(lst.size()-2);
    }
}
