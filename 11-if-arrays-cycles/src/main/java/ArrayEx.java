import java.util.Scanner;

public class ArrayEx {
    public static void main(String[] args) {
        String[][] activities = {
                {"Monday", "Мороженка"},
                {"Tuesday", "Чай"},
                {"Wednesday", "Бассейн"},
                {"Thursday", "Работа"},
                {"Friday", "Друзья"},
                {"Saturday", "Отсыпной"},
                {"Sunday", "Поход к бабушке", "Урааа"}
        };

        System.out.println("Введите день недели: ");

        Scanner scanner = new Scanner(System.in);
        String day = scanner.next();

//        String activity = doWhileExample(activities, day);

//        String activity = whileExample(activities, day);

//        String activity = forExample(activities, day);

        String activity = "";

        for (String[] dayActivity : activities) {
            if (day.equals(dayActivity[0])) {
                activity = dayActivity[1];
                break;
            }
        }

        System.out.println(activity);
    }

    private static String forExample(String[][] activities, String day) {
        String activity = "";

        for (int idx = 0; idx < activities.length; idx++) {
            String[] dayActivity = activities[idx];

            if (day.equals(dayActivity[0])) {
                activity = dayActivity[1];
                break;
            }
        }
        return activity;
    }

    private static String whileExample(String[][] activities, String day) {
        String activity = "";
        int idx = 0;

        while (idx < activities.length) {
            String[] dayActivity = activities[idx];

            if (day.equals(dayActivity[0])) {
                activity = dayActivity[1];
                break;
            }

            idx++; // idx = idx + 1
        }
        return activity;
    }

    private static String doWhileExample(String[][] activities, String day) {
        String activity = "";
        int idx = 0;

        do {
            String[] dayActivity = activities[idx];

            if (day.equals(dayActivity[0])) {
                activity = dayActivity[1];
                break;
            }

            idx++; // idx = idx + 1
        } while (idx < activities.length);

        return activity;
    }
}
