package de.ait.timepad.services;

import de.ait.timepad.dto.*;
import de.ait.timepad.models.Event;

public interface EventsService {
    Event addEvent(NewEventDto newEvent);

    EventsDto getAllEvents(String email);
}
