package practice.backtracking;


public class SolveSudoku {
    //7:05
    public static void main(String []args) {
        int[][] board = new int[][]
                {
                        {3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}
                };
        if (solveSudoku(board)) {
            print(board);
        } else {
            System.out.println("No solution");
        }

    }

    static boolean solveSudoku(int[][] board) {
        int l = board.length;
        int i=0, j=0, k;
        boolean isEmpty = false;
        for (i = 0; i < l; i++) {
            for (j = 0; j < l; j++) {
                if (board[i][j] == 0) {
                    isEmpty = true;
                    break;
                }
            }
            if (isEmpty)
                break;
        }
        if (!isEmpty)
            return true;

        for (k = 1; k <= 9; k++) {
            if (isSafe(board, i, j, k)) {
                board[i][j] = k;
                if (solveSudoku(board)) {
                    return true;
                }
                board[i][j] = 0;
            }
        }

        return false;
    }

    static boolean isSafe(int[][] board, int r, int c, int num) {
        return !isInRow(board, r, num) && !isInCol(board, c, num) && !isInBox(board, r, c, num);
    }

    static boolean isInRow(int[][] board, int r, int num) {
        for (int i = 0; i < board.length; i++) {
            if (board[r][i] == num)
                return true;
        }
        return false;
    }

    static boolean isInCol(int[][] board, int c, int num) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][c] == num)
                return true;
        }
        return false;
    }

    static boolean isInBox(int[][] board, int r, int c, int num) {
        r = r - r % 3;
        c = c - c % 3;
        int i, j;
        for (i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if (board[i + r][j + c] == num) {
                    return true;
                }
            }
        }
        return false;
    }


    static void print(int[][] board) {
        int l = board.length;
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                System.out.print(board[i][j] + " ");
                if ((j + 1) % 3 == 0 && j != l-1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if ((i + 1) % 3 == 0 && i != l-1) {
                System.out.println("------ ------ ------");
            }
        }
    }

}
