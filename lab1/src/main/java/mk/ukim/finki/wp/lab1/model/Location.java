package mk.ukim.finki.wp.lab1.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Location {
    private Long LocationId;
    private String name;
    private String address;
    private String capacity;
    private String description;

    public Location(String name, String address, String capacity, String description) {
        this.LocationId = (long)(Math.random()*1000);
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.description = description;
    }
}
