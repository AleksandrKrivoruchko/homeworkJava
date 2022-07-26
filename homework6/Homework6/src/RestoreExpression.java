public class RestoreExpression {
    private String str;
    final private int countArgs = 3;
    final private int arg0 = 0;
    final private int arg1 = 1;
    final private int arg2 = 2;
    int index;
    private int[] overArgs;
    private StringBuilder[] sbExpr;
    private boolean[][] question;
    private int[] res;
    private int[] len;
    public RestoreExpression(String inputStr) {
        str = inputStr;
        parseToSB();
        initializationQuestion();
        initializationLen();
        calcOneArgExpr();
    }

    public StringBuilder[] getSbExpr() {
        return sbExpr;
    }

    public boolean[][] getQuestion() {
        return question;
    }

    public int[] getRes() {
        return res;
    }

    private void calcOneArgExpr() {
        overArgs = new int[question[arg2].length];
        res = new int[countArgs];
        int k = 0;
        for (; len[arg2] >= 0; decrementLen()) {
            if(len[arg0] < 0) {
                break;
            }
            if(fillArray(k)) {
                k++;
                continue;
            }
            restoreDigit(k);
            k++;
        }

    }

    private boolean fillArray(int k) {
        boolean flag = true;
        for(int i = 0; i < countArgs; i++) {
            int tmp = getDigit(sbExpr[i].charAt(len[i]));
            if(tmp == -1) {
                index = i;
                flag = false;
                continue;
            }
            res[i] += tmp * degreeOfTen(k);
        }
        return flag;
    }

    private void restoreDigit(int k) {
        int tmp = 0;
        if (index == arg0) {
            tmp = res[arg2] - res[arg1];
            res[arg0] = calcDigit(tmp, k);
            return;
        }
        if (index == arg1) {
            tmp = res[arg2] - res[arg0];
            res[arg1] = calcDigit(tmp, k);
            return;
        }
        if (index == arg2) {
            res[arg2] = res[arg0] + res[arg1];
        }
    }

    private int calcDigit(int x, int k) {
        if (x < 0) {
            return x + degreeOfTen(k + 1);
        }
        return x;
    }

    private int degreeOfTen(int n) {
        int number = 1;
        for(int i = 0; i < n; i++) {
            number *= 10;
        }
        return number;
    }

    private void decrementLen() {
        for(int i = 0; i < countArgs; i++) {
            len[i]--;
        }
    }

    private void initializationQuestion() {
        question = new boolean[countArgs][];
        for (int i = 0; i < sbExpr.length; i++) {
            question[i] = new boolean[sbExpr[i].length()];
            for (int j = 0; j < question[i].length; j++) {
                if (sbExpr[i].charAt(j) == '?') {
                    question[i][j] = true;
                }
            }
        }
    }

    private void initializationLen() {
        len = new int[countArgs];
        for(int i = 0; i < countArgs; i++) {
            len[i] = question[i].length - 1;
        }
    }

    private void parseToSB() {
        String tmpStr = str.trim().replace(" ", "");
        sbExpr = new StringBuilder[countArgs];
        StringBuilder tmpSB = new StringBuilder();
        int j = 0;
        for (int i = 0; i < tmpStr.length(); i++) {
            if (tmpStr.charAt(i) == '+' || tmpStr.charAt(i) == '=') {
                sbExpr[j] = tmpSB;
                j++;
                tmpSB = new StringBuilder();
                continue;
            }
            tmpSB.append(tmpStr.charAt(i));
        }
        sbExpr[j] = tmpSB;
    }

    private int getDigit(char ch) {
        return switch (ch) {
            case '0' -> 0;
            case '1' -> 1;
            case '2' -> 2;
            case '3' -> 3;
            case '4' -> 4;
            case '5' -> 5;
            case '6' -> 6;
            case '7' -> 7;
            case '8' -> 8;
            case '9' -> 9;
            default -> -1;
        };
    }

    private char getChar(int x) {
        return switch (x) {
            case 0 -> '0';
            case 1 -> '1';
            case 2 -> '2';
            case 3 -> '3';
            case 4 -> '4';
            case 5 -> '5';
            case 6 -> '6';
            case 7 -> '7';
            case 8 -> '8';
            case 9 -> '9';
            default -> '?';
        };
    }
}
