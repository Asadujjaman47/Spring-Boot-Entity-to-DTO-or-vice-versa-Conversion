package com.asad.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "locationsDTO")
public class Location {

    @Id
    @GeneratedValue(generator="location_id_sequence")
    @SequenceGenerator(name="location_id_sequence",
            sequenceName="location_id_sequence", allocationSize=1)
    private long id;
    private String place;
    private String description;
    private double longitude;
    private double latitude;
}
