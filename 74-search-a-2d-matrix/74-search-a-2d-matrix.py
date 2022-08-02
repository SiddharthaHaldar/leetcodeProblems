class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        l,r,idx = 0,len(matrix) - 1,0
        Found = False
        while l <= r:
            mid = (l+r) // 2
            #print(mid,matrix[mid][0],matrix[mid][-1])
            if(target >= matrix[mid][0] and target <= matrix[mid][-1]):
                Found = True
                idx = mid
                break
            elif(target < matrix[mid][0]):
                r = mid - 1
            elif(target > matrix[mid][-1]):
                l = mid + 1
                 
        #print(Found) 
        if not Found:
            return Found
        
        Found = False
        l,r = 0,len(matrix[idx])
        while l <= r:
            mid = (l+r) // 2
            if(target == matrix[idx][mid]):
                return True
            elif(target < matrix[idx][mid]):
                r = mid - 1
            elif(target > matrix[idx][mid]):
                l = mid + 1
        
        return Found
        
        