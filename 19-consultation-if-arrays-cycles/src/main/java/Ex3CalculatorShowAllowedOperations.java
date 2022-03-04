import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Добавляем вывод поддерживаемых операций.
 * Формат вывода:
 * <p>
 * Введите операцию:
 * + - * /
 * <p>
 * Для упрощения, в реализации не делается проверка на некорректный ввод.
 */
public class Ex3CalculatorShowAllowedOperations {
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

        String allowedOperations = "";

        for (String op : operations) {
            allowedOperations = allowedOperations + " " + op;
        }

        System.out.println(allowedOperations);

        String operation = scanner.next();

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
                // явное приведение типов - защита от целоисленного деления
                double div = ((double) a) / b; // possible ArithmeticException
                System.out.println(a + " " + operation + " " + b + " = " + div);
                break;
            default:
                System.out.println("Неизвестный оператор");
        }
    }
}
