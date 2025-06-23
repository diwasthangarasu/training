public class NQueens {
    static int N;

   
    static void printSolution(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print((cell == 1 ? "Q " : ". "));
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check if it's safe to place a queen at board[row][col]
    static boolean isSafe(int[][] board, int row, int col) {
        // Check this row on left side
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal on left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal on left side
        for (int i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Recursive utility function to solve N Queens problem
    static boolean solveNQueens(int[][] board, int col) {
        if (col >= N) {
            printSolution(board);
            return true; // all queens placed
        }

        boolean res = false;
        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col)) {
                board[i][col] = 1;
                res = solveNQueens(board, col + 1) || res;
                board[i][col] = 0; // BACKTRACK
            }
        }
        return res;
    }

    // Main function to call the solver
    public static void main(String[] args) {
        N = 4; // Change N to any number (like 8 for 8-Queens)
        int[][] board = new int[N][N];

        if (!solveNQueens(board, 0)) {
            System.out.println("Solution does not exist");
        }
    }
}