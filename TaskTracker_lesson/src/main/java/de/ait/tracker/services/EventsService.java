package de.ait.tracker.services;

import de.ait.tracker.dto.EventDto;
import de.ait.tracker.dto.NewEventDto;

import java.util.List;

public interface EventsService {
    List<EventDto> getAllEvents();

    EventDto addEvent(NewEventDto newEvent);
}

