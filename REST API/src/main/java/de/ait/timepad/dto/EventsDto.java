package de.ait.timepad.dto;

import de.ait.timepad.models.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventsDto {
    private String email;
    private List<Event> events;
    private Integer count;
}
