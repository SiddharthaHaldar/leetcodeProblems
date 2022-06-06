class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length,c = grid[0].length;
        //System.out.println(r+" "+c);
        int max = 0;
        for(int x = 0;x < r;x++){
            for(int y = 0; y < c;y++){
                if(grid[x][y] != 0)
                    max = Math.max(max,1 + helper(grid,x,y));
            }
        }
        return max;
    }
    public int helper(int[][]grid, int x,int y){
        int up=0,down=0,left=0,right=0;
        grid[x][y] = 0;
            
        if(x != 0 && grid[x-1][y] != 0)
            up = 1 + helper(grid,x-1,y);
        
        if(x != grid.length - 1 && grid[x+1][y] != 0)
            down = 1 + helper(grid,x+1,y);
        
        if(y != 0 && grid[x][y-1] != 0)
            left = 1 + helper(grid,x,y-1);
        
        if(y != grid[0].length - 1 && grid[x][y+1] != 0)
            right = 1 + helper(grid,x,y+1);
        
        return up + down + left + right;
    }
}