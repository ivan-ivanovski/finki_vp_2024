package mk.ukim.finki.wp.lab1.service.impl;

import mk.ukim.finki.wp.lab1.model.Event;
import mk.ukim.finki.wp.lab1.repository.EventRepository;
import mk.ukim.finki.wp.lab1.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    public final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository){
        this.eventRepository=eventRepository;
    }
    @Override
    public List<Event> listAll() {
        return eventRepository.findALl();
    }

    @Override
    public List<Event> searchEvent(String text) {
        return eventRepository.searchEvent(text);
    }
}
