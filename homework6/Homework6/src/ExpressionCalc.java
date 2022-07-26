// Задано уравнение вида q + w = e, q, w, e >= 0. Некоторые цифры могут быть заменены знаком вопроса,
// например 2? + ?5 = 69. Требуется восстановить выражение до верного равенства.
//  Предложить хотя бы одно решение или сообщить, что его нет.

public class ExpressionCalc {
    public static void main(String[] args) {
        String strExpr = "2? + 35 = ?3";
        System.out.println(strExpr);
        RestoreExpression re = new RestoreExpression(strExpr);
//        StringBuilder[] cb = re.getSbExpr();
//        for(StringBuilder c : cb) {
//            System.out.printf("%s  ", c);
//        }
//        System.out.println();
//        boolean[][] q = re.getQuestion();
//        for (boolean[] qArr : q) {
//            for (boolean qArg : qArr) {
//                System.out.printf("%s  ", qArg);
//            }
//            System.out.println();
//        }
        int[] res = re.getRes();
        for (int x : res) {
            System.out.printf("%d ", x);
        }
    }
}
