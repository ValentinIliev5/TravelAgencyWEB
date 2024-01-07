package fmi.pu.models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {
    private int id;

    private String street;
    private int number;
    private String city;
    private String country;
}
