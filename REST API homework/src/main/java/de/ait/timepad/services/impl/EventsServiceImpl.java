package de.ait.timepad.services.impl;

import de.ait.timepad.dto.*;
import de.ait.timepad.models.Event;
import de.ait.timepad.repositories.EventsRepository;
import de.ait.timepad.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static de.ait.timepad.models.Event.from;

@RequiredArgsConstructor
@Service
public class EventsServiceImpl implements EventsService {
    private final EventsRepository eventsRepository;

    @Override
    public Event addEvent(NewEventDto newEvent) {
        Event event = Event.builder()
                .email(newEvent.getEmail())
                .name(newEvent.getEvent())
                .state(Event.State.IS_NOT_DONE).build();

        eventsRepository.save(event);

        return from(event);
    }


    @Override
    public EventsDto getAllEvents(String email) {
        List<Event> events = eventsRepository.findAll();
        return EventsDto.builder()
                .email(email)
                .events(from(events))
                .count(events.size())
                .build();
    }
}


