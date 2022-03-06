import java.util.regex.Pattern;

public class NumberValidator implements TextValidator {
	private final static Pattern pattern = Pattern.compile("[+-]?\\d+(\\.\\d+)?(e[+-]?\\d+)?");

	@Override
	public boolean validate(String text) {
		return pattern.matcher(text).matches();
	}

	@Override
	public String name() {
		return "number";
	}
}
