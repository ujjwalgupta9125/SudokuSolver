class Solution {
    public void solveSudoku(char[][] board) {
      solve(board);
    }
    
    boolean solve(char[][] board)
    {
     for (int i = 0; i < 9; i++)
     {
      for (int j = 0; j < 9; j++)
      {
        if (board[i][j] == '.')  // Checking empty places in board
         {
          for (char c = '1'; c <= '9'; c++) // putting values and checking for validation
          {
            if(isValid(board, i, j, c))
            {
              board[i][j] = c;

              if (solve(board))
                return true;
              else
                board[i][j] = '.';
            }
          }

          return false;
        }
      }
    }
    return true;
  }

  boolean isValid(char[][] board, int row, int col, char c) { // Checking the Conditions 
    for (int i = 0; i < 9; i++)
    {
       if (board[i][col] == c)//checking in column
        return false;

       if (board[row][i] == c)//checking in row
        return false;

       if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)// checking in 3 x 3 Grid
       return false;
    }
    return true;
  }

    
}
