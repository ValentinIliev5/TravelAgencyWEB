package fmi.pu.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "reservation")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Holiday holiday;
    private String contactName;
    private String phoneNumber;
}
