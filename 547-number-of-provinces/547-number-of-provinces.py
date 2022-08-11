class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        rows,cols = len(isConnected),len(isConnected[0])
        visited = set()
        count = 0
        
        def dfs(source,destination):
            neighbours = isConnected[destination]
            for idx in range(len(neighbours)):
                if(neighbours[idx] == 1 and idx != source
                   and idx != destination and idx not in visited):
                    visited.add(idx)
                    dfs(destination,idx)
            
        for idx in range(len(isConnected)):
            if(idx not in visited):
                visited.add(idx)
                count += 1
                dfs(idx,idx)
        
        return count