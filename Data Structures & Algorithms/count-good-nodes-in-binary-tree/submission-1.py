# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def goodNodes(self, root: TreeNode) -> int:
        cnt =0
        q = deque([(root, root.val)])
        

        while q:
            node,maxVal = q.popleft()

            if node.val >= maxVal:
                cnt += 1

            maxVal = max(maxVal,node.val)

            if node.left:
                q.append((node.left, maxVal))

            if node.right:
                q.append((node.right, maxVal))
                        
        return cnt                
        