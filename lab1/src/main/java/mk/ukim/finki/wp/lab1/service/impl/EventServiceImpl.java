package mk.ukim.finki.wp.lab1.service.impl;

import mk.ukim.finki.wp.lab1.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab1.model.Event;
import mk.ukim.finki.wp.lab1.model.Location;
import mk.ukim.finki.wp.lab1.repository.EventRepository;
import mk.ukim.finki.wp.lab1.repository.LocationRepository;
import mk.ukim.finki.wp.lab1.service.EventService;
import mk.ukim.finki.wp.lab1.service.LocationService;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    public final EventRepository eventRepository;
    public final LocationRepository locationRepository;

    public EventServiceImpl(EventRepository eventRepository,LocationRepository locationRepository){
        this.eventRepository=eventRepository;
        this.locationRepository=locationRepository;
    }
    @Override
    public List<Event> listAll() {
        return eventRepository.findALl();
    }

    @Override
    public List<Event> searchEvent(String text) {
        return eventRepository.searchEvent(text);
    }

    @Override
    public Event addEvent(String eventName, String eventDescription, double eventPopularityScore, Long LocationId) {

        Location location = DataHolder.locations.stream()
                .filter(loc -> loc.getLocationId().equals(LocationId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Location with ID " + LocationId + " not found"));

        Event newEvent = new Event(eventName, eventDescription, eventPopularityScore, location);
        DataHolder.events.add(newEvent);
        return newEvent;
    }
}