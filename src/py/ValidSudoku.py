"""
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.
The given board contain only digits 1-9 and the character '.'.
The given board size is always 9x9.
"""

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for i in range(9):
            s = set()
            for n in board[i]:
                if n != '.':
                    if n in s:
                        return False
                    else:
                        s.add(n)
        for j in range(9):
            s = set()
            for i in range(9):
                n = board[i][j]
                if n != '.':
                    if n in s:
                        return False
                    else:
                        s.add(n)
        for x in range(3):
            for y in range(3):
                s = set()
                for z in range(9):
                    xx = x * 3 + z % 3
                    yy = y * 3 + z // 3
                    n = board[xx][yy]
                    if n != '.':
                        if n in s:
                            return False
                        else:
                            s.add(n)
        return True
                
                    
        