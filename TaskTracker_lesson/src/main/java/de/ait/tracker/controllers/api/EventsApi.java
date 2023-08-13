package de.ait.tracker.controllers.api;

import de.ait.tracker.dto.EventDto;
import de.ait.tracker.dto.NewEventDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/events")
public interface EventsApi {
    @GetMapping
    List<EventDto> getAllEvents();

    @PostMapping
    EventDto addEvent(@RequestBody NewEventDto newEvent);


}

