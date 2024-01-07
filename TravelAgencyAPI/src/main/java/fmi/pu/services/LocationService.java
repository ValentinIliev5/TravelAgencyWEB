package fmi.pu.services;

import fmi.pu.models.DTOs.LocationDTO;
import fmi.pu.models.Location;

import java.util.List;

public interface LocationService {

    Location createLocation(String street, int number,String city,String country);
    Location findLocationByStreet(String locationName);
    Location findLocationEntityById(int id);
    List<Location> findAllLocations();
    Location updateLocation(int locationId,Location updatedLocation);
    void deleteLocation(int locationId);
}
