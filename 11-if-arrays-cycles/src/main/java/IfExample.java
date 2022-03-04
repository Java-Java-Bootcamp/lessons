import java.util.Scanner;

public class IfExample {
    public static void main(String[] args) {
//        summerOrWinter();

//        century();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя: ");

        String name = scanner.next();

        switch (name) {
            case "Kate":
                System.out.println("Ice cream");
                break;
            case "Ilya":
                System.out.println("Meat");
                break;
            case "Seva":
                System.out.println("Milk");
                break;
            default:
                System.out.println("Vegetables");
        }

    }

    private static void century() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите год с 1900 по 2022: ");

        int year = scanner.nextInt();

        String century = year < 2000 ? "XX век" : "XXI век";

        System.out.println(century);
    }

    private static void summerOrWinter() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Какой сегодня месяц от 1 до 12? ");

        int month = scanner.nextInt();

        // month = 12
        //    true     &&   false  -> false
        if (month >= 5 && month <= 10) {
            System.out.println("Теплое время года");
        } else {
            System.out.println("Холодное время года");
        }
    }
}
