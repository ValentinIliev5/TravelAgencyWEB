package fmi.pu.controllers;

import fmi.pu.models.DTOs.HolidayDTO;
import fmi.pu.models.Holiday;
import fmi.pu.services.HolidayService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("travel-agency/holidays")
@CrossOrigin
public class HolidayController {

    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @PostMapping("")
    public ResponseEntity<Holiday> createHoliday(@RequestBody HolidayDTO holiday) {
        return ResponseEntity.ok(holidayService.createHoliday(holiday));
    }

    @GetMapping("{id}")
    public ResponseEntity<Holiday> getHolidayById(@PathVariable Integer id) {
        return ResponseEntity.ok(holidayService.findHolidayById(id));
    }

    @GetMapping("")
    public ResponseEntity<List<Holiday>> getAllHolidays(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) Integer duration) {
        return ResponseEntity.ok(holidayService
                .findHolidayByLocationDateDuration(location, startDate, duration));
    }

    @PutMapping("")
    public ResponseEntity<Holiday> editHoliday(@RequestBody HolidayDTO holiday) {
        return ResponseEntity.ok(holidayService.editHoliday(holiday.getId(), holiday));
    }

    @DeleteMapping("id")
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteHoliday(@PathVariable Integer id) {
        holidayService.deleteHoliday(id);
    }
}
