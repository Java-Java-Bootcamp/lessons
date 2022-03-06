import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		TextValidator[] validators = {new NumberValidator(), new PhoneValidator(), new EmailValidator()};
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();

			if (line.equals("exit"))
				break;

			boolean found = false;
			for (TextValidator validator : validators) {
				if (validator.validate(line)) {
					System.out.println("it`s a " + validator.name());
					found = true;
					break;
				}
			}
			if (!found)
				System.out.println("i dont know...");
		}
	}
}
