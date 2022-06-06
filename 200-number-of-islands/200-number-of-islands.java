class Solution {
    int r,c;
    int[][] visited;
    public int numIslands(char[][] grid) {
        r = grid.length;c = grid[0].length;
        int count = 0;
        //visited = new int[r][c];
        for(int x = 0; x < r; x++){
            for(int y = 0; y < c; y++){
                if(grid[x][y] != '0')         
                    count += helper(x,y,grid);
            }
        }
        return count;
    }
    public int helper(int x,int y,char[][] a){
        int up = 0,down = 0, right= 0, left = 0;
        a[x][y] = '0';
        if(x != 0 && a[x-1][y] != '0')
            up = helper(x-1,y,a);
        
        if(y != 0 && a[x][y-1] != '0')
            left = helper(x,y-1,a);
        
        if(x != (r-1) && a[x+1][y] != '0')
            down = helper(x+1,y,a);
        
        if(y != (c-1) && a[x][y+1] != '0')
            right = helper(x,y+1,a);
        
        return 1 | up | down | left | right;
    }
}