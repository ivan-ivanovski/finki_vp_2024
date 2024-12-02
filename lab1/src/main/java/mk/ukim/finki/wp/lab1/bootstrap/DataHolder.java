package mk.ukim.finki.wp.lab1.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.wp.lab1.model.Event;
import mk.ukim.finki.wp.lab1.model.Location;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Event> events = null;

    public static List<Location> locations = null;
    @PostConstruct
    public void init(){

        locations = new ArrayList<>();
        locations.add(new Location("City Mall", "123 Main St, Springfield", "500", "A popular shopping destination with various stores and eateries."));
        locations.add(new Location("Mountain View Resort", "456 Mountain Rd, Aspen", "150", "A luxury resort offering a scenic view of the mountains."));
        locations.add(new Location("Downtown Conference Center", "789 Business Ave, Metropolis", "200", "A modern facility for corporate events and conferences."));
        locations.add(new Location("Sunny Beach Resort", "321 Ocean Dr, Miami", "350", "A beachfront resort offering various water activities and sunbathing."));
        locations.add(new Location("Tech Park", "101 Innovation Way, Silicon Valley", "1000", "A state-of-the-art office complex housing tech companies and startups."));


        events = new ArrayList<>();
        events.add(new Event("Music Festival", "A fun outdoor music festival with various artists.", 8.5,locations.get(0)));
        events.add(new Event("Food Expo", "A food expo showcasing dishes from around the world.", 9.0,locations.get(1)));
        events.add(new Event("Tech Conference", "Annual conference for tech enthusiasts.", 7.5,locations.get(2)));
        events.add(new Event("Art Exhibit", "Local artists displaying their latest works.", 6.0,locations.get(1)));
        events.add(new Event("Charity Run", "5K charity run to support local charities.", 8.0,locations.get(3)));
        events.add(new Event("Film Screening", "Independent film screening with Q&A.", 6.5,locations.get(4)));
        events.add(new Event("Book Fair", "Large fair with books from various genres and authors.", 7.0,locations.get(0)));
        events.add(new Event("Gaming Convention", "Convention for gaming fans with demos and contests.", 9.5,locations.get(4)));
        events.add(new Event("Yoga Workshop", "Outdoor yoga session for beginners and enthusiasts.", 5.0,locations.get(2)));
        events.add(new Event("Science Expo", "Interactive science exhibits and presentations.", 8.8,locations.get(3)));
    }
}
