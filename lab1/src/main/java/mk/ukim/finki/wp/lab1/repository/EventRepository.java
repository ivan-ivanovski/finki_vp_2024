package mk.ukim.finki.wp.lab1.repository;

import mk.ukim.finki.wp.lab1.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab1.model.Event;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventRepository {
    public List<Event> findALl(){
        return DataHolder.events;
    }
    public List<Event> searchEvent(String text){
        return DataHolder.events.stream().filter(event -> event.getName().equals(text)).toList();
    }
}
