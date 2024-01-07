package fmi.pu.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "holiday")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Location location;
    private String title;
    private LocalDate startDate;
    private int duration;
    private float price;
    private int freeSlots;

}
