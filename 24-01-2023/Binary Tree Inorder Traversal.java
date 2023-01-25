/* Given the root of a binary tree, return the inorder traversal of its nodes' values.*/
class Solution {
    public void InOrder(TreeNode root, List list){
        if(root== null){
            return ;
        }
        InOrder(root.left,list);
        list.add(root.val);
        InOrder(root.right,list);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        InOrder(root,list);
        return list;
    }
}
