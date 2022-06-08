class Solution {
    public void wallsAndGates(int[][] rooms) {
        int INF = 2147483647;
        Queue<int[]> q = new LinkedList<>();
        int r = rooms.length,
            c = rooms[0].length;
        
        for(int x = 0;x < r;x++){
            for(int y = 0;y < c;y++){
                if(rooms[x][y] == 0){
                    q.add(new int[]{x,y});
                }
            }
        }
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                int arr[] = q.remove();
                int x = arr[0],
                    y = arr[1];
                
                if(x-1 >= 0 && rooms[x-1][y] == INF){
                    q.add(new int[]{x-1,y});
                    int newVal = rooms[x][y] + 1;
                    rooms[x-1][y] = newVal;
                }
                if(x+1 <= r - 1 && rooms[x+1][y] == INF){
                    q.add(new int[]{x+1,y});
                    int newVal = rooms[x][y] + 1;
                    rooms[x+1][y] = newVal;
                }
                if(y-1 >= 0 && rooms[x][y-1] == INF){
                    q.add(new int[]{x,y-1});
                    int newVal = rooms[x][y] + 1;
                    rooms[x][y-1] = newVal;
                }
                if(y+1 <= c - 1 && rooms[x][y+1] == INF){
                    q.add(new int[]{x,y+1});
                    int newVal = rooms[x][y] + 1;
                    rooms[x][y+1] = newVal;
                }
            }
        }
    }
}