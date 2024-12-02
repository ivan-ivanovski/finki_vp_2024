package mk.ukim.finki.wp.lab1.repository;

import mk.ukim.finki.wp.lab1.bootstrap.DataHolder;
import mk.ukim.finki.wp.lab1.model.Location;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationRepository {
    public List<Location> findAll(){
        return DataHolder.locations;
    }
}
