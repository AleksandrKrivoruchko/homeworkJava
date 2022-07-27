// Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса,
// например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.
//  Предложить хотя бы одно решение или сообщить, что его нет.
import java.util.ArrayList;
import java.util.List;

public class ExpressionCalc {
    public static void main(String[] args) {
        List<String> listExpr = new ArrayList<>();
        listExpr.add("19? + ?95 = ?93");
        listExpr.add("19? + ?55 = ?93");
        listExpr.add("2? + ?5 = 69");
        listExpr.add("2? + ?? = 6?");
        listExpr.add("19? + ?95 = 93");
        listExpr.add("2? + ?5 =- 69");
        List<String> lsRes = testRestoreExpression(listExpr);
        for (String s : lsRes) {
            System.out.println(s);
//            System.out.println();
        }
    }

    static List<String> testRestoreExpression(List<String> ls) {
        List<String> lsRes = new ArrayList<>();
        String start = "Исходное уравнение:\n";
        String res = "Решение:\n";
        String err = "Ошибка в уравнении ";
        for (String s : ls) {
            if (isExpressionRight(s)) {
                lsRes.add(start + s);
                RestoreExpression tmp = new RestoreExpression(s);
                lsRes.add(res + tmp.isResultExpr());
            } else {
                lsRes.add(start + s);
                lsRes.add(err + s);
            }
        }
        return lsRes;
    }
    static boolean isExpressionRight(String str) {
        boolean plus = true;
        boolean equally = true;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) continue;
            if (str.charAt(i) == '?') continue;
            if (plus && str.charAt(i) == '+') {
                plus = false;
                continue;
            }
            if (equally && str.charAt(i) == '=') {
                equally = false;
                continue;
            }
            if (str.charAt(i) == ' ') continue;
            return false;
        }
        return true;
    }
}
