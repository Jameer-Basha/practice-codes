/* Given the root of a binary tree, return the postorder traversal of its nodes' values. */
class Solution {
    public void postOrder(TreeNode root, List list){
        if(root == null){
            return ;
        }
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        postOrder(root,list);
        return list;
        
    }
}
