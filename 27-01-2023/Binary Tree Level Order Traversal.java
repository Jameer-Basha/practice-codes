/* Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).*/
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> lst= new ArrayList<Integer>();
        
        if(root== null){
            return result;
        }
        lst.add(root.val);
        result.add(lst);
        que.add(root);
        while(!que.isEmpty()){
            
            int size = que.size();
            
            lst= new ArrayList<Integer>();
            for(int i=0;i<size;i++){
            TreeNode curr = que.poll();
                if(curr.left!=null){
                    que.add(curr.left);
                    lst.add(curr.left.val);
                    
                }
                if(curr.right!=null){
                    que.add(curr.right);
                    lst.add(curr.right.val);
                    
                }
            }
            
            if(!lst.isEmpty())
            result.add(lst);



        }
        return result;
    }
}
