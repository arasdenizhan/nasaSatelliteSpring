package org.example.demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Builder
@Getter
@Setter
public class SatelliteDto {
    private Long id;
    private String satelliteId;
    private String name;
    private String date;
    private String line1;
    private String line2;
}
