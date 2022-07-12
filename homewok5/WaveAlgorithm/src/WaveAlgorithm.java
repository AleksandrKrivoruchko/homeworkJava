public class WaveAlgorithm {
    public static void main(String[] args) {
        int m = 10;
        int n = 10;
        int[][] board = new int[m][n];
        printBoard(board);
    }

    static void wave(int[][] board, int startX, int startY) {
        int mark = 1;
        board[startY][startX] = mark;
        int count = board.length * board[0].length;
        int currentX = startX;
        int currentY = startY;
        while (count > 0) {
            mark++;

        }
    }

    static void printBoard(int[][] board) {
        for (int[] ints : board) {
            for (int item : ints) {
                System.out.printf("%4d", item);
            }
            System.out.println();
        }
    }
}
