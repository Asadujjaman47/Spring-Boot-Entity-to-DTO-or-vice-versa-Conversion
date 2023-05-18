package com.asad.dto;

import lombok.Data;

// this information send back to client
@Data
public class UserLocationDTO {
    private long userId;
    private String email;
    private String place;
    private double longitude;
    private double latitude;
}
