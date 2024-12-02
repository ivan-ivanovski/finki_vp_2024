package mk.ukim.finki.wp.lab1.web.controller;

import mk.ukim.finki.wp.lab1.model.Event;
import mk.ukim.finki.wp.lab1.model.Location;
import mk.ukim.finki.wp.lab1.service.EventService;
import mk.ukim.finki.wp.lab1.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = {"","/","/events"})
public class EventController {
    public final EventService eventService;
    public final LocationService locationService;

    @Autowired
    public EventController(EventService eventService,LocationService locationService) {
        this.eventService = eventService;
        this.locationService=locationService;
    }

    @GetMapping
    public String getEventsPage(@RequestParam(required = false) String error, Model m ){
        List<Event> events = eventService.listAll();
        m.addAttribute("events",events);
        m.addAttribute("error",error);
        return "listEvents";
    }
    @GetMapping("/add")
    public String getAddEventPage(Model model) {
        List<Location> locations = locationService.listAllLocations();
        model.addAttribute("locations", locations);
        return "addEvent";  // addEvent.html
    }
    @PostMapping("/events/add")
    public String saveEvent(@RequestParam String eventName, @RequestParam String eventDescription, @RequestParam double eventPopularityScore, @RequestParam Long locationId){
        eventService.addEvent(eventName,eventDescription,eventPopularityScore,locationId);
        return "redirect:/listEvents";
    }
}
