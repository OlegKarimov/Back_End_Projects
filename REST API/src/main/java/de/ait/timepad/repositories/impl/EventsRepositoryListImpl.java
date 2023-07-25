package de.ait.timepad.repositories.impl;

import de.ait.timepad.models.Event;
import de.ait.timepad.models.User;
import de.ait.timepad.repositories.EventsRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class EventsRepositoryListImpl implements EventsRepository {
    private static List<Event> events = new ArrayList<>();
    @Override
    public void save(Event event) {
        event.setId((long) events.size() + 1); // id - его порядковый номер в списке
        events.add(event);
    }

    @Override
    public List<Event> findAll() {
        return null;
    }

    @Override
    public void clear() {

    }
}
