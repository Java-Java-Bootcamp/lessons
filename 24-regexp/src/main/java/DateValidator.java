import java.time.LocalDate;
import java.util.regex.Pattern;

public class DateValidator implements TextValidator {
	private final static Pattern pattern = Pattern.compile("(\\d{1,2})\\.(\\d{1,2})\\.(\\d{4})");

	@Override
	public boolean validate(String text) {
		var matcher = pattern.matcher(text);
		if (!matcher.matches()) return false;
		try {
			LocalDate.of(Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(1)));

			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

	@Override
	public String name() {
		return "date";
	}
}
