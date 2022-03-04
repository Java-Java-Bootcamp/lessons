import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Добавляем индексированный вывод и ввод поддерживаемых операций.
 * Формат вывода:
 * <p>
 * Введите индекс операции:
 * 1. +
 * 2. -
 * 3. *
 * 4. /
 * <p>
 * Пользователь должен считать число от 1 до 4.
 * Калькулятор выполняет соответствующую введенному индекс операцию.
 * Обратите внимание! Индекс операции, вводимый пользователем, отличается от индекса операции в массиве.
 * <p>
 * Для упрощения, в реализации не делается проверка на некорректный ввод.
 */
public class Ex4CalculatorIndexedOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(Integer.MAX_VALUE); // 2147483647
        System.out.println(Integer.MIN_VALUE); // -2147483648

        System.out.println("Введите первое слагаемое:");

        int a = scanner.nextInt();

        System.out.println("Введите второе слагаемое:");
        int b = scanner.nextInt();

        System.out.println("Введите операцию:");

        String[] operations = {"+", "-", "*", "/"};

        for (int idx = 0; idx < operations.length; idx++) {
            System.out.println(
                    (idx + 1) + ". " + operations[idx]
            );
        }

        int opIdx = scanner.nextInt();

        if (opIdx > 0 && opIdx < operations.length) {

            String operation = operations[opIdx - 1];

            switch (operation) {
                case "+":
                    int sum = a + b;
                    System.out.println(a + " " + operation + " " + b + " = " + sum);
                    break;
                case "-":
                    int min = a - b;
                    System.out.println(a + " " + operation + " " + b + " = " + min);
                    break;
                case "*":
                    int mul = a * b;
                    System.out.println(a + " " + operation + " " + b + " = " + mul);
                    break;
                case "/":
                    double div = ((double) a) / b; // possible ArithmeticException
                    System.out.println(a + " " + operation + " " + b + " = " + div);
                    break;
                default:
                    System.out.println("Неизвестный оператор");
            }
        } else {
            System.out.println("Неверный индекс. Введить от 1 до " + operations.length);
        }
    }
}
