/* Given the root of a binary tree, return the preorder traversal of its nodes' values. */
class Solution {
    
    public List preOrder(TreeNode root,List<Integer> list){
        if (root == null){
            return null;
        }
        list.add(root.val);
        preOrder(root.left,list);
        preOrder(root.right,list);
        return list;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        preOrder(root,list);
              return list;
        }
  
        
    
}
