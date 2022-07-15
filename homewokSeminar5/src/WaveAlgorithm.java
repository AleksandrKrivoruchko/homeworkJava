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

    public Deque<int[]> getDq() {
        return dq;
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

    public boolean restoringPath() {
        boolean findPath = findingPath();
        if(!findPath) {
            return false;
        }
        dq = new ArrayDeque<>();
        step--;
        int x = endX;
        int y = endY;
        while (step > 0) {
            if(reverseCourse(x-1, y)) {
                x--;
                continue;
            }
            if(reverseCourse(x+1, y)) {
                x++;
                continue;
            }
            if(reverseCourse(x, y-1)) {
                y--;
                continue;
            }
            if(reverseCourse(x, y+1)) {
                y++;
            }
        }

        return true;
    }

    private boolean reverseCourse(int i, int j) {
        if(isReverseStep(i, j)) {
            if(searchField[j][i] == step) {
                dq.push(new int[] {j, i});
                step--;
                return true;
            }
        }
        return false;
    }

    private boolean isFinish(int i, int j) {
        if(searchField[j][i] == finishCell) {
            return true;
        }
        return false;
    }

    private boolean isReverseStep(int i, int j) {
        if(i < 0 || j < 0 || i > width - 1 || j > height - 1) {
            return false;
        }
        return true;
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
