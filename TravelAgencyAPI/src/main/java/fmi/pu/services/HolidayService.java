package fmi.pu.services;

import fmi.pu.models.DTOs.HolidayDTO;
import fmi.pu.models.Holiday;
import jakarta.annotation.Nullable;

import java.time.LocalDate;
import java.util.List;

public interface HolidayService {
    Holiday createHoliday(HolidayDTO holiday);

    Holiday findHolidayById(int id);

    List<Holiday> findHolidayByLocationDateDuration(@Nullable String location, @Nullable LocalDate date, @Nullable Integer duration);

    Holiday editHoliday(int id, HolidayDTO holiday);

    void deleteHoliday(int id);
}
