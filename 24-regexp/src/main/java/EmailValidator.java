import java.util.regex.Pattern;

public class EmailValidator implements TextValidator {
	private final static Pattern pattern = Pattern.compile("[a-zA-Z][a-zA-Z0-9.]*@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+");

	@Override
	public boolean validate(String text) {
		return pattern.matcher(text).matches();
	}

	@Override
	public String name() {
		return "email";
	}
}
