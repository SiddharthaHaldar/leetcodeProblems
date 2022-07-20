class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        r = {} 
        c = {}
        squares = {}
        for row in range(9):
            for col in range(9):
                val = board[row][col]
                if val == ".":
                    continue
                if row not in r:
                    r[row] = set()
                if col not in c:
                    c[col] = set()
                if (row//3,col//3) not in squares:
                    squares[(row//3,col//3)] = set()
                if(val in r[row] or
                   val in c[col] or
                   val in squares[(row//3,col//3)]):
                    return False
                
                r[row].add(val)
                c[col].add(val)
                squares[(row//3,col//3)].add(val)
                #print(r,c,squares)
        return True