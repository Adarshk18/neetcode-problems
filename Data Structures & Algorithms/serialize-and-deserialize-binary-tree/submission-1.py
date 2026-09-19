# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Codec:
    
    # Encodes a tree to a single string.
    def serialize(self, root: Optional[TreeNode]) -> str:
        if not root:
            return "N"
        res = []
        q = deque([root])

        while q:
            node = q.popleft()
            if not node:
                res.append("N")
            else:
                res.append(str(node.val))
                q.append(node.left)
                q.append(node.right)
        return ",".join(res)            
        

        
    # Decodes your encoded data to tree.
    def deserialize(self, data: str) -> Optional[TreeNode]:
        vals = data.split(",")
        if vals[0] == "N":
            return None
        root = TreeNode(int(vals[0]))
        q = deque([root])
        indx=1
        while q:
            node = q.popleft()
            if vals[indx] != "N":
                node.left = TreeNode(int(vals[indx]))
                q.append(node.left)
            indx += 1
            if vals[indx] != "N":
                node.right = TreeNode(int(vals[indx]))
                q.append(node.right)
            indx += 1
        return root        

