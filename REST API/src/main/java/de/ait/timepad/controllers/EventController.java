package de.ait.timepad.controllers;

import de.ait.timepad.dto.*;
import de.ait.timepad.models.Event;
import de.ait.timepad.services.EventsService;
import de.ait.timepad.services.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventsService eventsService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Event addEvent(@RequestBody NewEventDto newEvent) {

        return eventsService.addEvent(newEvent);
    }

    @GetMapping
    public EventsDto getAllEvents(String email) {

        return eventsService.getAllEvents(email);
    }
}

