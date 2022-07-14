import java.util.ArrayDeque;
import java.util.Deque;

public class WaveAlgorithm {
    private int step;
    private int[][] searchField;
    private Deque<int[]> dq;
    private int width;
    private int height;
    private int freeCell;
    private int finishCell;
    private int startCell;
    private int endX;
    private int endY;

    public WaveAlgorithm(int[][] array, int x, int y, int endX, int endY) {
        searchField = array;
        this.endX = endX;
        this.endY = endY;
        step = 1;
        freeCell = 0;
        finishCell = -2;
        startCell = -1;
        width = searchField[0].length;
        height = searchField.length;
        dq = new ArrayDeque<>();
        dq.push(new int[]{y, x});
    }

    public int[][] getSearchField() {
        return searchField;
    }

    public boolean findingPath() {
        int n = width * height;
        while (step < n) {
            if(moveWave())
                return true;
        }
        return false;
    }

    private void setFreeCell(int i, int j, Deque<int[]> dq) {
        searchField[j][i] = step;
        dq.push(new int[] {j,i});
    }

    private boolean moveWave() {
        if(dq.isEmpty()) {
            step = width * height;
            return false;
        }

        Deque<int[]> tmpDq = new ArrayDeque<>();
        while (!dq.isEmpty()) {
            int[] tmp = dq.poll();
            int tmpX = tmp[1];
            int tmpY = tmp[0];

            if (nextMove(tmpX + 1, tmpY, tmpDq)) {
                    return true;
            }
            if (nextMove(tmpX - 1, tmpY, tmpDq)) {
                    return true;
            }
            if (nextMove(tmpX, tmpY + 1, tmpDq)) {
                    return true;
            }
            if (nextMove(tmpX, tmpY - 1, tmpDq)) {
                    return true;
            }
        }
        dq = tmpDq;
        step++;
        FindingPath.PrintMatrix(searchField);
        System.out.println(step);
        return false;
    }

    private boolean nextMove(int i,int j, Deque<int[]> tmp) {
        if(isNextStep(i,j)) {
            if(isFinish(i,j)) {
                return true;
            }
            setFreeCell(i,j,tmp);
        }
        return false;
    }

    private boolean isStart(int i, int j) {
        if(searchField[j][i] == startCell) {
            return true;
        }
        return false;
    }

    private boolean isFinish(int i, int j) {
        if(searchField[j][i] == finishCell) {
            return true;
        }
        return false;
    }

    private boolean isNextStep(int i, int j) {

        if(i < 0 || j < 0 || i > width - 1 || j > height - 1) {
            return false;
        }
        if(isFinish(i,j)) {
            return true;
        }
        if(searchField[j][i] != freeCell) {
            return false;
        }
        return true;
    }
}
