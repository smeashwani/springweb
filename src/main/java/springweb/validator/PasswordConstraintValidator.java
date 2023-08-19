package springweb.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<Password, String> {
	@Override
	public boolean isValid(String s, ConstraintValidatorContext cvc) {
		boolean result = s.contains("java");
		return result;
	}

	@Override
	public void initialize(Password arg0) {
	}
}
