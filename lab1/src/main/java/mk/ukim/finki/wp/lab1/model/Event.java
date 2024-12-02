package mk.ukim.finki.wp.lab1.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Event {
    private Long EventId;
    String name;
    String description;
    double popularityScore;
    private Location location;
    public Event(String name, String description, double popularityScore, Location location) {
        this.EventId = (long)(Math.random()*1000);
        this.name = name;
        this.description = description;
        this.popularityScore = popularityScore;
        this.location = location;
    }
}
