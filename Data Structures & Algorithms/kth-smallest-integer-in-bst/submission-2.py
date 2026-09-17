# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def kthSmallest(self, root: Optional[TreeNode], k: int) -> int:
        arr =[]

        def dfs(node):
            if not node:
                return

            dfs(node.left)
            arr.append(node.val)
            dfs(node.right)

        dfs(root)
        return arr[k-1]   

        curr = root
        while curr:
            #Has no left child
            if not curr.left:
                k -=1
                if k==0:
                    return curr.val
                curr = curr.right
            else:
                pred = curr.left
                while pred.right and pred.right!=curr:
                    pred = pred.right

                if not pred.right:
                    pred.right =curr
                    curr = curr.left
                else:
                    pred.right = None
                    k -=1
                    if k==0:
                        return curr.val
                    curr = curr.right
        return -1                                     
        
        