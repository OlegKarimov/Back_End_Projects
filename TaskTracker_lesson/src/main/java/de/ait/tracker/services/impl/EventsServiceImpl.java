package de.ait.tracker.services.impl;

import de.ait.tracker.dto.EventDto;
import de.ait.tracker.dto.NewEventDto;
import de.ait.tracker.models.Event;
import de.ait.tracker.repositories.EventsRepository;
import de.ait.tracker.services.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EventsServiceImpl implements EventsService {
    private final EventsRepository eventsRepository;

    @Override
    public List<EventDto> getAllEvents() {
        return null;
    }

    @Override
    public EventDto addEvent(NewEventDto newEvent) {
        Event event = Event.builder()
                .title(newEvent.getTitle())
                .description(newEvent.getDescription())
                .build();

        eventsRepository.save(event);

        return EventDto.from(event);
    }
}
