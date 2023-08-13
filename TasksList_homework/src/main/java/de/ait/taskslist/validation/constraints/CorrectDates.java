package de.ait.taskslist.validation.constraints;

import de.ait.taskslist.validation.validators.TaskDatesValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TaskDatesValidator.class)
public @interface CorrectDates {

    String message() default "startDate must be earlier than finishDate";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
