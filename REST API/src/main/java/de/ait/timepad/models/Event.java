package de.ait.timepad.models;

import de.ait.timepad.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 7/21/2023
 * REST API
 *
 * @author Marsel Sidikov (AIT TR)
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {

    public enum State {
        IS_DONE,
        IS_NOT_DONE,
        DELETED
    }
    private Long id;
    private String email;
    private String event;
    private State state;

    public static Event from(Event event) {
        return Event.builder()
                .id(event.getId())
                .email(event.getEmail())
                .state(event.getState())
                .build();
    }

    public static List<Event> from(List<Event> events) {
        return events.stream()
                .map(Event::from)
                .collect(Collectors.toList());
    }

}
