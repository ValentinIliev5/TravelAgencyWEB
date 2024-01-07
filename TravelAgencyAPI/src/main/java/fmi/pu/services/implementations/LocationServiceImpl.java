package fmi.pu.services.implementations;

import fmi.pu.models.Location;
import fmi.pu.repos.LocationRepository;
import fmi.pu.services.LocationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public Location createLocation(String street, int number,String city,String country)
    {
        return locationRepository.save(new Location(street,number,city,country));
    }
    @Override
    public Location findLocationByStreet(String locationStreet) {
        return locationRepository.findByStreet(locationStreet).orElse(null);
    }

    @Override
    public Location findLocationEntityById(int id) {
       return locationRepository.findById(id).orElse(null);
    }

    @Override
    public List<Location> findAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location updateLocation(int locationId, Location updatedLocation) {
        Location oldLocation = this.findLocationEntityById(locationId);

        oldLocation.setCity(updatedLocation.getCity());
        oldLocation.setCountry(updatedLocation.getCountry());
        oldLocation.setNumber(updatedLocation.getNumber());
        oldLocation.setStreet(updatedLocation.getStreet());

        return locationRepository.save(oldLocation);

    }

    @Override
    public void deleteLocation(int locationId) {
       locationRepository.deleteById(locationId);
    }
}
