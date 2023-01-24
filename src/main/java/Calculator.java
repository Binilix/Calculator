import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws Exception {
        String expression = "";

        System.out.println("Введите выражение через пробелы ");
        Scanner scanner = new Scanner(System.in);
        expression = scanner.nextLine();
        String[] value = expression.split(" ");
        if (value.length != 3) {
            throw new Exception("Неправильный ввод");
        }
        switch (Operation.getOperationFromString(value[1])) {
            case DIV:
            case MINUS:
            case MUL:
            case PLUS:
                break;
            default:
                throw new Exception("используются одновременно разные системы счисления");
        }
        /*
        Попробовать спарсить оба операнда.
        Если оба спарсились, значит оба арабские.
        Если одно спарсилось, а второе нет, кидаем ошибку.
        Если оба не спарсились, проверяем что строки в первом и втором операнде
        являтся строками из Enum RimNumb.
         */
        int firstOperation = 0;
        int secondOperation = 0;
        boolean firstExceptionIsHappened = false;
        boolean secondExceptionIsHappened = false;
        try {
            firstOperation = Integer.parseInt(value[0]);
        } catch (Exception exception) {
            firstExceptionIsHappened = true;
        }
        try {
            secondOperation = Integer.parseInt(value[2]);
        } catch (Exception exception) {
            secondExceptionIsHappened = true;
        }
        if ((firstExceptionIsHappened && !secondExceptionIsHappened) || (!firstExceptionIsHappened && secondExceptionIsHappened)) {
            throw new Exception("Ошибка цифры не те");
        }
        if (firstExceptionIsHappened && secondExceptionIsHappened) {
            RimNumb firstRimNumb = RimNumb.getRimNumb(value[0]);
            RimNumb secondRimNumb = RimNumb.getRimNumb(value[2]);
            if (firstRimNumb == null || secondRimNumb == null) {
                throw new Exception("Превышен лимит числа или введены неверные значения");
            }
            firstOperation = firstRimNumb.value;
            secondOperation = secondRimNumb.value;
        }
        if ((firstOperation > 0 && firstOperation < 11) && (secondOperation > 0 && secondOperation < 11)) {

            if (firstExceptionIsHappened && secondExceptionIsHappened) {
                System.out.println(RomeCalc.toRoman((int) Calc(firstOperation, secondOperation, value[1])));
            } else System.out.println(Calc(firstOperation, secondOperation, value[1]));

        } else throw new Exception("Превышен лимит числа");


    }

    int result = 0;

    public static double Calc(int firstNumb, int secondNumb, String operation) {
        int result = 0;
        switch (Operation.getOperationFromString(operation)) {
            case DIV:
                result = firstNumb / secondNumb;
                break;
            case MINUS:
                result = firstNumb - secondNumb;
                break;
            case MUL:
                result = firstNumb * secondNumb;
                break;
            case PLUS:
                result = firstNumb + secondNumb;
                break;
        }
        return result;

    }
}
