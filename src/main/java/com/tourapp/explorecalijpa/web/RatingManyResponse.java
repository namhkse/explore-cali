package com.tourapp.explorecalijpa.web;

import java.util.List;

import lombok.Data;

@Data
public class RatingManyResponse {
    private String status;

    private int count;

    private List<RatingDto> ratings;
}
