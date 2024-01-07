package fmi.pu.models.DTOs;

import fmi.pu.models.Location;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

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
