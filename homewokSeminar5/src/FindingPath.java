import java.util.Random;
import java.util.Deque;

public class FindingPath {
    public static void main(String[] args) {
        int width = 10;
        int height = 10;
        int startX = 1;
        int startY = 0;
        int finishX = 9;
        int finishY = 9;
        int[][] board = new int[height][width];
        board[startY][startX] = -1;
        board[finishY][finishX] = -2;
        Random rnd = new Random();
        for(int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if(rnd.nextInt(100) > 70) {
                    if(board[i][j] == -2 || board[i][j] == -1) {
                        continue;
                    }
                    board[i][j] = -3;
                }
            }
        }
        System.out.println("Начальная матрица:\n" +
                "(S - точка старта, E - окончание пути, # - препятствие, 0 - свободные ячейки)");
        System.out.println(WaveToStringBuilder(board));
        WaveAlgorithm wave = new WaveAlgorithm(board, startX, startY, finishX, finishY);

        boolean flag = wave.restoringPath();
        int[][] snowboard = wave.getSearchField();

        if(flag) {
            Deque<int[]> dq = wave.getDq();
            System.out.println("Матрица с проложенным машрутом:\n" +
                    "(+ - обозначение машрута)");
            System.out.println(PathToStringBuilder(snowboard, dq));
        } else {
            System.out.println("Не удалось проложить маршрут:\n" +
                    "(цифрами обозначены шаги, которые удалось сделать)");
            System.out.println(WaveToStringBuilder(snowboard));
        }

    }

    static StringBuilder WaveToStringBuilder(int[][] array) {
        StringBuilder str = new StringBuilder();
        for (int[] row : array) {
            for (int item : row) {
                if(item == -1) {
                    str.append(String.format("%4s", 'S'));
                    continue;
                }
                if(item == -2) {
                    str.append(String.format("%4s", 'E'));
                    continue;
                }
                if(item == -3) {
                    str.append(String.format("%4s", '#'));
                    continue;
                }

                str.append(String.format("%4s", item));
            }
            str.append('\n');
        }
        str.append('\n');
        return str;
    }

    static StringBuilder PathToStringBuilder(int[][] array, Deque<int[]> dq) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if(array[i][j] == -1) {
                    str.append(String.format("%4s", 'S'));
                    continue;
                }
                if(array[i][j] == -2) {
                    str.append(String.format("%4s", 'E'));
                    continue;
                }
                if(array[i][j] == -3) {
                    str.append(String.format("%4s", '#'));
                    continue;
                }
                if(isCoordinates(i, j, dq)) {
                    str.append(String.format("%4s", '+'));
                    continue;
                }
                str.append(String.format("%4s", '0'));
            }
            str.append('\n');
        }
        str.append('\n');
        return str;
    }

    static boolean isCoordinates(int i, int j, Deque<int[]> dq) {
        for (int[] row : dq) {
            if(i == row[0] && j == row[1]) {
                return true;
            }
        }
        return false;
    }
}
