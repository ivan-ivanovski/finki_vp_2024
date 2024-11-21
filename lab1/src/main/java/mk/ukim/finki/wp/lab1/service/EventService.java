package mk.ukim.finki.wp.lab1.service;

import mk.ukim.finki.wp.lab1.model.Event;

import java.util.List;

public interface EventService {
    List<Event> listAll();
    List<Event> searchEvent(String text);

}
