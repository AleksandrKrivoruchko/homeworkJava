import java.util.Random;

public class FindingPath {
    public static void main(String[] args) {
        int w = 10;
        int h = 10;
        int startX = 1;
        int startY = 1;
        int finishX = 7;
        int finishY = 3;
        int[][] board = new int[h][w];
        board[startY][startX] = -1;
        board[finishY][finishX] = -2;
        Random rnd = new Random();
        for(int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if(rnd.nextInt(100) > 70) {
                    if(board[i][j] == -2 || board[i][j] == -1) {
                        continue;
                    }
                    board[i][j] = -3;
                }
            }
        }
        PrintMatrix(board);
        WaveAlgorithm wave = new WaveAlgorithm(board, startX, startY);

        System.out.println("\n");
        System.out.println(wave.findingPath());
        int[][] snowboard = wave.getSearchField();
        PrintMatrix(snowboard);
    }

    static void PrintMatrix(int[][] array) {
        for(int[] row : array) {
            for (int item : row) {
                System.out.printf("%4d", item);
            }
            System.out.println();
        }
        System.out.println();
    }
}
