import java.util.regex.Pattern;

public class PhoneValidator implements TextValidator {
	private final static Pattern pattern = Pattern.compile("((\\+\\d+)|8)[(]?\\d{3}[)]?\\d{3}-?\\d{2}-?\\d{2}");

	@Override
	public boolean validate(String text) {
		return pattern.matcher(text).matches();
	}

	@Override
	public String name() {
		return "phone";
	}
}
