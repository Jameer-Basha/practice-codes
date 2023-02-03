''' You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def check(self,root,upper,lower,prev):
        if(root == None):
            return True
        if(root.val<= lower or root.val>=upper):
            
                temp =prev.val
                prev.val = root.val
                root.val = temp
                return False
        return self.check(root.left,root.val,lower,root) & self.check(root.right,upper,root.val,root);
            
                
    def recoverTree(self, root: Optional[TreeNode]) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        ans =self.check(root,float('inf'),float('-inf'),None)
        while(not ans):
            ans =self.check(root,float('inf'),float('-inf'),None)
        return root
