package de.ait.timepad.repositories;

import de.ait.timepad.models.Event;
import de.ait.timepad.models.User;

import java.util.List;

public interface EventsRepository {
    void save(Event event);

    List<Event> findAll();

    void clear();
}
