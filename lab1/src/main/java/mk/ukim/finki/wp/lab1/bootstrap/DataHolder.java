package mk.ukim.finki.wp.lab1.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab1.model.Event;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events = null;
    @PostConstruct
    public void init(){
        this.events = new ArrayList<>();
        events.add(new Event("Music Festival", "A fun outdoor music festival with various artists.", 8.5));
        events.add(new Event("Food Expo", "A food expo showcasing dishes from around the world.", 9.0));
        events.add(new Event("Tech Conference", "Annual conference for tech enthusiasts.", 7.5));
        events.add(new Event("Art Exhibit", "Local artists displaying their latest works.", 6.0));
        events.add(new Event("Charity Run", "5K charity run to support local charities.", 8.0));
        events.add(new Event("Film Screening", "Independent film screening with Q&A.", 6.5));
        events.add(new Event("Book Fair", "Large fair with books from various genres and authors.", 7.0));
        events.add(new Event("Gaming Convention", "Convention for gaming fans with demos and contests.", 9.5));
        events.add(new Event("Yoga Workshop", "Outdoor yoga session for beginners and enthusiasts.", 5.0));
        events.add(new Event("Science Expo", "Interactive science exhibits and presentations.", 8.8));

    }
}
