package de.ait.timepad.dto;

import de.ait.timepad.models.Event;
import lombok.Data;

@Data

public class NewEventDto {
    private String email;
    private String event;
}
