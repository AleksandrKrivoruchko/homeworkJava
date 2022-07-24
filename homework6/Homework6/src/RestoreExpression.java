import java.util.Locale;

public class RestoreExpression {
    private String str;
    private int countArgs = 3;
    private int arg0 = 0;
    private int arg1 = 1;
    private int arg2 = 2;
    private int[] overArgs;
    private StringBuilder[] cbExpr;
    private boolean[][] question;
    public RestoreExpression(String inputStr) {
        str = inputStr;
        parseToSB();
        initializationQuestion();
        calcOneArgExpr();
    }

    public StringBuilder[] getCbExpr() {
        return cbExpr;
    }

    public boolean[][] getQuestion() {
        return question;
    }

    private void calcOneArgExpr() {
        overArgs = new int[question[arg2].length];
        int k = 0;
        for(int i = 0; i < countArgs; i++) {
            for(int j = 0; j < question[i].length; j++) {
                if(question[i][j]) {
                    restoreDigit(i, j, k);
                    k++;
                }
            }
        }
    }

    private void restoreDigit(int i, int j, int k) {
        int tmp = 0;
        int overArg = k > 0 ? overArgs[k-1] : 0;
        int a = cbExpr[arg0].charAt(j) == '?' ? 0 : getDigit(cbExpr[arg0].charAt(j));
        int b = cbExpr[arg1].charAt(j) == '?' ? 0 : getDigit(cbExpr[arg1].charAt(j));
        int c = cbExpr[arg2].charAt(j) == '?' ? 0 : getDigit(cbExpr[arg2].charAt(j));
        if (i == arg0) {
            tmp = calcDigit( c - b + overArg, k);
            cbExpr[arg0].setCharAt(j, getChar(tmp));
        }
        if (i == arg1) {
            tmp = calcDigit(c - a + overArg, k);
            cbExpr[arg1].setCharAt(j, getChar(tmp));
        }
        if (i == arg2) {
            tmp = calcDigit(a + b - overArg, k);
            cbExpr[arg2].setCharAt(j, getChar(tmp));
        }
    }

    private int calcDigit(int x, int k) {
        if (x < 0) {
            overArgs[k] = -1;
            return x + 10;
        }
        if (x > 9) {
            overArgs[k] = 1;
            return x % 10;
        }
        overArgs[k] = 0;
        return x;
    }

    private void initializationQuestion() {
        question = new boolean[countArgs][];
        for (int i = 0; i < cbExpr.length; i++) {
            question[i] = new boolean[cbExpr[i].length()];
            for (int j = 0; j < question[i].length; j++) {
                if (cbExpr[i].charAt(j) == '?') {
                    question[i][j] = true;
                }
            }
        }
    }

    private void parseToSB() {
        String tmpStr = str.trim().replace(" ", "");
        cbExpr = new StringBuilder[countArgs];
        StringBuilder tmpSB = new StringBuilder();
        int j = 0;
        for (int i = 0; i < tmpStr.length(); i++) {
            if (tmpStr.charAt(i) == '+' || tmpStr.charAt(i) == '=') {
                cbExpr[j] = tmpSB ;
                j++;
                tmpSB = new StringBuilder();
                continue;
            }
            tmpSB.append(tmpStr.charAt(i));
        }
        cbExpr[j] = tmpSB;
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
