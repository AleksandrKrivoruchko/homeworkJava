public class RestoreExpression {
    private String str;
    final private int countArgs = 3;
    final private int arg0 = 0;
    final private int arg1 = 1;
    final private int arg2 = 2;
    int index;
    private StringBuilder[] sbExpr;
    private int[] res;
    private int[] len;
    public RestoreExpression(String inputStr) {
        str = inputStr;
        parseToSB();
        initializationLen();
    }

    public StringBuilder[] getSbExpr() {
        return sbExpr;
    }

    public int[] getRes() {
        return res;
    }

    public String isResultExpr() {
        String tmpStr = String.format("Для уравнения %s решения нет", str);
        if (len[arg0] > len[arg2] || len[arg1] > len[arg2]) {
            return tmpStr;
        }
        if (calcOneArgExpr()) {
            return String.format("%d + %d = %d",
                    res[arg0], res[arg1], res[arg2]);
        }
        return tmpStr;
    }

    private boolean calcThreeArgExpr(int k) {
        int[] tmpArr = copyArray(res);
        for (int j = 0; j < 10; j++) {
            sbExpr[arg0].setCharAt(len[arg0], getChar(j));
            if(calcTwoArgExpr(k)) {
                return true;
            }
            res = copyArray(tmpArr);
        }
        return false;
    }

    private boolean calcTwoArgExpr(int k) {
        int[] tmpArr = copyArray(res);
        for (int i = 0; i < countArgs; i++) {
            if (sbExpr[i].charAt(len[i]) == '?') {
                for (int j = 0; j < 10; j++) {
                    sbExpr[i].setCharAt(len[i], getChar(j));
                    fillArray(k);
                    restoreDigit(k);
                    if (res[arg0] + res[arg1] == res[arg2]) {
                        return true;
                    }
                    res = copyArray(tmpArr);
                }
                return false;
            }
        }
        return false;
    }

    private int[] copyArray(int[] sourceArr) {
        int lenArr = sourceArr.length;
        int[] newArr = new int[lenArr];
        for (int i = 0; i < lenArr; i++) {
            newArr[i] = sourceArr[i];
        }
        return newArr;
    }

    private int countQuestion() {
        int qCount = 0;
        for(int i = 0; i < countArgs; i++) {
            if (sbExpr[i].charAt(len[i]) == '?') {
                qCount++;
            }
        }
        return qCount;
    }

    private boolean calc(int x, int y, int c, int k) {
        int tmpX = getDigit(sbExpr[x].charAt(len[x]));
        int tmpC = getDigit(sbExpr[c].charAt(len[c]));
        if (tmpX == -1 && tmpC == -1) {
            res[x] += degreeOfTen(k);
            res[c] = res[x] + res[y];
            return true;
        }
        if (tmpX == -1) {
            res[c] += tmpC * degreeOfTen(k);
            res[x] = res[c] - res[y];
            return true;
        }
        if (tmpC == -1) {
            res[x] += tmpX * degreeOfTen(k);
            res[c] = res[x] + res[y];
            return true;
        }
        return tmpC == tmpX;
    }

    private boolean calcOneArgExpr() {
        res = new int[countArgs];
        int k = 0;
        for (; len[arg2] >= 0; decrementLen()) {
            if(len[arg0] < 0 || len[arg1] < 0) {
                if (len[arg0] == len[arg2]) {
                    if(calc(arg0, arg0, arg2, k)) {
                    k++;
                    continue;
                    }
                    return false;
                }
                if (len[arg1] == len[arg2]) {
                    if (calc(arg1, arg0, arg2, k)) {
                        k++;
                        continue;
                    }
                    return false;
                }
                break;
            }
            if(countQuestion() == 3) {
                if(!calcThreeArgExpr(k)) {
                    return false;
                }
                k++;
                continue;
            }
            if(countQuestion() == 2) {
                if(!calcTwoArgExpr(k)){
                    return false;
                }
                k++;
                continue;
            }
            if(fillArray(k)) {
                if (res[arg0] + res[arg1] != res[arg2]) {
                    return false;
                }
                k++;
                continue;
            }
            restoreDigit(k);
            k++;
        }
        return res[arg0] + res[arg1] == res[arg2];
    }

    private boolean fillArray(int k) {
        boolean flag = true;
        for(int i = 0; i < countArgs; i++) {
            if(len[i] < 0) {
                continue;
            }
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

    private void initializationLen() {
        len = new int[countArgs];
        for(int i = 0; i < countArgs; i++) {
            len[i] = sbExpr[i].length() - 1;
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
