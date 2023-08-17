package de.ait.taskslist.validation.validators;

import de.ait.taskslist.dto.NewTaskDto;
import de.ait.taskslist.validation.constraints.CorrectDates;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
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
            LocalDate startDate = LocalDate.parse(taskDto.getStartDate());
            LocalDate finishDate = LocalDate.parse(taskDto.getFinishDate());

            return startDate.isBefore(finishDate);
        } catch (RuntimeException e) {
            return false;
        }
    }
}
