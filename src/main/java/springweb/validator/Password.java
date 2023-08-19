package springweb.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = PasswordConstraintValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
	// error message
	public String message() default "must contain java";

	// represents group of constraints
	public Class<?>[] groups() default {};

	// represents additional information about annotation
	public Class<? extends Payload>[] payload() default {};
}
