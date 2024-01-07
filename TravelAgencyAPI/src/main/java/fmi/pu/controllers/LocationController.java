package fmi.pu.controllers;

import fmi.pu.models.Location;
import fmi.pu.services.LocationService;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("travel-agency/locations")
@CrossOrigin
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping("")
    public ResponseEntity<Object> createLocation(@RequestBody Location location){
        Location respLocation = locationService.createLocation(location.getStreet(),location.getNumber(),location.getCity(),location.getCountry());
        return new ResponseEntity<>( respLocation,HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<Location> getLocationById(@PathVariable Integer id){
        return new ResponseEntity<>(locationService.findLocationEntityById(id),HttpStatus.OK);
    }
    @GetMapping("")
    public ResponseEntity<List<Location>> getAllLocations(){
        return new ResponseEntity<>(locationService.findAllLocations(),HttpStatus.OK);
    }

    @PutMapping("")
    public ResponseEntity<Location> editLocation(@RequestBody Location location)
    {
        return new ResponseEntity<>(locationService.updateLocation(location.getId(),location),HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(value=HttpStatus.OK)
    public void deleteLocation(@PathVariable Integer id)
    {
        locationService.deleteLocation(id);
    }
}
