import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {
	private final EmailValidator validator = new EmailValidator();

	@Test
	void valid() {
		assertTrue(validator.validate("a@b.c"));
		assertTrue(validator.validate("abc.def@mail.com"));
	}

	@Test
	void invalid() {
		assertFalse(validator.validate("42"));
		assertFalse(validator.validate("abc.def@mail"));
	}
}