import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Пишем калькулятор для одной операции "+"
 * 1) Предлагаем пользователю ввести 2 числа и операцию над ними
 * 2) Если пользователь ввел +, выводим результат
 * 3) Если пользователь вводит другую операцию - выводим сообщение об ошибке
 */
public class Ex1CalculatorSingleOperation {
    public static void main(String[] args) {
        simpleImplementation();
        // inputFormatGuardImplementation();
    }

    private static void simpleImplementation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Integer.MAX_VALUE); // 2147483647
        System.out.println(Integer.MIN_VALUE); // -2147483648

        System.out.println("Введите первое слагаемое:");

        int a = scanner.nextInt();

        System.out.println("Введите второе слагаемое:");
        int b = scanner.nextInt();

        System.out.println("Введите операцию:");
        String operation = scanner.next();

        if ("+".equals(operation)) {
            //возможно переполнение: например, 2147483647 + 2 = -2147483647
            int sum = a + b;
            System.out.println(a + " " + operation + " " + b + " = " + sum);
        } else {
            System.out.println("Неизвестный оператор");
        }
    }

    private static void inputFormatGuardImplementation() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Integer.MAX_VALUE); // 2147483647
        System.out.println(Integer.MIN_VALUE); // -2147483648

        System.out.println("Введите первое слагаемое:");

        int a = 0;
        boolean isCorrectA = false;

        while (!isCorrectA) {
            try {
                a = scanner.nextInt();
                // если пользователь ввел не число, то мы сразу проваливаемся в catch блок, isCorrectA останется false
                isCorrectA = true;
            } catch (InputMismatchException e) {
                System.out.println("Необходимо ввести целое число!");
            }
        }

        System.out.println("Введите второе слагаемое:");
        int b = 0;
        boolean isCorrectB = false;

        do {
            try {
                b = new Scanner(System.in).nextInt(); // бага в сканнере после первой ошибке чтения
                isCorrectB = true;
            } catch (InputMismatchException e) {
                System.out.println("Необходимо ввести целое число!");
            }
        } while (!isCorrectB);

        System.out.println("Введите операцию:");
        String operation = scanner.next();

        if ("+".equals(operation)) {
            //возможно переполнение: например, 2147483647 + 2 = -2147483647
            int sum = a + b;
            System.out.println(a + " " + operation + " " + b + " = " + sum);
        } else {
            System.out.println("Неизвестный оператор");
        }
    }
}
