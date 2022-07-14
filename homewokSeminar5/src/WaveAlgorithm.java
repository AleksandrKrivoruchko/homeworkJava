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

    public WaveAlgorithm(int[][] array, int x, int y) {
        searchField = array;
        step = 1;
        freeCell = 0;
        finishCell = -2;
        width = searchField[0].length;
        height = searchField.length;
        dq = new ArrayDeque<>();
        dq.push(new int[]{y, x});
    }

    public int[][] getSearchField() {
        return searchField;
    }

    public boolean findingPath() {
        while (step < height*width) {
            if(!moveWave())
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
            return false;
        }

        Deque<int[]> tmpDq = new ArrayDeque();
        while (!dq.isEmpty()) {
            int[] tmp = dq.poll();
            int tmpX = tmp[1];
            int tmpY = tmp[0];

            if (isNextStep(tmpX + 1, tmpY)) {
                if (isFinish(tmpX + 1, tmpY)) {
                    return false;
                }
                setFreeCell(tmpX + 1, tmpY, tmpDq);
            }
            if (isNextStep(tmpX - 1, tmpY)) {
                if (isFinish(tmpX - 1, tmpY)) {
                    return false;
                }
                setFreeCell(tmpX - 1, tmpY, tmpDq);
            }
            if (isNextStep(tmpX, tmpY + 1)) {
                if (isFinish(tmpX, tmpY + 1)) {
                    return false;
                }
                setFreeCell(tmpX, tmpY + 1, tmpDq);
            }
            if (isNextStep(tmpX, tmpY - 1)) {
                if (isFinish(tmpX, tmpY - 1)) {
                    return false;
                }
                setFreeCell(tmpX, tmpY - 1, tmpDq);
            }
        }
        dq = tmpDq;
        step++;
        FindingPath.PrintMatrix(searchField);
        System.out.println(step);
        return true;
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
