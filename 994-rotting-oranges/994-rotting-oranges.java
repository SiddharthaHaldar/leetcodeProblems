class Solution {
    int minutes = 0,freshtorot = 0;
    public int orangesRotting(int[][] grid) {
        int r = grid.length, 
            c = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0,rot = 0, total = 0;
        for(int x = 0;x < r;x++){
            for(int y = 0;y < c; y++){
                if(grid[x][y] != 0){
                    total += 1;
                    if(grid[x][y] == 1)
                        fresh += 1;
                    else if(grid[x][y] == 2){
                       rot += 1;
                       q.add(new int[]{x,y});
                    }
                }
            }
        }
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i = 0;i < size;i++){
                int arr[] = q.remove();
                int x = arr[0],y = arr[1];
                if(x-1 >= 0 && grid[x-1][y] != 0 && grid[x-1][y] != 2){
                    q.add(new int[]{x-1,y});
                    grid[x-1][y] = 2;
                    fresh -= 1;
                }
                if(x+1 < grid.length && grid[x+1][y] != 0 && grid[x+1][y] != 2){
                    q.add(new int[]{x+1,y});
                    grid[x+1][y] = 2;
                    fresh -= 1;
                }
                if(y-1 >= 0 && grid[x][y-1] != 0 && grid[x][y-1] != 2){
                    q.add(new int[]{x,y-1});
                    grid[x][y-1] = 2;
                    fresh -= 1;
                }
                if(y+1 < grid[0].length && grid[x][y+1] != 0 && grid[x][y+1] != 2){
                    q.add(new int[]{x,y+1});
                    grid[x][y+1] = 2;
                    fresh -= 1;
                }
            }
            minutes += 1;
        }
        //System.out.println(minutes);
        if(fresh == 0)
            return minutes;
        return -1;   
    }
}