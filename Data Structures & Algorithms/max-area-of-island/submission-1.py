class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        if not grid:
            return 0


        rows, cols = len(grid), len(grid[0]) 
        vis = set()
        maxArea =0 

        def bfs(r,c):
            q = collections.deque()
            q.append((r,c))
            vis.add((r,c))

            area =0
            

            while q:
                row, col = q.popleft()
                area += 1
                directions = [[1,0],[-1,0], [0,1], [0,-1]]

                for dr, dc in directions:
                    r,c=row+dr,col+dc
                    if(r in range(rows) and c in range(cols) and grid[r][c] == 1 and (r,c) not in vis):
                        q.append((r,c))
                        vis.add((r,c))

            return area            

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == 1 and (r,c) not in vis:
                    area = bfs(r,c)
                    if maxArea<area:
                        maxArea = max(maxArea, area)
        return maxArea                 