package de.ait.taskslist.validation.validators;

import de.ait.taskslist.dto.NewTaskDto;
import de.ait.taskslist.validation.constraints.CorrectDates;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalTime;

/**
 * 8/8/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class TaskDatesValidator implements ConstraintValidator<CorrectDates, NewTaskDto> {

    @Override
    public boolean isValid(NewTaskDto taskDto, ConstraintValidatorContext constraintValidatorContext) {
        try {
            LocalTime startDate = LocalTime.parse(taskDto.getStartDate());
            LocalTime finishDate = LocalTime.parse(taskDto.getFinishDate());

            return startDate.isBefore(finishDate);
        } catch (RuntimeException e) {
            return false;
        }
    }
}
