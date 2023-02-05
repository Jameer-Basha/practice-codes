/* Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom. */
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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        List<Integer> lst= new ArrayList<Integer>();        
        if(root== null){
            return lst;
        }
        que.add(root);
        while(!que.isEmpty()){            
            int size = que.size();
            for(int i=0;i<size;i++){
            TreeNode curr = que.poll();
                if(i==size-1){
                    lst.add(curr.val);
                }
                
                if(curr.left!=null){
                    que.add(curr.left);
                    }
                if(curr.right!=null){
                    que.add(curr.right);
                    }
            }
            

        }
        return lst;
    }
}
