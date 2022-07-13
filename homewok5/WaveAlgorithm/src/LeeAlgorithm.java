import java.util.*;

public class LeeAlgorithm {
    public int[][] ArrayGraph;
    public List<List<Integer>> path;
    public int width;
    public int height;
    public boolean pathFound;
    public int lengthPath;

    int figStartPosition = 0;
    int figEmptySpace = -1;
    int figDestination = -2;
    int figPath = -3;
    int figBarrier = -4;

    public int getLengthPath() {
        return path.size();
    }

    private int step;
    private boolean finishingCellMarked;
    private int finishPointI;
    private int finishPointJ;

    public LeeAlgorithm(int startX, int startY, int[][] array) {
        ArrayGraph = array;
        width = ArrayGraph[0].length;
        height = ArrayGraph.length;
        setStartCell(startX, startY);
        pathFound = pathSearch();
    }

    public LeeAlgorithm(int[][] array) {
        ArrayGraph = array;
        width = ArrayGraph[0].length;
        height = ArrayGraph.length;
        int[] startXY = new int[2];
        findStartCell(startXY);
        setStartCell(startXY[0], startXY[1]);
        pathFound = pathSearch();
    }

    private void findStartCell(int[] startXY) {
        int w = width;
        int h = height;
        for(int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (ArrayGraph[i][j] == figStartPosition) {
                    startXY[0] = i;
                    startXY[1] = j;
                    return;
                }
            }
        }
        System.out.println("Нет начальной точки");
        System.exit(1);
    }

    private void setStartCell(int startX, int startY) {
        if(startX > width -1 || startX < 0) {
            System.out.printf("Неправильная координата x = %d", startX);
            System.exit(1);
        }
        if(startY > height - 1 || startY < 0) {
            System.out.printf("Неправильная координата y = %d", startY);
            System.exit(1);
        }
        step = 0;
        ArrayGraph[startY][startX] = step;
    }

    private boolean pathSearch() {
        if(wavePropagation()) {
            if(restorePath()) {
                return true;
            }
        }
        return false;
    }

    private boolean wavePropagation() {
        int w = width;
        int h = height;
        boolean finished = false;
        do {
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if(ArrayGraph[i][j] == step) {
                        if(i != h - 1) {
                            if(ArrayGraph[i+1][j] == figEmptySpace) {
                                ArrayGraph[i+1][j] = step + 1;
                            }
                        }
                        if(j != w -1) {
                            if(ArrayGraph[i][j+1] == figEmptySpace) {
                                ArrayGraph[i][j+1] = step + 1;
                            }
                        }
                        if(i != 0) {
                            if(ArrayGraph[i-1][j] == figEmptySpace) {
                                ArrayGraph[i-1][j] = step + 1;
                            }
                        }
                        if(j != 0) {
                            if(ArrayGraph[i][j-1] == figEmptySpace) {
                                ArrayGraph[i][j-1] = step + 1;
                            }
                        }
                        if(j < w -1) {
                            if(ArrayGraph[i][j+1] == figDestination) {
                                finishPointJ = j + 1;
                                finishPointI = i;
                                finished = true;
                            }
                        }
                        if(i < h -1) {
                            if(ArrayGraph[i+1][j] == figDestination) {
                                finishPointJ = j;
                                finishPointI = i + 1;
                                finished = true;
                            }
                        }
                        if(i > 0) {
                            if(ArrayGraph[i-1][j] == figDestination) {
                                finishPointI = i - 1;
                                finishPointJ = j;
                                finished = true;
                            }
                        }
                        if(j > 0) {
                            if(ArrayGraph[i][j-1] == figDestination) {
                                finishPointI = i;
                                finishPointJ = j - 1;
                                finished = true;
                            }
                        }
                    }
                }
            }
            step++;
        } while (!finished && step < w * h);
        finishingCellMarked = finished;
        return finished;
    }

    private boolean restorePath() {
        if(!finishingCellMarked) {
            return false;
        }
        int w = width;
        int h = height;
        int i = finishPointI;
        int j = finishPointJ;
        path = new LinkedList<>(new LinkedList<>());
        path.add(List.of(i,j));
        do {
            if (j < w -1) {
                if(ArrayGraph[i][j+1] == step -1) {
                    path.add(List.of(i, ++j));
                }
            }
            if (i < h -1) {
                if(ArrayGraph[i+1][j] == step -1) {
                    path.add(List.of(++i, j));
                }
            }
            if(i > 0) {
                if(ArrayGraph[i-1][j] == step - 1) {
                    path.add(List.of(--i, j));
                }
            }
            if(j>0) {
                if(ArrayGraph[i][j-1] == step - 1) {
                    path.add(List.of(i, --j));
                }
            }
            step--;
        } while (step != 0);
        return true;
    }
}
