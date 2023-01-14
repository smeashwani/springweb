package springweb.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

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
