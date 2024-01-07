package fmi.pu.services.implementations;

import fmi.pu.models.DTOs.HolidayDTO;
import fmi.pu.models.Holiday;
import fmi.pu.models.Location;
import fmi.pu.repos.HolidayRepository;
import jakarta.annotation.Nullable;
import org.h2.util.StringUtils;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HolidayServiceImpl implements fmi.pu.services.HolidayService {
    private final HolidayRepository holidayRepository;


    public HolidayServiceImpl(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    @Override
    public Holiday createHoliday(HolidayDTO holiday)
    {
        Location location = new Location();
        location.setId(holiday.getLocation());
        Holiday holidayForRepo = Holiday.builder()
                .location(location)
                .title(holiday.getTitle())
                .startDate(holiday.getStartDate())
                .price(holiday.getPrice())
                .duration(holiday.getDuration())
                .freeSlots(holiday.getFreeSlots())
                .build();

       return holidayRepository.save(holidayForRepo);
    }

    @Override
    public Holiday findHolidayById(int id){
        return holidayRepository.findById(id).orElse(null);
    }

    @Override
    public List<Holiday> findHolidayByLocationDateDuration(@Nullable String location, @Nullable LocalDate date, @Nullable Integer duration)
    {
        List<Holiday> allHolidays = holidayRepository.findAll();
        List<Holiday> filteredHolidays = allHolidays.stream().filter(
                        w -> (StringUtils.isNullOrEmpty(location) ||
                                w.getLocation().getCity().contains(location) ||
                                w.getLocation().getCountry().contains(location)))
                .filter(w -> date == null || w.getStartDate().equals(date))
                .filter(w -> duration == null || w.getDuration() == duration).toList();

        return filteredHolidays;
    }
    @Override
    public Holiday editHoliday(int id, HolidayDTO holiday)
    {
        Holiday oldHoliday = this.findHolidayById(id);
        Location location = Location.builder().id(holiday.getLocation()).build();

        oldHoliday.setLocation(location);
        oldHoliday.setDuration(holiday.getDuration());
        oldHoliday.setPrice(holiday.getPrice());
        oldHoliday.setTitle(holiday.getTitle());
        oldHoliday.setStartDate(holiday.getStartDate());
        oldHoliday.setFreeSlots(holiday.getFreeSlots());
        return holidayRepository.save(oldHoliday);
    }
    @Override
    public void deleteHoliday(int id)
    {
        holidayRepository.deleteById(id);
    }
}
