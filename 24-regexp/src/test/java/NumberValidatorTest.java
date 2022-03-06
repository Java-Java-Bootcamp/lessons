import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberValidatorTest {
	private final NumberValidator validator = new NumberValidator();

	@ParameterizedTest
	@ValueSource(strings = { "+123", "-42", "1.23", "1e20", "1e-20" })
	void valid(String candidate) {
		assertTrue(validator.validate(candidate));
	}

	@ParameterizedTest
	@ValueSource(strings = { "+", "-+42", "1.2.3", "1e"})
	void invalid(String candidate) {
		assertFalse(validator.validate(candidate));
	}


}