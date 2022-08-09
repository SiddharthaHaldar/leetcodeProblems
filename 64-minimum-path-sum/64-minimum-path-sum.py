class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        rows,cols = len(grid),len(grid[0])
        #print(rows,cols)
        for r in range(rows-1,-1,-1):
            for c in range(cols-1,-1,-1):
                #print(r,c)
                if(r == rows - 1 and c != cols - 1):
                    grid[r][c] = grid[r][c] + grid[r][c+1]
                elif(c == cols - 1 and r != rows - 1):
                    grid[r][c] = grid[r][c] + grid[r+1][c]
                elif(c != cols - 1 and r != rows - 1):
                    grid[r][c] = min(grid[r][c]+grid[r+1][c],
                                     grid[r][c]+grid[r][c+1])
        return grid[0][0]