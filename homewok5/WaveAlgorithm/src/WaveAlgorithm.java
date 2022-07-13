import java.util.Random;

public class WaveAlgorithm {
    public static void main(String[] args) {
        int figStartPosition = 0;
        int figEmptySpace = -1;
        int figDestination = -2;
        int figPath = -3;
        int figBarrier = -4;
        int height = 10;
        int width = 10;
        int[][] my = new int[height][width];
        Random rand = new Random();
        for (int i = 0; i < height; i++) {
            for (int j= 0; j < width; j++) {
                if(rand.nextInt(100) > 70) {
                    my[i][j] = figBarrier;
                } else {
                    my[i][j] = figEmptySpace;
                }
            }
        }
        my[rand.nextInt(height)][rand.nextInt(width)] = figStartPosition;
        my[rand.nextInt(height)][rand.nextInt(width)] = figDestination;
        printBoard(my);

        LeeAlgorithm li = new LeeAlgorithm(my);
        System.out.println(li.pathFound);
        printBoard(my);
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
