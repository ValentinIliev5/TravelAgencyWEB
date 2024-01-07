package fmi.pu.models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class HolidayDTO {

    private int id;
    private int location;
    private String title;
    private LocalDate startDate;
    private int duration;
    private float price;
    private int freeSlots;
}
