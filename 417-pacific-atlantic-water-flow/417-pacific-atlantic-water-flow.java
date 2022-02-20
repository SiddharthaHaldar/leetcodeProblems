class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int R = heights.length;
        int C = heights[0].length;
        int visitedPacific[][] = new int[R][C];
        int visitedAtlantic[][] = new int[R][C];
        
        for(int x = 0; x < R;x++)
            visitedPacific[x][0] = 1;
        
        for(int y = 0; y < C;y++)
            visitedPacific[0][y] = 1;
        
        for(int x = 0; x < R;x++)
            visitedAtlantic[x][C-1] = 1;
        
        for(int y = 0; y < C;y++)
            visitedAtlantic[R-1][y] = 1;
        
        for(int x = 0; x < R;x++)
            helper(heights,visitedPacific,x,0,R,C);
        
        for(int y = 0; y < C;y++)
            helper(heights,visitedPacific,0,y,R,C);
        
        for(int x = 0; x < R;x++)
            helper(heights,visitedAtlantic,x,C - 1,R,C);
        
        for(int y = 0; y < C;y++)
            helper(heights,visitedAtlantic,R - 1,y,R,C);
        
        List<List<Integer>> L = new ArrayList<>();
        /*for(int r = 0;r < R;r++){
            for(int c = 0;c < C;c++){
                System.out.print(visitedPacific[r][c]+"\t");
                }
            System.out.println();
            }
        System.out.println();
        for(int r = 0;r < R;r++){
            for(int c = 0;c < C;c++){
                System.out.print(visitedAtlantic[r][c]+"\t");
                }
            System.out.println();
            }*/
        for(int r = 0;r < R;r++){
            for(int c = 0;c < C;c++){
                if(visitedPacific[r][c] == 1 && visitedAtlantic[r][c] == 1){
                    List<Integer> l = new ArrayList<>();
                    l.add(r);
                    l.add(c);
                    L.add(l);
                }
            }
        }
        return L;
    }
    
    public void helper(int[][] heights,int[][] visited,int r, int c,int R,int C){
        /*if(r < 0 || c < 0 || r >= R || c >= C || visited[r][c] == 1)
            return;*/
        
        visited[r][c] = 1;
        
        if(r-1 >= 0 && heights[r][c] <= heights[r-1][c] && visited[r-1][c] == 0)
            helper(heights,visited,r-1,c,R,C);
        
        if(r+1 < R && heights[r][c] <= heights[r+1][c] && visited[r+1][c] == 0)
            helper(heights,visited,r+1,c,R,C);
        
        if(c-1 >= 0 && heights[r][c] <= heights[r][c-1] && visited[r][c-1] == 0)
            helper(heights,visited,r,c-1,R,C);
        
        if(c+1 < C && heights[r][c] <= heights[r][c+1] && visited[r][c+1] == 0)
            helper(heights,visited,r,c+1,R,C);
    }
}