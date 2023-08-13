package de.ait.taskslist.dto;

import de.ait.taskslist.validation.constraints.CorrectDates;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Добавляемая задача")
@CorrectDates
public class NewTaskDto {
    @Schema(description = "Задача", example = "Текст задачи...")
    private String description;

    @Schema(description = "Название задачи", example = "Название...")
    private String title;

    @Schema(description = "Дата начала выполнения задачи в формате YYYY-MM-DD", example = "2022-02-02")
    private String startDate;

    @Schema(description = "Дата окончания выполнения задачи в формате YYYY-MM-DD", example = "2022-02-02")
    private String finishDate;

    @Schema(description = "Идентификатор пользователя", example = "1")
    private Long aboutUserId;
}
