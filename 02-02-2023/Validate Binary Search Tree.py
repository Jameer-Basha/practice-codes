# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def check(self,root,upper,lower):
        if not root:
            return True
        if(root.val<=lower or root.val>=upper):
            return False
        else:
            return self.check(root.left,root.val,lower) & self.check(root.right,upper,root.val)
        
    def isValidBST(self, root: Optional[TreeNode]) -> bool:
        return self.check(root, float('inf'),float('-inf'))
