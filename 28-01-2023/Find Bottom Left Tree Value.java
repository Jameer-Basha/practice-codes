/* Given the root of a binary tree, return the leftmost value in the last row of the tree.*/
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
import java.lang.reflect.Array;
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> que=new LinkedList<>();
        List<Integer> lst= new ArrayList<Integer>();        
        if(root== null){
            return 0;
        }
        que.add(root);
        while(!que.isEmpty()){            
            int size = que.size();
            for(int i=0;i<size;i++){
            TreeNode curr = que.poll();
                if(i==0){
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
        
        return lst.get(lst.size()-1);
    }
}
