package fmi.pu.models.DTOs;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ReservationDTO {
    private int id;
    private int holiday;
    private String phoneNumber;
    private String contactName;
}
