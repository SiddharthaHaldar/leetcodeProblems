class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        rows,cols = len(grid),len(grid[0])
        
        for r in range(rows-2,-1,-1):
            grid[r][cols-1] += grid[r+1][cols-1]
        for c in range(cols-2,-1,-1):
            grid[rows-1][c] += grid[rows-1][c+1]
            
        for r in range(rows-2,-1,-1):
            for c in range(cols-2,-1,-1):
                grid[r][c] = min(grid[r][c]+grid[r+1][c],
                                 grid[r][c]+grid[r][c+1])
        return grid[0][0]